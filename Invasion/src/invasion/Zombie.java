/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasion;

import Modelo.Modelo;
import java.util.Random;

/**
 *
 * @author nere1
 */
public class Zombie extends Seres{

    private boolean meMuero = false, tengoHijo = false, meTocaMatar = false;

    private Modelo model;
    private int birth, nconvertidos, random, probabilidad;

    
    public Zombie(int birth){
        this.birth = birth;
        this.probabilidad = 10;
    }

    public boolean MeTocaConvertir (){
        this.random = this.calcularRandom(1, 100);
        
        if(this.random <= this.probabilidad){ // ME TOCA MAAAAAR
            meTocaMatar = true;
            this.nconvertidos++;
        }
        
        return meTocaMatar;
    }
    
    @Override
    public boolean meMuero() {
        int dia = model.getDia();//Le paso el modelo para que sepa el numero de dia
        
        if((dia - this.birth) >= 8){ // ME TENGO QUE MORIR
            meMuero = true;
            //listaTuTipo.remove(this); // HAY QUE MIRAR ESTO NO SE SI ESTO DE BERDAD BORRA DE VDD LO QUE QUIERO
            this.meMuero = true;
        }
        
        return this.meMuero;
    }

    @Override
    public int calcularRandom(int desde, int hasta) {
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }

    public void setProbabilidad(int probabilidad) {
        this.probabilidad = probabilidad;
    }

    
}
