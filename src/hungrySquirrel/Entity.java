/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hungrySquirrel;

import hungrySquirrel.Maze;
/**
 *
 * @author Knittle
 */
public abstract class Entity implements IEntity{
    static final int maxMazeRow    = 20;
    static final int maxMazeColumn = 50;
    
    char symbol;
    char returnSymbol;
    int x;
    int y;
    
    @Override
    public abstract void create();
    
    @Override
    public char put(int newX, int newY){
        if (Maze.avaliable(newX, newY)){
            returnSymbol = Maze.maze[newX][newY];
            Maze.maze[x][y] = ' ';
            Maze.maze[newX][newY] = symbol;
            x = newX;
            y = newY;
            if ( symbol == '@'){
                Maze.display();
            }
            return returnSymbol;
        }
        return '0';
    }
 
}
