import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GamePanel extends JPanel implements ActionListener{

	private static boolean playerTurn = true;
    private static boolean computerTurn =false;
    private int compHitRow=0;
    private int compHitColumn=0;
    private boolean compHit = false;
    private static Opponent opponent = new Opponent();
	private static JButton[][] compMapButtons;
    private JButton pause;
	private static JButton[][] playerMapButtons;
	private static int[][] playerMap = new int[10][10];
	private static int[][] opponentMap = new int[10][10];
	private int[] shipCounter = new int[5];
	private int playerScore=0;
	private int computerScore=0;
	private JProgressBar progressBar;
	private JProgressBar progressBar_1;
    private static JLabel shipSunk;
    private static JLabel lblPlayer;
    private static JLabel lblPlayer_1;
    private static JLabel lblBtlshp;
    private JLabel[] horizontalLabels;
    private JLabel[] verticalLabels;
    private GameSound explosion;
        
	
        

	public GamePanel() {
		
            
		opponentMap = opponent.generateOpponentMap();
		
		//Title
		lblBtlshp = new JLabel("Battleship");
		lblBtlshp.setFont(new Font("ISOCTEUR", Font.PLAIN, 59));
		lblBtlshp.setForeground(Color.RED);
		
		//Panel Background
		
		this.setBackground(Color.DARK_GRAY);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		 //Progress Bars
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(15);
		progressBar.setBackground(Color.BLACK);
		progressBar.setForeground(Color.RED);
				
       
        
		progressBar_1 = new JProgressBar();
		progressBar_1.setValue(computerScore);
		progressBar_1.setMaximum(15);
		progressBar_1.setForeground(Color.RED);
		progressBar_1.setBackground(Color.BLACK);
		
		//Player Labels
		
		lblPlayer = new JLabel("Player");
		lblPlayer.setForeground(Color.LIGHT_GRAY);
		lblPlayer_1 = new JLabel("Computer");
		lblPlayer_1.setForeground(Color.LIGHT_GRAY);
                
		
		//Displays a message to the user if an opponent ship is sunk
		
        shipSunk = new JLabel(" ");
        shipSunk.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
        shipSunk.setBounds(250,600,1000,20);
        shipSunk.setForeground(Color.RED);
        shipSunk.setVisible(true);
        this.add(shipSunk);

        
        //Initialize sound
        explosion = new GameSound();
		//Cell labels
        
	horizontalLabels = new JLabel[10];
		
		
		for(int i = 1; i<11; i++){
			horizontalLabels[i-1]=new JLabel("" +i + "");
			horizontalLabels[i-1].setBounds(20 + 35, 100 + (i-1)*45, 40, 40);
			horizontalLabels[i-1].setForeground(Color.RED);
			this.add(horizontalLabels[i-1]);
			
			
		}
		
	verticalLabels = new JLabel[10];
		
		for(int i = 1; i<11; i++){
			
			verticalLabels[i-1]=new JLabel("" +i + "");
			verticalLabels[i-1].setBounds(80 + (i-1)*45, 45 + 25, 40, 40);
			verticalLabels[i-1].setForeground(Color.RED);
			this.add(verticalLabels[i-1]);
			
			
		}
		 
		
		//Generate Main Grid of hidden opponents board
		
		compMapButtons = new JButton[10][10];
		for(int i = 0; i<10; i++)
		{
			for(int j = 0; j<10; j++){
				compMapButtons[i][j]=new JButton("");
				compMapButtons[i][j].setBackground(Color.BLACK);
				compMapButtons[i][j].setBounds(70 + j*45, 100 + i*45, 40, 40);
			        this.add(compMapButtons[i][j]);
				compMapButtons[i][j].addActionListener(this);
			}
		}
		
		
		
		
		//Generate visualization of players fleet
		
		playerMapButtons = new JButton[10][10];
                
                
		for(int i = 0; i<10; i++){
			for( int j = 0; j<10; j++){
				playerMapButtons[i][j]=new JButton("");
				playerMapButtons[i][j].setBounds(570 + j*15, 400 + i*15, 15, 15);
				
				if(playerMap[i][j]==1){
	                playerMapButtons[i][j].setBackground(Color.BLUE);
				}
		
				else{
					playerMapButtons[i][j].setBackground(Color.BLACK);
				}
				
				this.add(playerMapButtons[i][j]);
				
				}
		}
                
		
		
		//Pause Button
		
		pause = new JButton("Pause");
		pause.setFont(new Font("ISOCTEUR", Font.BOLD, 18));
		pause.setBackground(Color.BLACK);
		pause.setForeground(Color.RED);
		pause.setBounds(600,600,150,30);
		pause.addActionListener(this);
		this.add(pause);
		
		
                
               
		
		//Absolute Layout built with Windowbuilder
                
                
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(52)
					.addComponent(lblBtlshp)
					.addGap(114)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlayer_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
						.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPlayer))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addComponent(lblBtlshp)
					.addGap(18)
					.addComponent(lblPlayer)
					.addGap(6)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(lblPlayer_1)
					.addGap(20)
					.addComponent(progressBar_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
		);
		this.setLayout(gl_contentPane);
		
		
	}
      
	
	
	//Loops thought the buttons and colours blue when there is a ship there 
	
	 
        public static void colourPlayerMap(){
            for(int i = 0; i<10; i++)
		{
			for( int j = 0; j<10; j++){
				if(playerMap[i][j]>0){
                                    playerMapButtons[i][j].setBackground(Color.BLUE);
                                }
                                else{
				playerMapButtons[i][j].setBackground(Color.BLACK);
                                }
				
			}
		}
        }
        
        
        
        public static void setPlayerMap(int[][] map){
            playerMap = map;
        }
        
        
	//All actions based on mouse click selection
        
        
     
        @Override
	public void actionPerformed(ActionEvent e) {
            shipSunk.setVisible(false);
            if(e.getSource()==pause){
                CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
                cardLayout.show(BShipMainMenu.theGame, "pausePanel");
            }
                
            else{
            	
                
            if(playerTurn){
            	
            	JButton button = (JButton) e.getSource();
            	int column = (button.getX()-70)/45;
            	int row =( button.getY()-100)/45;
			
            	if(opponentMap[row][column]>0){
            		explosion.explosion(true);
            		compMapButtons[row][column].setBackground(Color.RED);
            		shipCounter[(opponentMap[row][column])-1]++ ;
            		
            		
            			if(shipCounter[(opponentMap[row][column])-1]==(opponentMap[row][column])){
            				shipSunk.setText("Computer ship sunk!");
                          	shipSunk.setVisible(true);
            			}
            		opponentMap[row][column]=-1;
            		playerScore+=1;
            		progressBar.setValue(playerScore);
            	}
            	
            	if(opponentMap[row][column]==0){
            		compMapButtons[row][column].setVisible(false);
            	}
            	
                if(playerScore == 15){
                 ResultsPanel.setWinner(InputNamePanel.getInputName());
                 ResultsPanel.setLoser("Computer");
                 CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
                 cardLayout.show(BShipMainMenu.theGame, "resultsPanel");
	                
	            }
                
            }
		
            computerTurn = true;
            
            
            
            
            if(computerTurn){
                int compRow;
                int compColumn;
                int[] guessIndices = opponent.generateOpponentGuess(compHit, compHitRow, compHitColumn, playerMap);
                compRow = guessIndices[0];
                compColumn = guessIndices[1];
                         
        		
        		if(playerMap[compRow][compColumn]>0){
        			
                		explosion.explosion(true);
              			playerMapButtons[compRow][compColumn].setBackground(Color.RED);
              			computerScore +=1;
              			progressBar_1.setValue(computerScore);
                		  
        			
                    compHitRow =compRow;
                    compHitColumn = compColumn;
                    compHit = true;
        			
        			
        		}
        		
        		if(playerMap[compRow][compColumn]==0){
        			playerMapButtons[compRow][compColumn].setVisible(false);
        		}
        		
        		playerTurn=true;
        		playerMap[compRow][compColumn]=-1;
        		if(computerScore == 15){
              		ResultsPanel.setWinner("Computer");
                  	ResultsPanel.setLoser(InputNamePanel.getInputName());
                  	CardLayout cardLayout = (CardLayout) BShipMainMenu.theGame.getLayout();
                  	cardLayout.show(BShipMainMenu.theGame, "resultsPanel");
	                
	            }
            }
            
		
            }
	}
}
