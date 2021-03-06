/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasion;

import Modelo.Modelo;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author nere1
 */
public class Zombie extends Seres implements Serializable{

    private boolean meMuero = false, meTocaMatar = false;
    private int birth, nconvertidos, random, probabilidad;
    private static final long serialVersionUID = 8799656478674716638L;
    
    private Modelo model;
    
    public Zombie(int birth, Modelo model){
        this.birth = birth;
        this.probabilidad = 10;
        this.model = model;
    }

    public boolean MeTocaConvertir (){
        this.meTocaMatar = false;
        
        this.random = this.calcularRandom(1, this.probabilidad);
        
        if(this.random  == 1 ){ // ME TOCA MAAAAAR
            meTocaMatar = true;
            this.nconvertidos++;
        }
        
        return meTocaMatar;
    }
    
    @Override
    public boolean meMuero() {
        int dia = model.getDia();//Le paso el modelo para que sepa el numero de dia
        
        this.meMuero = false;
        
        if((dia - this.birth) >= 8){ // ME TENGO QUE MORIR
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

    @Override
    public String toString(){
        return  "\n\tFecha de nacimiento: " + this.birth +
                "\n\tNumero de humanos convertidos: " + this.nconvertidos + "\n";
    }
    
}
