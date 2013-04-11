import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.SwingConstants;


public class ResultsPanel extends JPanel implements ActionListener{
  
  static String winner, loser;
  static JLabel title, winnerLabel, loserLabel;
  JButton mainMenuButton;
  
  ResultsPanel(){
  
    super(new GridLayout(4,1));
    setBackground(Color.DARK_GRAY);

    // Create GUI components
    title = new JLabel("Results");
    title.setHorizontalAlignment(SwingConstants.CENTER);
    title.setFont(new Font("ISOCTEUR", Font.BOLD, 30));
    title.setForeground(Color.GREEN);
    winnerLabel = new JLabel("Winner: " + winner);
    winnerLabel.setHorizontalAlignment(SwingConstants.CENTER);
    winnerLabel.setFont(new Font("ISOCTEUR", Font.PLAIN, 26));
    winnerLabel.setForeground(Color.GREEN);
    loserLabel = new JLabel("Loser: " + loser);
    loserLabel.setHorizontalAlignment(SwingConstants.CENTER);
    loserLabel.setFont(new Font("ISOCTEUR", Font.PLAIN, 26));
    loserLabel.setForeground(Color.GREEN);
    mainMenuButton = new JButton("Main Menu");
    mainMenuButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
    mainMenuButton.setForeground(Color.RED);
    mainMenuButton.setBackground(Color.LIGHT_GRAY);
    
    // Construct component hierarchy
    this.add(title);
    this.add(winnerLabel);
    this.add(loserLabel);
    this.add(mainMenuButton);

    // Identify and register listener with source
    mainMenuButton.addActionListener(this);
  }
  
  public static void setWinner(String winner){     
      ResultsPanel.winner=winner;
      winnerLabel.setText("Winner: " + winner);
  }
  
  public static void setLoser(String loser){
      ResultsPanel.loser=loser;
      loserLabel.setText("Loser: " + loser);
  }
  
  public void addStats(String winner){
    int win, loss;
    if(winner.equals("Computer")){
      win = 0;
      loss = 1;
      StatsIO.storeCurrentStats(win, InputNamePanel.getInputName(), loss);
      try {
        StatsPanel.stats.storeStats(InputNamePanel.getInputName());
      } catch (IOException e) {
        e.printStackTrace();
      }
     
    }
    else{
      win = 1;
      loss = 0;
      StatsIO.storeCurrentStats(win, InputNamePanel.getInputName(), loss);
      try {
        StatsPanel.stats.storeStats(InputNamePanel.getInputName());
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    BshipMainMenuClient.gui.updateStatsPane();
   }
  
  public void actionPerformed(ActionEvent event) {
    this.addStats(winner);
    CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
    cardLayout.show(BShipMainMenu.theGame, "mainMenu");
 }
  

 
 

}
