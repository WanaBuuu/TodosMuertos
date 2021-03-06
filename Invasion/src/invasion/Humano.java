/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasion;

import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author nere1
 */
public class Humano extends Seres implements Serializable{
    private static final long serialVersionUID = 8799656478674716633L;
    protected boolean meMuero = false, tengoHijo = false;
    
    //nhijos es el numero de hijos que tiene el humano
    protected int birth, nhijos, totalhijos, velocidad;
    
    public Humano() {
       
    }
    
    public Humano(int birth, int velocidad) {
        this.birth = birth;
        this.velocidad = velocidad;
        this.nhijos = 0;
        this.totalhijos = 0;
    }
    

    public int getNhijos() {
        return this.nhijos;
    }

    
    @Override
    public final int calcularRandom(int desde, int hasta){
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    

    @Override
    public boolean meMuero() {
        this.meMuero = false;
        
        //Probabilidad de morir de forma natural -> 1/500
        if(this.calcularRandom(1, 500) == 1)
            this.meMuero = true;
        //Probabilidad de morir por otras causas (accidentes, inanición, enfermedades, etc.) -> 1/300
        else if(this.calcularRandom(1, 300) == 1)
            this.meMuero = true;
        
        return this.meMuero;
    }

    public boolean isMeMuero() {
        return meMuero;
    }

    public boolean isTengoHijo() {
        return tengoHijo;
    }

    public int getVelocidad() {
        return velocidad;
    }
    
    
    
    public boolean tengoHijo(float temperatura) {
        int aux, aux2;
        
        this.tengoHijo = false;
        
        if(temperatura >= 22.0){
            aux = this.calcularRandom(1, 15);
            if(aux == 1)
                this.tengoHijo = true;
            
        }
        else if(temperatura < 22.0 && temperatura > 18.0){
            aux = this.calcularRandom(1, 30);
            if(aux == 1)
                this.tengoHijo = true;
        }
        else{
            aux = this.calcularRandom(1, 50);
            if(aux == 1)
                this.tengoHijo = true;
        }
        //Si tengo hijos ese dia, calculo cuants tengo entre 1-3 y los sumos a nhijos
        if(this.tengoHijo){
            aux2 = this.calcularRandom(1, 3);
            this.nhijos = aux2;
            this.totalhijos += this.nhijos;
        }
        
        return this.tengoHijo;
    }

    public int getBirth() {
        return birth;
    }
    
    @Override
    public String toString(){
        return  "\n\tFecha de nacimiento: " + this.birth +
                "\n\tVelocidad del humano: " + this.velocidad +
                "\n\tHijos que ha tenido: " + this.totalhijos + "\n";
    }
    
}
