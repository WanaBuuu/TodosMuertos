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
    private int birth, nhijos;

    public Humano() {
       
    }
    
    public Humano(int birth) {
        this.birth = birth;
    }
    
    public final int calcularRandom(int desde, int hasta){
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    @Override
    public boolean meMuero() {
        
        return this.meMuero;
    }
    
    /**Mayor o igual a 22 grados Probabilidad de reproducción: 1/15
    Menor a 22 y mayor a 18 grados Probabilidad de reproducción: 1/30
    Menor o igual a 18 grados Probabilidad de reproducción: 1/50
    
    Si un día se reproduce un humano, ese día podrá tener un número de hijos en el rango 1-3
    (con la misma probabilidad para cada opción). Para simplificar el simulador, los humanos no
    tienen sexo, y cada individuo puede reproducirse utilizando las probabilidades anteriores.
    */

    @Override
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
            this.nhijos += aux2;
        }
        
        return this.tengoHijo;
    }
    
}
