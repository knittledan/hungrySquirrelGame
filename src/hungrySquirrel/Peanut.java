/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hungrySquirrel;

/**
 *
 * @author Knittle
 */
public class Peanut extends Nuts{
    static final int nutritionPoints = 10;
    Peanut(){
        symbol = 'P';
        if ( !existingNuts.containsKey(symbol) ){
            existingNuts.put(symbol, this);
        }
    }
    
    @Override
    public String toString(){
        return nutritionPoints + "";
    }
    
}
