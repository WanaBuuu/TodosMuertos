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
    private int nhumanos, ncazaVampiros, nzombies, nvampiros, ndia;

    
    private float  temperatura;
            
    private ArrayList <Humano> humanos;
    private ArrayList <CazaVampiro> cazaVampiros;
    private ArrayList <Vampiro> vampiros;
    private ArrayList <Zombie> zombies;
    
    private boolean cambioGlobal = false;
   
    
    
    /**De cada humano nos interesa almacenar y conocer en el programa el día de nacimiento y la
    velocidad al correr (que tiene una medida de 60 a 100).
    ◦ La velocidad será asignada a cada humano en el rango 60-100 al crearse el entorno.
    Después, las velocidad se hereda, es decir, cuando un humano tiene descendencia, sus hijos
    tienen su misma velocidad.*/
    
    public Modelo (){
        
        //TODO ESTO LO HE CAMBIADO A CREARENTORNO PORQUE SINO SERIAN SIEMPRE LOS MISMOS NUMEROS DE SERES Y SE CREARIAN CUANDO
        //CREAMOS EL MODELO, Y DEBERIA HACERSE CUANDO EMPEZAMOS LA SIMULACION
    }
    
    public void crearEntorno(){
        
        /** NUMERO INICIAL DE LOS SERES QUE VA A HABER EN LA SIMULACION*/
        this.nhumanos = calcularRandom(4000, 6000);
        this.ncazaVampiros = calcularRandom(10, 15);
        this.nvampiros = calcularRandom(15, 20);
        this.nzombies = calcularRandom(20, 30);
        
        /** SE ESTABLECE LA TEMPERATURA INICIAL QUE SE TIENE */
        this.temperatura = 20;
        
        this.ndia = 1;
        
        //Creamos los seres
        this.crearSeres();
    }
    
    public int getDia() {
        return this.ndia;
    }
    /** HAY QUE HACER QUE SEA SOLO PARA ESE DIA 
    * ASI QUE SUBONGO QUE DEBEREMOS TENER UN BOOL PARA CUANDO HAGAMOS EL SIGUIENTE DIA
    * RESTABLECER A UNA TEM NORMAL
    */
    public void calentamientoGlobal(){
        this.temperatura += 10;
        this.cambioGlobal = true;
    }
    
    /** HAY QUE HACER QUE SEA SOLO PARA ESE DIA 
    * ASI QUE SUBONGO QUE DEBEREMOS TENER UN BOOL PARA CUANDO HAGAMOS EL SIGUIENTE DIA
    * RESTABLECER A UNA TEM NORMAL
    */
    public void enfriamientoGlobal(){
        this.temperatura -= 10;
        this.cambioGlobal = true;
    }
    
    /**
     * Crea una opción que permita incrementar la probabilidad de
     * que un zombie alcance, y por tanto convierta a un humano en zombie, a 1/3.
     */
    public void invasionZombie(){
        for( Zombie zombie : zombies){
            zombie.setProbabilidad(33);
        }
    }
    
    /** CALCULA UN NUMERO ALEATORIO DENTRO DEL RANGO QUE SE LE PASA*/
    public final int calcularRandom(int desde, int hasta){
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    public void nextDay(){
        if (cambioGlobal){
            this.temperatura = 22;
            this.cambioGlobal = false;
        }
        
        this.ndia++;
        
        /** CALCULAMOS LA NUEVA TEMPERATURA */
        this.calcularTemperatura();
    }
    
    public void pasarDiezDias(){
        for(int i = 0; i < 10; i++){
            this.nextDay();
        }
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
        //Humanos
        for(int i = 0; i < this.humanos.size(); i++){
            
            if(this.humanos.get(i).meMuero())
                this.humanos.remove(i);
        }
        
        //CazaVampiros
        for(int i = 0; i < this.cazaVampiros.size(); i++){
            
            if(this.cazaVampiros.get(i).meMuero())
                this.cazaVampiros.remove(i);
        }
        
        //Vampiros
        for(int i = 0; i < this.vampiros.size(); i++){
            
            if(vampiros.get(i).meMuero())
                vampiros.remove(i);
        }
        
        //Zombies
        for(int i = 0; i < zombies.size(); i++){
            
            if(zombies.get(i).meMuero())
                zombies.remove(i);
        }

    }
    
    public void crearSeres(){
        //esta tambien se podria simplificar
        int tempveloc;
        //Humanos
        for(int i = 0; i < this.nhumanos; i++){
            
            tempveloc = this.calcularRandom(60, 100);
            
            Humano humano = new Humano(this.ndia, tempveloc);
            humanos.add(humano);
        }
        
        //CazaVampiros
        for(int i = 0; i < this.ncazaVampiros; i++){
            
            tempveloc = this.calcularRandom(60, 100);
            
            CazaVampiro cazaVampiro = new CazaVampiro(this.ndia, tempveloc);
            cazaVampiros.add(cazaVampiro);
        }
        
        //Vampiros
        for(int i = 0; i < this.nvampiros; i++){
            
            Vampiro vampiro = new Vampiro(this.ndia);
            vampiros.add(vampiro);
        }
                
        //Zombies
        for(int i = 0; i < this.nzombies; i++){
            
            Zombie zombie = new Zombie(this.ndia);
            zombies.add(zombie);
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