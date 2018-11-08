/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasion;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nere1
 */
public class Zombie extends Seres{

    private boolean meMuero = false, tengoHijo = false, meTocaMatar = false;
    int birth, nconvertidos, random;
    
    public Zombie(int birth){
        this.birth = birth;
    }

    public boolean MeTocaConvertir (){
        this.random = this.calcularRandom(1, 100);
        
        if(this.random <= 10){ // ME TOCA MAAAAAR
            meTocaMatar = true;
            this.nconvertidos++;
        }
        
        return meTocaMatar;
    }
    
    @Override
    public ArrayList meMuero(int dia, ArrayList listaTuTipo) {
        if((dia - this.birth) >= 8){ // ME TENGO QUE MORIR
            listaTuTipo.remove(this); // HAY QUE MIRAR ESTO NO SE SI ESTO DE BERDAD BORRA DE VDD LO QUE QUIERO
        }
            
        return listaTuTipo;
    }


    @Override
    public int calcularRandom(int desde, int hasta) {
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }

   
}
