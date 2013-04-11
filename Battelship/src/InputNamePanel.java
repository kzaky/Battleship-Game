import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.FlowLayout;


public class InputNamePanel extends JPanel implements ActionListener{
  
  static String name;
  private JLabel msg;
  private JTextField inputField;
  private JButton okButton;
  
  InputNamePanel(){
  	setBackground(Color.DARK_GRAY);
    
    // Create GUI components
    msg = new JLabel("Enter your name then click OK to continue:");
    msg.setForeground(Color.GREEN);
    msg.setFont(new Font("ISOCTEUR", Font.PLAIN, 27));
    inputField = new JTextField(20);
    inputField.setBackground(Color.LIGHT_GRAY);
    inputField.setForeground(Color.RED);
    inputField.setFont(new Font("ISOCTEUR", Font.BOLD, 41));
    inputField.setEditable(true);
    okButton = new JButton("OK");
    okButton.setBackground(Color.RED);
    okButton.setFont(new Font("ISOCTEUR", Font.BOLD, 52));
    setLayout(new FlowLayout(FlowLayout.CENTER, 5, 150));
    
    // Construct component hierarchy
    this.add(msg);
    this.add(inputField);
    this.add(okButton);

    // Identify and register listeners with sources
    okButton.addActionListener(this);
  }
  
  public static String getInputName(){
    return name;
  }
  public void actionPerformed(ActionEvent event) {
    if (event.getSource() == okButton){
     InputNamePanel.name = inputField.getText();
     CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
     cardLayout.show(BShipMainMenu.theGame, "fleetPanel");
   }
 }

}
