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
public class Vampiro extends Seres{

    private boolean meMuero = false, tengoHijo = false;
    private int nmata = 0, birth, random, tengoQueComer = -50;
    
    @Override
    public boolean meMuero() {
        
        return this.meMuero;
    }

    @Override
    public boolean tengoHijo(float temperatura) {
        
        return this.tengoHijo;
    }
    
    public ArrayList tengoQueComer(ArrayList <Humano> humanos, ArrayList <Vampiro> vampiros){
        Humano humanoAux = new Humano();
        
        this.random = this.calculoRandom();
        
        if (this.random >= 50){ // me toca comer
            this.random = this.calculoRandom(); // voy a ver si tengo que matarlo o si lo voy a tranformar
           
            if(humanos.isEmpty()){
                vampiros.remove(random);
            }
            
            if (this.random >= 50){ // lo mato 
                humanos.remove(random);
            }
            else{ // el humanose transforma
                /*humanoAux = humanos.get(random);
                vampiros.add();*/
            }
        }
        
        return humanos;
    }

    @Override
    public int calcularRandom(int desde, int hasta) {
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
}
