
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class GameSound {
	
	
	  //Plays Music
boolean on; 
static boolean explosion;
	
	  public void music(final boolean on)
	  {
		  new Thread(new Runnable(){
			  public void run(){
			  try{
				  
				  Clip song = AudioSystem.getClip();
				  AudioInputStream inputStream;
				  inputStream = AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream("song.wav"));
				  song.open(inputStream);
				  song.start();
				  
			  }
			  catch (Exception e){
			  System.out.println(e.getMessage());
			  
			  }
			  
		  }
		  }).start();
		  }
	  
	  
	  //Explosion Sound
	  
	  public void explosion(boolean explosion){
		  if(explosion){
			  
		  new Thread(new Runnable(){
	
		  public void run(){
		  try{
			  
			  Clip bomb = AudioSystem.getClip();
			  AudioInputStream inputStream;
			  inputStream =AudioSystem.getAudioInputStream(this.getClass().getResourceAsStream("bomb2.wav"));
			  bomb.open(inputStream);
			  bomb.start();
			  
		  }
		  catch (Exception e){
		  System.out.println(e.getMessage());
		  
		  }
		  
	  }
	  }).start();
		  
	  }}
	  
	  

}
