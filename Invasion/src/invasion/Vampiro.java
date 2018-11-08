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
    
    public Vampiro(int birth){
        this.birth = birth;
    }
    
    @Override
    public boolean tengoHijo(float temperatura) {
        
        return this.tengoHijo;
    }
    
    public ArrayList tengoQueComer(ArrayList <Humano> humanos, ArrayList <Vampiro> vampiros, int birth){
        Vampiro vampiroAux;
        
        this.random = this.calcularRandom(1, 100); // ¿me toca comer?
        
        if (this.random >= 50){ // TENGO QUE COMEEER
            this.random = this.calcularRandom(1, 100); // voy a ver si tengo que matarlo o si lo voy a tranformar
           
            if(humanos.isEmpty()){ // ME MUERO POR NO COMER
                vampiros.remove(random);
            }
            
            if (this.random >= 50){ // HUMANO MUERE
                humanos.remove(random);
                this.nmata++;
            }
            else{ // HUMANO SE TRANSFORMA
                humanos.remove(random); // el humano deja de ser humano
                
                vampiroAux =  new Vampiro(birth); // creamos el nuevo vampiro
                vampiros.add(vampiroAux); 
            }
        }
        
        return humanos;
    }

    @Override
    public int calcularRandom(int desde, int hasta) {
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    @Override
    public boolean meMuero(int dia) {
        
        return this.meMuero;
    }
}
