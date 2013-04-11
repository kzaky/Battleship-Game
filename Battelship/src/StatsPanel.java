import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class StatsPanel extends JPanel {

	static StatsIO stats = new StatsIO();
	
	private JLabel lblFirstPlace;
	private JLabel lblSecondPlace;
	private JLabel lblThirdPlace;
	
	private JLabel wins1;
	private JLabel losses1;
	private JLabel wins2;
	private JLabel losses2;
	private JLabel wins3;
	private JLabel losses3;
	private JButton button;
	private JButton button_1;
	private JButton btnNewButton;
	private final Action action = new SwingAction();
	
	public StatsPanel() {
		setForeground(Color.GREEN);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		lblFirstPlace = new JLabel("No Player");
		lblFirstPlace.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		lblFirstPlace.setForeground(Color.GREEN);
		lblFirstPlace.setBounds(195, 289, 164, 16);
		add(lblFirstPlace);
		
		lblSecondPlace = new JLabel("No Player");
		lblSecondPlace.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		lblSecondPlace.setForeground(Color.GREEN);
		lblSecondPlace.setBounds(195, 322, 164, 16);
		add(lblSecondPlace);
		
		lblThirdPlace = new JLabel("No Player");
		lblThirdPlace.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		lblThirdPlace.setForeground(Color.GREEN);
		lblThirdPlace.setBounds(195, 355, 164, 16);
		add(lblThirdPlace);
		
		JLabel lblWins = new JLabel("Wins");
		lblWins.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		lblWins.setForeground(Color.GREEN);
		lblWins.setBounds(369, 265, 113, 16);
		add(lblWins);
		
		JLabel lblLosses = new JLabel("Losses");
		lblLosses.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		lblLosses.setForeground(Color.GREEN);
		lblLosses.setBounds(492, 265, 94, 16);
		add(lblLosses);
		
		JButton btnClearStats = new JButton("Clear Stats");
		btnClearStats.setForeground(Color.RED);
		btnClearStats.setFont(new Font("ISOCTEUR", Font.BOLD, 20));
		btnClearStats.setBackground(Color.BLACK);
		btnClearStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				stats.removePlayer(lblFirstPlace.getText());
				
				try {
					stats.updateStatsFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				populateStats();
				
			}
		});
		btnClearStats.setBounds(585, 284, 259, 29);
		add(btnClearStats);
		
		wins1 = new JLabel("0");
		wins1.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		wins1.setForeground(Color.GREEN);
		wins1.setBounds(369, 289, 78, 16);
		add(wins1);
		
		losses1 = new JLabel("0");
		losses1.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		losses1.setForeground(Color.GREEN);
		losses1.setBounds(492, 289, 34, 16);
		add(losses1);
		
		wins2 = new JLabel("0");
		wins2.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		wins2.setForeground(Color.GREEN);
		wins2.setBounds(369, 322, 78, 16);
		add(wins2);
		
		losses2 = new JLabel("0");
		losses2.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		losses2.setForeground(Color.GREEN);
		losses2.setBounds(492, 322, 34, 16);
		add(losses2);
		
		wins3 = new JLabel("0");
		wins3.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		wins3.setForeground(Color.GREEN);
		wins3.setBounds(369, 355, 78, 16);
		add(wins3);
		
		losses3 = new JLabel("0");
		losses3.setFont(new Font("ISOCTEUR", Font.PLAIN, 19));
		losses3.setForeground(Color.GREEN);
		losses3.setBounds(492, 355, 34, 16);
		add(losses3);
		
		button = new JButton("Clear Stats");
		button.setForeground(Color.RED);
		button.setFont(new Font("ISOCTEUR", Font.BOLD, 20));
		button.setBackground(Color.BLACK);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stats.removePlayer(lblSecondPlace.getText());
				
				try {
					stats.updateStatsFile();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				
				populateStats();
			}
		});
		button.setBounds(585, 317, 259, 29);
		add(button);
		
		button_1 = new JButton("Clear Stats");
		button_1.setForeground(Color.RED);
		button_1.setFont(new Font("ISOCTEUR", Font.BOLD, 20));
		button_1.setBackground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stats.removePlayer(lblThirdPlace.getText());
				
				try {
					stats.updateStatsFile();
				} catch (IOException e3) {
					e3.printStackTrace();
				}
				
				populateStats();
			}
		});
		button_1.setBounds(585, 350, 259, 29);
		add(button_1);
		
		
		
		//Back Button
		btnNewButton = new JButton("Main Menu");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
		        cardLayout.show(BShipMainMenu.theGame, "mainMenu"); 
			}
		});
		btnNewButton.setBounds(436, 466, 182, 23);
		add(btnNewButton);
	
		populateStats();
	}
	
	public void populateStats(){
		
		stats.readStats();
		statsFiller();

		bubbleSort(stats.storedWins, stats.storedWins.size());

		lblFirstPlace.setText(stats.storedNames.get(0));
		lblSecondPlace.setText(stats.storedNames.get(1));
		lblThirdPlace.setText(stats.storedNames.get(2));

		wins1.setText(stats.storedWins.get(0).toString());
		wins2.setText(stats.storedWins.get(1).toString());
		wins3.setText(stats.storedWins.get(2).toString());
		
		losses1.setText(stats.storedLosses.get(0).toString());
		losses2.setText(stats.storedLosses.get(1).toString());
		losses3.setText(stats.storedLosses.get(2).toString());

		
	}
	
	private static void bubbleSort(ArrayList<Integer> a, int n){
		int i, j, t, t3 = 0;
		String t2;
		for(i = 0; i < n; i++){
			for(j = 1; j < (n-i); j++){
				if(a.get(j-1) > a.get(j)){
					t = a.get(j-1);
					t2 = stats.storedNames.get(j-1);
					t3 = stats.storedLosses.get(j-1);
					a.set(j-1, a.get(j));
					stats.storedNames.set(j-1, stats.storedNames.get(j));
					stats.storedLosses.set(j-1, stats.storedLosses.get(j));
					a.set(j, t);
					stats.storedNames.set(j, t2);
					stats.storedLosses.set(j, t3);
				}
			}
		}
		
		Collections.reverse(stats.storedNames);
		Collections.reverse(stats.storedWins);
		Collections.reverse(stats.storedLosses);
		
	}
	
	private static void statsFiller(){
		if (stats.storedNames.size() == 0){
			
			stats.storedNames.add("No Player");
			stats.storedNames.add("No Player");
			stats.storedNames.add("No Player");
			
			stats.storedLosses.add(0);
			stats.storedLosses.add(0);
			stats.storedLosses.add(0);

			stats.storedWins.add(0);
			stats.storedWins.add(0);
			stats.storedWins.add(0);
			
		}else if (stats.storedNames.size() == 1){
			stats.storedNames.add("No Player");
			stats.storedNames.add("No Player");
			
			stats.storedLosses.add(0);
			stats.storedLosses.add(0);

			stats.storedWins.add(0);
			stats.storedWins.add(0);
		}else if (stats.storedNames.size() == 2){
			stats.storedNames.add("No Player");
			
			stats.storedLosses.add(0);

			stats.storedWins.add(0);
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
