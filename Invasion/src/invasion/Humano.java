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
public class Humano extends Seres{
    
    private boolean meMuero = false, tengoHijo = false;
    
    //nhijos es el numero de hijos que tiene el humano
    private int birth, nhijos, totalhijos, velocidad;
    
    public Humano() {
       
    }
    
    public Humano(int birth, int velocidad) {
        this.birth = birth;
        this.velocidad = velocidad;
        this.nhijos = 0;
        this.totalhijos = 0;
    }
    

    public int getNhijos() {
        return nhijos;
    }

    
    @Override
    public final int calcularRandom(int desde, int hasta){
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    public boolean meMuero(int dia) {
        /**
        * IMPLEMENTAR EN EL MODELO
        * 1) SACAR NUM ALEATORIO ENTRE 1 Y 500
        * 2)SI EXISTE ESA POSICION EN EL VECTOR DE HUMANOS, SE MUERE EL HUMANO QUE ESTE EN ESA POS
        * PARA OTRAS MUERTES LO MISMO
        * 
       Un humano muere diariamente por muerte natural con una probabilidad de 1/500.
       Aparte, un humano puede morir diariamente por otras causas (accidentes, inanición,
       enfermedades, etc.) con una probabilidad diaria de 1/300.
       */
        return this.meMuero;
    }

    public boolean tengoHijo(float temperatura) {
        
        int prob, aux, aux2;
        
        aux = this.calcularRandom(0, 100);
        
        if(temperatura >= 22){
            if(aux <= 15)
                this.tengoHijo = true;
            
        }
        else if(temperatura < 22 && temperatura > 18){
            if(aux > 15 && aux <= 45)
                this.tengoHijo = true;
        }
        else{
            if(aux > 50)
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
    
}
