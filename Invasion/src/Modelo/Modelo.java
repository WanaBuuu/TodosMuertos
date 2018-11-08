/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Random;

/**
 *
 * @author nere1
 */
public class Modelo {
    private int nhumanos, ncazaVampiros, nzombies, nvampiros,ndia;
    private float  temperatura;
   
    
    
    public Modelo (){
        /** NEMERO INICIAL DE LOS SERES QUE VA A HABER EN LA SIMULACION*/
        this.nhumanos = calcularRandom(4000, 6000);
        this.ncazaVampiros = calcularRandom(10, 15);
        this.nvampiros = calcularRandom(15, 20);
        this.nzombies = calcularRandom(20, 30);
        
        /** SE ESTABLECE LA TEMPERATURA INICIAL QUE SE TIENE */
        this.temperatura = 20;
        
        this.ndia = 1;
    }
    
    
    /** CALCULA UN NUMERO ALEATORIO ENTRE LOS VALORE QUE SE LE PASAN*/
    public final int calcularRandom(int desde, int hasta){
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    public void nextDay(){
        this.ndia++;
        
        /** CALCULAMOS LA NUEVA TEMPERATURA */
        
    }
    
    public void calcularTemperatura(){
        int temAux;
        
        temAux = this.calcularRandom(1, 100);
        
        if(this.temperatura >= 22){
            if (temAux <= 45)
                this.temperatura += 0.5;
            else 
                this.temperatura -= 0.5;
        }
        else if (this.temperatura > 18 && this.temperatura < 22){
            if (temAux > 5 && temAux <= 35)
                this.temperatura -= 0.5;
            else if (temAux > 35)
                this.temperatura += 0.5;
        }
        else {
            if (temAux <= 45)
                this.temperatura -= 0.5;
            else 
                this.temperatura += 0.5;
        }
    }
}
