import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

class RulesPanel extends JPanel implements ActionListener {

  // Reference to the owner window.
  private BShipMainMenu app;

  // Components.
  private JPanel panel;
  private JLabel rule1, rule2, rule3;
  private JButton backButton;
  Container contentPane;
  JPanel oldPanel;
  JFrame frame;

  RulesPanel() {

    // Call to the superclass constructor.                            (1)
    super(); 
    setBackground(Color.DARK_GRAY);

    // Create GUI components.
    rule1 = new JLabel("1. Arrange your ships on \"Your Ships\" grid according to \"Fleet\" table");
    rule1.setForeground(Color.GREEN);
    rule1.setFont(new Font("ISOCTEUR", Font.PLAIN, 18));
    rule1.setBackground(Color.DARK_GRAY);
    rule2 = new JLabel("2. Take turns firing a salvo at your enemy by clicking on enemy squares");
    rule2.setForeground(Color.GREEN);
    rule2.setFont(new Font("ISOCTEUR", Font.PLAIN, 18));
    rule2.setBackground(Color.DARK_GRAY);
    rule3 = new JLabel("3. The game is over once a player has sunk all the other player's ships");
    rule3.setForeground(Color.GREEN);
    rule3.setFont(new Font("ISOCTEUR", Font.PLAIN, 18));
    rule3.setBackground(Color.DARK_GRAY);
    backButton = new JButton("Back to Main Menu");
    backButton.setFont(new Font("ISOCTEUR", Font.BOLD, 22));
    backButton.setForeground(Color.RED);
    backButton.setBackground(Color.LIGHT_GRAY);
    
    // Set up the GUI.
    this.setLayout(new GridLayout(4,1));
    this.add(rule1);
    this.add(rule2);
    this.add(rule3);
    this.add(backButton);


    backButton.addActionListener(this);

    // Show the GUI.
    setVisible(true);
  }
  
  // Method from the ActionListener interface.                      (4)
  public void actionPerformed(ActionEvent event) {
    CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
    cardLayout.show(BShipMainMenu.theGame, "mainMenu");
}
}

