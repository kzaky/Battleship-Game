import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;


class FleetPanel extends JPanel implements ActionListener {

  private static JLabel msg;
  private static JButton[][] shipButtons;
  private JCheckBox horizButton, vertButton;
  private JButton doneButton;
  private JPanel orientationPanel;
  private int shipLength;
  private String orientation;

  FleetPanel() {

      super();
      setBackground(Color.DARK_GRAY);
      PlayerMap.resetMap();
      shipLength = 5;
      orientation = "horizontal";
      
      // Create GUI components
      msg = new JLabel("Select orientation, then place ship of length 5: ");
      msg.setForeground(Color.GREEN);
      msg.setFont(new Font("ISOCTEUR", Font.BOLD, 23));
      shipButtons = new JButton[10][10];
      for(int i = 0; i<10; i++)
      {
          for(int j = 0; j<10; j++){
              shipButtons[i][j]=new JButton("");
              shipButtons[i][j].setBackground(Color.WHITE);
              shipButtons[i][j].setBounds(170 + j*45, 100 + i*45, 40, 40);
              this.add(shipButtons[i][j]);
              shipButtons[i][j].addActionListener(this);
          }
      }
      
      horizButton = new JCheckBox("Horizontal", true);
      horizButton.setForeground(Color.GREEN);
      horizButton.setFont(new Font("ISOCTEUR", Font.PLAIN, 18));
      horizButton.setBackground(Color.DARK_GRAY);
      vertButton = new JCheckBox("Vertical", false);
      vertButton.setForeground(Color.GREEN);
      vertButton.setFont(new Font("ISOCTEUR", Font.PLAIN, 18));
      vertButton.setBackground(Color.DARK_GRAY);
      ButtonGroup group = new ButtonGroup(); // used to ensure only one of horizButton or vertButton can be checked at one time
      group.add(horizButton);
      group.add(vertButton);
      orientationPanel = new JPanel();
      orientationPanel.setLayout(new GridLayout(2,1));      
      doneButton = new JButton("Done");
      doneButton.setForeground(Color.RED);
      doneButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
      doneButton.setBackground(Color.BLACK);
      doneButton.setVisible(false);

     
      // Construct the component hierarchy.
      
      orientationPanel.add(horizButton);
      orientationPanel.add(vertButton);  
      this.setLayout(new BorderLayout());
      this.add(msg, BorderLayout.NORTH);
      this.add(orientationPanel, BorderLayout.WEST);
      this.add(doneButton, BorderLayout.SOUTH);
      
      // Identify and register listeners with sources
      horizButton.addActionListener(this);
      vertButton.addActionListener(this);
      doneButton.addActionListener(this);

      // Show the GUI.
      setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == horizButton){
        orientation = "horizontal";
      } 
      else if (event.getSource() == vertButton){
        orientation = "vertical";
      } 
      else if (event.getSource() == doneButton){
        CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
        cardLayout.show(BShipMainMenu.theGame, "gamePanel");
      }     
      else  { // shipButton was clicked 
        JButton source = (JButton) event.getSource();
        int column = (source.getX()-170)/45; // calculates column index based on x-coordinate of click
        int row = (source.getY()-100)/45; // calculates row index based on y-coordinate of click
        if(shipLength>=1){
          msg.setText("Select orientation, then place ship of length " + (shipLength-1));
        }
        if (PlayerMap.checkOverlap(row, column, shipLength, orientation)){
          msg.setText("ERROR: Overlap occured. Click another starting position.");
        } 
        else{
          try {
            if (orientation.equals("horizontal")){
              for (int i = 0; i < shipLength; i++){
                shipButtons[row][column + i].setBackground(Color.ORANGE);
              }
            } else{
              for (int i = 0; i < shipLength; i++){
                shipButtons[row+i][column].setBackground(Color.ORANGE);
              }
            }
            PlayerMap.setMap(row, column, shipLength, orientation);
            shipLength--;
            if (shipLength == 0){
              doneButton.setVisible(true);
              msg.setText("Fleet organization complete. Click Done to proceed to game.");
              GamePanel.setPlayerMap(PlayerMap.getMap());
              GamePanel.colourPlayerMap();
            }
          }
          catch (ArrayIndexOutOfBoundsException e){
            msg.setText("ERROR: Ship starting in row " + (row+1) + " column " + (column+1) + " of length" + shipLength + 
            " is too big. Click another starting position");
            while (column < 10 && row < 10){
              shipButtons[row][column].setBackground(Color.WHITE);
              if (orientation.equals("horizontal")){
                column++;
              } else{
                row++;
              }
            }      
          }
        }
      }
    }
    
  }
