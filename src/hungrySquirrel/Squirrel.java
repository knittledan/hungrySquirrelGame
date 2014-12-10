/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hungrySquirrel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Knittle
 */
public class Squirrel extends Entity{

    boolean started = false;
    int collectedNuts = 0;
    int totalPoints;
    char landnigSpot;
    
    Squirrel(){
        symbol = '@';
        create();
    }
    
    @Override
    public void create() {       
         try{
            InputStreamReader fr = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(fr);
            String line;
            System.out.println("Enter the Squirrel position (x position,y position): ");
            
            while ((line = in.readLine()) != null){
                if (started){
                    executeCommand(line);
                    System.out.println("Enter commands u,d,l,r to move Up, Down, Left, and Right respectively: ");
                }
                else{
                    start(line);
                    if (started){
                        System.out.println("Enter commands u,d,l,r to move Up, Down, Left, and Right respectively: ");
                    }
                }
                if ( Nuts.maxNuts == collectedNuts ){
                    System.out.println("Squirrel successfully collected all the nuts. "
                                        + "Total points " + totalPoints
                                        + " Thank you for playing this game");
                    in.close();
                }
            }

        }
        catch (FileNotFoundException e) {

        }
        catch (IOException e) {

        }       
    }
    
    void start(String line){
        String[] xy = line.split(",");
        if ( xy.length == 2){
            try { 
                int xStart = Integer.parseInt(xy[0].trim());
                int yStart = Integer.parseInt(xy[1].trim());
                if (put(xStart, yStart) != '0'){
                    started = true;
                    System.out.println("User input accepted.");
                }else {
                    System.out.println("Posistion not avaliable. Try Again!");
                }
            } catch(NumberFormatException e){ 
                System.err.println("Incorrect formatting: \n "
               + "provide (x position,y position)");                   
            }
        } else {
            System.err.println("Incorrect formatting: \n "
            + "provide (x position,y position)");
        }
    }
    
    void moveLeft(){
        landnigSpot = put(x, y-1);
        arePoints(landnigSpot);
    }

    void moveRight(){
        landnigSpot = put(x, y+1);
        arePoints(landnigSpot);
    }


    void moveUp(){
        landnigSpot = put(x-1, y);
        arePoints(landnigSpot);
    }


    void moveDown(){
        landnigSpot = put(x+1, y);
        arePoints(landnigSpot);
    }
    
    void arePoints(char a){
        if ( Nuts.isNut(a) == 1 ){
            int points = Integer.parseInt(Nuts.existingNuts.get(a).toString());
            totalPoints += points;
            collectedNuts += 1;
        }
    }
    
    public void executeCommand(String command){
        switch (command) {
            case "u":
                moveUp();
                break;
            case "d":
                moveDown();
                break;
            case "l":
                moveLeft();
                break;
            case "r":
                moveRight();
                break;
            default:
                break;
        }
    }
}
