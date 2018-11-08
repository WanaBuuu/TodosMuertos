/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasion;

import java.util.Random;

/**
 *
 * @author nere1
 */
public class Zombie extends Seres{

    private boolean meMuero = false, tengoHijo = false ;
    int birth;
    
    public Zombie(int birth){
        this.birth = birth;
    }

     @Override
    public boolean meMuero(int dia) {
        
    }


    @Override
    public int calcularRandom(int desde, int hasta) {
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }

   
}
