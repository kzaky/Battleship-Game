
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.Font;

class PausePanel extends JPanel implements ActionListener {

  private JLabel msg;
  private JButton resumeButton, quitButton;

  PausePanel() {

      // Set a suitable title for the frame.
      super();
      setBackground(Color.DARK_GRAY);

      // Create GUI components
      msg = new JLabel("The game is paused ");      
      msg.setFont(new Font("ISOCTEUR", Font.PLAIN, 22));
      msg.setForeground(Color.GREEN);
      resumeButton = new JButton("Resume");
      resumeButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
      resumeButton.setForeground(Color.RED);
      resumeButton.setBackground(Color.BLACK);
      quitButton = new JButton("Quit");
      quitButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
      quitButton.setForeground(Color.RED);
      quitButton.setBackground(Color.BLACK);
      setLayout(new FlowLayout(FlowLayout.CENTER, 5, 300));
     
      // Construct the component hierarchy.
      
      this.add(msg);
      this.add(resumeButton);
      this.add(quitButton);
      
      // Add actionListeners
      
      resumeButton.addActionListener(this);
      quitButton.addActionListener(this);

      // Show the GUI.
      setVisible(true);
    }
    

    public void actionPerformed(ActionEvent event) {
      if (event.getSource() == resumeButton){
        CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
        cardLayout.show(BShipMainMenu.theGame, "gamePanel");
      }
      else {
        CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
        cardLayout.show(BShipMainMenu.theGame, "mainMenu");   
      }
    }

    }
