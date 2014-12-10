/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hungrySquirrel;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Knittle
 */
public abstract class Nuts extends Entity{
    static final int maxNuts = 5;
    static HashMap<Character, Object> existingNuts = new HashMap<Character, Object>();
    
    @Override
    public void create(){
        Random r = new Random();
        for (int i = 0; i < maxNuts; i++){
            int mazeRow = r.nextInt(maxMazeRow) + 1;
            int mazeColumn = r.nextInt(maxMazeColumn) + 1;   
            int randomize = r.nextInt(100) + 1;

            if ( Maze.avaliable(mazeRow, mazeColumn)){
                
            if (randomize < 50){
                Peanut nut = new Peanut();
                nut.put(mazeRow, mazeColumn);
            }else{
                Almond nut = new Almond();
                nut.put(mazeRow, mazeColumn);
            }
            }
            else {
                i--;
            }
        }

        
        
    }
    
    static int isNut(char symbol){
        if ( existingNuts.containsKey(symbol) ){
            return 1;
        }
        else {
            return 0;
        }
    }
}
