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

    public int tengoQueComer(int birth){
        this.random = this.calcularRandom(1, 100); // ¿me toca comer?
        
        if (this.random >= 50){ // TENGO QUE COMEEER
            this.random = this.calcularRandom(1, 100); // voy a ver si tengo que matarlo o si lo voy a tranformar 
            if (this.random >= 50){ // HUMANO MUERE
                this.nmata++; // contamos aqui ya que mato un humano
                }
        }
        else{
            this.random = -50;   /** para que si no se mete en la condicion podemos saber que es por que no le tocaba comer y podamos diferenciar
                                     el random de si no toca comer al de si toca tranformar o matar*/
        }
        
       return this.random;
    }

    @Override
    public int calcularRandom(int desde, int hasta) {
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    @Override
    public ArrayList meMuero(int dia, ArrayList listaTuTipo) {
        
        listaTuTipo.remove(random);
        
        return listaTuTipo;
    }
}
