
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phil
 */
public class Opponent {
    private int[][] opponentMap;
    private static Random generator = new Random();
    
    Opponent(){
        
    }
    
    
    public int[][] generateOpponentMap(){
        opponentMap = new int[10][10];
        boolean failcheck;
        for(int i = 0 ; i < 5; i++){
		        failcheck = true;
		        int oppRow;
		        int oppColumn;
		        int oppOrientation;
		        while(failcheck){
	                    failcheck=false;
		        	   oppOrientation = generator.nextInt(2);
		        	if(oppOrientation == 0){
		        		oppRow = generator.nextInt(10);
		        		oppColumn = generator.nextInt(10-i);
		        	}
		        	else{
		        		oppRow = generator.nextInt(10-i);
		        		oppColumn = generator.nextInt(10);
		        	}
		        	for(int j = 0; j<=i; j++){
		        		if(oppOrientation == 0){
		        			if(opponentMap[oppRow][oppColumn+j]>0){
			        			failcheck =true;
			        		}
		        		}
		        		else{
		        			if(opponentMap[oppRow+j][oppColumn]>0){
			        			failcheck =true;
			        		}
		        		}
		        		
		        	}
		        	
		        	if(!failcheck){
		        		for(int j = 0; j<=i; j++){
			        		if(oppOrientation == 0){
			        			opponentMap[oppRow][oppColumn+j]=i+1;
				        		}
			        		
			        		else{
			        			opponentMap[oppRow+j][oppColumn]=i+1;
				        		}
			        		}
			        		
			        	}
		        	}		
		    }
        return opponentMap;
    }
    
    public int[] generateOpponentGuess(boolean prevHit, int prevHitRow, int prevHitColumn, int[][] playerMap){
        int[] indices = new int[10];
        int compRow;
        int compColumn;
        if(!prevHit){
        	
           
        
        do{
				compRow = generator.nextInt(10);
				System.out.println(compRow);
        		        compColumn = generator.nextInt(10);
        		        System.out.println(compColumn);
                                }while(playerMap[compRow][compColumn]==-1);
        }
        else{
            if(((prevHitColumn-1)>=0)&& (playerMap[prevHitRow][prevHitColumn-1]!=-1)){
                compRow = prevHitRow;
                compColumn = prevHitColumn-1;
                
            }
            else if(((prevHitRow-1)>=0)&& (playerMap[prevHitRow-1][prevHitColumn]!=-1)){
                compRow = prevHitRow-1;
                compColumn = prevHitColumn;
                
            }
            else if(((prevHitColumn+1)<=9)&& (playerMap[prevHitRow][prevHitColumn+1]!=-1)){
                compRow = prevHitRow;
                compColumn = prevHitColumn+1;
                
            }
            else if(((prevHitRow+1)<=9)&& (playerMap[prevHitRow+1][prevHitColumn]!=-1)){
                compRow = prevHitRow+1;
                compColumn = prevHitColumn;
                
            }
            else{
                do{
				compRow = generator.nextInt(10);
				System.out.println(compRow);
        		        compColumn = generator.nextInt(10);
        		        System.out.println(compColumn);
                                }while(playerMap[compRow][compColumn]==-1);
                
            }
        }
        indices[0]=compRow;
        indices[1]=compColumn;
       
        return indices;
        
    }
    
}
