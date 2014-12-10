/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hungrySquirrel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Knittle
 */
public final class Maze {
    static final int maxMazeRow    = 20;
    static final int maxMazeColumn = 50;
    static char[][] maze;
        
    String fileName = "Maze.txt";
    
    Maze(){
        Maze.maze = new char[maxMazeRow][maxMazeColumn];
        create(fileName);
    }
    
    void create(String fileName){
        try {
            String line;
            BufferedReader br;
            br = new BufferedReader(new FileReader(fileName));
            int num = 0;
            while ((line = br.readLine()) != null) {
                maze[num] = line.toCharArray();
                num++;
                if (num > maxMazeRow){
                    break;
                }
            }
            br.close();

        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    static void display(){
        for (char[] mazeRow : maze) {
            System.out.println(mazeRow);
        }
    }
    
    static boolean avaliable(int row, int col){
        if ( row >= maxMazeRow || col >= maxMazeColumn){
            return false;
        }
        if ( row < 0 || col < 0){
            return false;
        }
        return (maze[row][col] != '*');
    }
    
}
