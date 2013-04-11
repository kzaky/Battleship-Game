import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class StatsIO {

	static ArrayList<String> currentStats = new ArrayList<String>();
	
	public ArrayList<String> storedNames = new ArrayList<String>();
	public ArrayList<Integer> storedWins = new ArrayList<Integer>();
	public ArrayList<Integer> storedLosses = new ArrayList<Integer>();

	public static void storeCurrentStats(Integer wins, String name, Integer losses){
		currentStats.clear();
		currentStats.add(wins.toString());
		currentStats.add(name);
		currentStats.add(losses.toString());
		}
	
	public void readStats(){
		
		storedNames.clear();
		storedLosses.clear();
		storedWins.clear();
		
		BufferedReader br = null;
		String readLine;
		try {
			br = new BufferedReader(new FileReader("stats.txt"));
			
			while  ((readLine = br.readLine()) != null){
								
				StringTokenizer st = new StringTokenizer(readLine);
				
				storedWins.add(Integer.parseInt(st.nextToken("|")));
				storedNames.add(st.nextToken("|"));
				storedLosses.add(Integer.parseInt(st.nextToken("|")));
				
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e2){
			e2.printStackTrace();
		}
		
	}
	
	public boolean playerExists(String name){
		boolean playerExists = false;
		for(int i=0; i<storedNames.size(); i++){
			if (name.equals(storedNames.get(i))){
				playerExists = true;
			}
		}
		return playerExists;
	}
	

	public void storeStats(String name) throws IOException{
				
		if (playerExists(name)){
			


			//update the players score
			int playerIndex = getPlayerIndex(name);
			
			storedWins.set(playerIndex, Integer.parseInt(currentStats.get(0)) + storedWins.get(playerIndex));
			storedLosses.set(playerIndex, Integer.parseInt(currentStats.get(2)) + storedLosses.get(playerIndex));
			
			
			try {
			    BufferedWriter out = new BufferedWriter(new FileWriter("stats.txt", false));
			    for (int i = 0; i < storedNames.size(); i++){
					out.write(storedWins.get(i) + "|" + storedNames.get(i) + "|" + storedLosses.get(i));
					out.newLine();
			    }
			    out.close();
			} catch (IOException e) {
			}
			

		}else{
			//just write the users data to a new file
			
			//append the current stats of the player to the end of the stored stats arrays and write it to file
			storedNames.add(currentStats.get(1));
			storedWins.add(Integer.parseInt(currentStats.get(0)));
			storedLosses.add(Integer.parseInt(currentStats.get(2)));
			
				
				try{
					
						FileWriter fstream = new FileWriter("stats.txt");
						BufferedWriter out = new BufferedWriter(fstream);
						for (int i = 0; i < storedNames.size(); i++){

							out.append(storedWins.get(i) + "|" + storedNames.get(i) + "|" + storedLosses.get(i));
							out.newLine();
							
						}
						out.close();
					}catch (Exception e){
						
						System.out.println("Error writing stats to file");
						
					}
				
			}
			
			
		
		
	}
	
	//returns player index given the name using a linear search
	public int getPlayerIndex(String name){
		
		for (int i = 0; i<storedNames.size(); i++){
			if (name.equals(storedNames.get(i))){
				return i;
			}
		}
		
		return -1;
		
	}

	//remove the selected player from the statistics
	public void removePlayer(String name){

		for (int i = 0; i<storedNames.size(); i++){
			if (name.equals(storedNames.get(i))){
				storedNames.remove(i);
				storedWins.remove(i);
				storedLosses.remove(i);
				
				storedNames.trimToSize();
				storedWins.trimToSize();
				storedLosses.trimToSize();
				
				break;
			}
		}
	}
	
	//write array contents to file
	public void updateStatsFile() throws IOException{
		
		FileWriter fstream = new FileWriter("stats.txt");
		BufferedWriter out = new BufferedWriter(fstream);
		
		for (int i = 0; i < storedNames.size(); i++){
			
			try{
					out.write(storedWins.get(i) + "|" + storedNames.get(i) + "|" + storedLosses.get(i));
					out.newLine();
					
				}catch (Exception e){
					
					System.out.println("Error writing stats to file");
					
				}
			
		}
		
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
