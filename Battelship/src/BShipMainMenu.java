import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Font;


class BShipMainMenu extends JFrame implements ActionListener {    // (1)

  // Components
  private JBackgroundPanel mainMenu;
  private JButton newGameButton, statsButton, rulesButton, quitButton;
  InputNamePanel inputNamePanel;
  private FleetPanel fleetPanel;
  private GamePanel gamePanel;
  private PausePanel pausePanel;
  private ResultsPanel resultsPanel;
  private  RulesPanel rulesPanel;
  private StatsPanel statsPane;
  static JPanel theGame;
  private GameSound bgMusic;
  CardLayout cardLayout;


  BShipMainMenu() {
	  
	  
    // Set suitable title for the frame.
    super("Battleship Main Menu");
    this.setPreferredSize(new Dimension(1050, 675));
    statsPane = new StatsPanel();
    
    // Create GUI components.
    
    
    mainMenu = new JBackgroundPanel();
    newGameButton = new JButton("New Game");
    newGameButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
    newGameButton.setForeground(Color.RED);
    newGameButton.setBackground(Color.BLACK);
    statsButton = new JButton("Stats");
    statsButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
    statsButton.setForeground(Color.RED);
    statsButton.setBackground(Color.BLACK);
    rulesButton = new JButton("Rules");
    rulesButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
    rulesButton.setForeground(Color.RED);
    rulesButton.setBackground(Color.BLACK);
    quitButton = new JButton("Quit");   
    quitButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
    quitButton.setForeground(Color.RED);
    quitButton.setBackground(Color.BLACK);
    rulesPanel = new RulesPanel();   
    cardLayout = new CardLayout();
    theGame = new JPanel(cardLayout);
    mainMenu.setLayout(new FlowLayout(FlowLayout.CENTER,5 , 600));
    mainMenu.setVisible(true);
    
    //Create Game Sound
    
    bgMusic = new GameSound();
    bgMusic.music(true);
    
    
    
    
   
    // Construct the component hierarchy.
    
    mainMenu.add(newGameButton);
    mainMenu.add(statsButton);
    mainMenu.add(rulesButton);
    mainMenu.add(quitButton);
    theGame.add(mainMenu);
    theGame.add(rulesPanel);
    cardLayout.addLayoutComponent(mainMenu, "mainMenu");
    cardLayout.addLayoutComponent(rulesPanel, "rulesPanel");  
    getContentPane().add(theGame);

    // Register the frame as listener with the buttons
    // to receive ActionEvents.
    newGameButton.addActionListener(this);                    
    statsButton.addActionListener(this);                            
    rulesButton.addActionListener(this);                            
    quitButton.addActionListener(this);                            

    // Terminate if the frame is closed.
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Show the GUI.
    pack();
    this.setVisible(true);
  }
  
  
  public void updateStatsPane(){
    statsPane.populateStats();
  }
 
  
  

  public void actionPerformed(ActionEvent event) {  
    if (event.getSource() == newGameButton) {
    inputNamePanel = new InputNamePanel();
    fleetPanel = new FleetPanel();
    gamePanel = new GamePanel();  
    resultsPanel = new ResultsPanel();
    pausePanel = new PausePanel();
    theGame.add(inputNamePanel);
    theGame.add(fleetPanel);
    theGame.add(gamePanel);
    theGame.add(pausePanel);
    theGame.add(resultsPanel);
    cardLayout.addLayoutComponent(inputNamePanel, "inputNamePanel");  
    cardLayout.addLayoutComponent(fleetPanel, "fleetPanel");
    cardLayout.addLayoutComponent(gamePanel, "gamePanel");
    cardLayout.addLayoutComponent(pausePanel, "pausePanel");
    cardLayout.addLayoutComponent(resultsPanel, "resultsPanel");
    cardLayout.show(BShipMainMenu.theGame, "inputNamePanel");
    
    } else if (event.getSource() == statsButton) {
      theGame.add(statsPane);
      cardLayout.addLayoutComponent(statsPane, "Stats Panel");
      cardLayout.show(BShipMainMenu.theGame, "Stats Panel");
      
    } else if (event.getSource() == rulesButton) {
      cardLayout.show(BShipMainMenu.theGame, "rulesPanel");
      
    }else { 
      dispose();
      System.exit(0);
    }
  }
}