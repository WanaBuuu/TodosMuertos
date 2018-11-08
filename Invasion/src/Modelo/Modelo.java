/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import invasion.CazaVampiro;
import invasion.Humano;
import invasion.Vampiro;
import invasion.Zombie;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nere1
 */
public class Modelo {
    private int nhumanos, ncazaVampiros, nzombies, nvampiros,ndia;
    private float  temperatura;
            
    private ArrayList <Humano> humanos;
    private ArrayList <CazaVampiro> cazaVampiros;
    private ArrayList <Vampiro> vampiros;
    private ArrayList <Zombie> zombies;
   
    
    
    /**De cada humano nos interesa almacenar y conocer en el programa el día de nacimiento y la
    velocidad al correr (que tiene una medida de 60 a 100).
    ◦ La velocidad será asignada a cada humano en el rango 60-100 al crearse el entorno.
    Después, las velocidad se hereda, es decir, cuando un humano tiene descendencia, sus hijos
    tienen su misma velocidad.*/
    
    public Modelo (){
        /** NUMERO INICIAL DE LOS SERES QUE VA A HABER EN LA SIMULACION*/
        this.nhumanos = calcularRandom(4000, 6000);
        this.ncazaVampiros = calcularRandom(10, 15);
        this.nvampiros = calcularRandom(15, 20);
        this.nzombies = calcularRandom(20, 30);
        
        /** SE ESTABLECE LA TEMPERATURA INICIAL QUE SE TIENE */
        this.temperatura = 20;
        
        this.ndia = 1;
    }
    
    
    /** CALCULA UN NUMERO ALEATORIO DENTRO DEL RANGO QUE SE LE PASA*/
    public final int calcularRandom(int desde, int hasta){
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    public void nextDay(){
        this.ndia++;
        
        /** CALCULAMOS LA NUEVA TEMPERATURA */
        this.calcularTemperatura();
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
    
    public void quienMuere(){
        
        /**PARA HUMANO:
         * 
        * IMPLEMENTAR EN EL MODELO
        * 1) SACAR NUM ALEATORIO ENTRE 1 Y 500
        * 2)SI EXISTE ESA POSICION EN EL VECTOR DE HUMANOS, SE MUERE EL HUMANO QUE ESTE EN ESA POS
        * PARA OTRAS MUERTES LO MISMO
        * 
       Un humano muere diariamente por muerte natural con una probabilidad de 1/500.
       Aparte, un humano puede morir diariamente por otras causas (accidentes, inanición,
       enfermedades, etc.) con una probabilidad diaria de 1/300.
       */

    }
    
    public void crearSeres(){
        
        int tempveloc;
        //Humanos
        for(int i = 0; i < this.nhumanos; i++){
            
            tempveloc = this.calcularRandom(60, 100);
            
            Humano humano = new Humano(this.ndia, tempveloc);
            humanos.add(humano);
        }
        
    }
    
}


/** 
 
 if(humanos.isEmpty()){ // ME MUERO POR NO COMER
                vampiros = this.meMuero(birth, vampiros);
                comodin = vampiros;
            }
            else{
                 if (this.random >= 50){ // HUMANO MUERE
                humanos.remove(random);
                this.nmata++;
                }
                 /** AQUI TENEMOS EL PROBLEMA DE QUE NECESITAMOS DEBOLVER LOS DOS VECTORES */
                /*else{ // HUMANO SE TRANSFORMA
                    humanos.remove(random); // el humano deja de ser humano

                    vampiroAux =  new Vampiro(birth); // creamos el nuevo vampiro
                    vampiros.add(vampiroAux); 
                }
            }
 
 */