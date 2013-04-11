import java.io.IOException;
import javax.swing.JFrame;


public class StatsTest {

	StatsIO stats = new StatsIO();
	
	  public void readStatsTest(){
		  stats.readStats();
		  for (int i=0; i < stats.storedNames.size(); i++){
			  System.out.println(stats.storedNames.get(i) + "\t" + stats.storedWins.get(i) + "\t" + stats.storedLosses.get(i));
		  }
	  }
	  //The currentStats array list is set to private but is changed to public for testing purposes
	  public void storeCurrentStatsTest(){
		  stats.storeCurrentStats(1, "Jake", 0);
		  System.out.println(stats.currentStats.get(1) + "\t" + stats.currentStats.get(0) + "\t" + stats.currentStats.get(2));
	  }

	  public void playerExistsTest1(){
		  stats.readStats();
		  System.out.println(stats.playerExists("Josh"));
	  }

	  public void playerExistsTest2(){
		  stats.readStats();
	    System.out.println(stats.playerExists("fdssdfsdf"));
	  }
	  

	  

	  
	  public void storeStatsTest1(){
		  stats.readStats();
		  stats.storeCurrentStats(1, "Jake", 0);
		  try {
	      stats.storeStats("Nick");
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		  for (int i=0; i < stats.storedNames.size(); i++){
		      System.out.println(stats.storedNames.get(i) + "\t" + stats.storedWins.get(i) + "\t" + stats.storedLosses.get(i));
		  }
	  }
	  
	  public void storeStatsTest2(){
		  stats.readStats();
		  stats.storeCurrentStats(1, "Nick", 0);
		try {
	      stats.storeStats("Nick");
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		  for (int i=0; i < stats.storedNames.size(); i++){
		      System.out.println(stats.storedNames.get(i) + "\t" + stats.storedWins.get(i) + "\t" + stats.storedLosses.get(i));
		  }
	  }
	  
	  public void getPlayerIndexTest1(){
		  stats.readStats();
		  System.out.println(stats.getPlayerIndex("Fady"));
		  
	  }
	  
	  public void getPlayerIndexTest2(){
		  stats.readStats();
		  System.out.println(stats.getPlayerIndex("George"));
	  }

	  public void removePlayerTest1(){
		  stats.readStats();
		  stats.removePlayer("aaaaaaa");
		  for (int i=0; i < stats.storedNames.size(); i++){
		    System.out.println(stats.storedNames.get(i) + "\t" + stats.storedWins.get(i) + "\t" + stats.storedLosses.get(i));
		  }  
	  }
	  
	  public void removePlayerTest2(){
		  stats.readStats();
		  stats.removePlayer("Steve");
		  for (int i=0; i < stats.storedNames.size(); i++){
		    System.out.println(stats.storedNames.get(i) + "\t" + stats.storedWins.get(i) + "\t" + stats.storedLosses.get(i));
		  }  
	  }

	  public void updateStatsFileTest(){
		  stats.readStats();
		  stats.storeCurrentStats(0, "f", 1);
		  try {
	      stats.storeStats("f");
		  } catch (IOException e) {
	      e.printStackTrace();
		  }
		  
		  try {
		      stats.updateStatsFile();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  
	  }

}
