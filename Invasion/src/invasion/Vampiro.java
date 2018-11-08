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
        this.random = this.calculoRondom();
        
        if (this.random >= 50){ // me toca comer
            this.random = this.calculoRondom(); // voy a ver si tengo que matarlo o si lo voy a tranformar
           
            if(humanos.isEmpty()){
                // tengo que morir 
            }
            
            if (this.random >= 50){ // lo mato 
                humanos.remove(random);
            }
            else{
                
            }
        }
        
        return humanos;
    }
    
    /** EN ESTE CASO LAS PROBABILIDADES DE CUALQUIER COSA QUE TENGA QUE HACER EL VAMPIRO SON DEL 50 POR LO QUE NO ES NECESARIO
     PASARLE LOS PARAMETROS DESDE HASTA*/
    public final int calculoRondom(){
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(100-1+1) + 1;
    }
}
