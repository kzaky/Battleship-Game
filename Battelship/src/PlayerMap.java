

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Phil
 */
public class PlayerMap {
    private static int[][] playerMap = new int[10][10];
    
    PlayerMap(){
        
    }
    
    public static void setMap(int startRow, int startColumn, int length, String orientation){
        if(orientation.equals("horizontal")){
            for(int i=0; i<length;i++){
                playerMap[startRow][startColumn+i]=length;
            }
        }
        else{
           for(int i=0; i<length;i++){
                playerMap[startRow+i][startColumn]=length;
            } 
        }
    }
    
    public static void resetMap(){
        for(int i=0; i<10; i++){
                for(int j=0; j<10;j++){
                    playerMap[i][j]=0;
                }
                }
    }
    
    public static int[][] getMap(){
        return playerMap;
    }
    
    public static boolean checkOverlap(int startRow, int startColumn, int length, String orientation){
        boolean overlap = false;
        try{
        if(orientation.equals("horizontal")){
            for(int i=0; i<length;i++){
                if(playerMap[startRow][startColumn+i]!=0){
                    overlap=true;
                }
            }
        }
        else{
           for(int i=0; i<length;i++){
                if(playerMap[startRow+i][startColumn]!=0){
                overlap=true;
            } 
           }
        }
        return overlap;
        }
        catch(ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    
    
    
    
    
    
    
}
