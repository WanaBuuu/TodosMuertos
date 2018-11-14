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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nere1
 */
public class Modelo implements Serializable{
    private int nhumanos, ncazaVampiros, nzombies, nvampiros, ndia;
    private boolean catastrofeFrio = false, catastrofeCalor = false, catastrofeZombie = false;
    private float  temperatura;
            
    private ArrayList <Humano> humanos;
    private ArrayList <CazaVampiro> cazaVampiros;
    private ArrayList <Vampiro> vampiros;
    private ArrayList <Zombie> zombies;
    
    private Vampiro v;
    private Humano h;
    private CazaVampiro cv;
   
    private File fichero = new File ("C:\\Users\\evely_001\\Desktop\\Clase\\3º\\1er cuatri\\IS2\\Practicas\\P3\\TodosMuertos\\Invasion\\file.bin");
    //   D:\RepositoriosCodigo\Practica3\TodosMuertos\Invasion\file.bin
    
    
    public Modelo (){
        
        //TODO ESTO LO HE CAMBIADO A CREARENTORNO PORQUE SINO SERIAN SIEMPRE LOS MISMOS NUMEROS DE SERES Y SE CREARIAN CUANDO
        //CREAMOS EL MODELO, Y DEBERIA HACERSE CUANDO EMPEZAMOS LA SIMULACION
        
        this.humanos = new ArrayList();
        this.cazaVampiros = new ArrayList();
        this.vampiros = new ArrayList();
        this.zombies = new ArrayList();
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
        
        // si me ponen una calor las otras se tienen que desactivar
        this.catastrofeCalor = true;
        this.catastrofeFrio = false;
        this.catastrofeZombie = false;
    }
    
    /** HAY QUE HACER QUE SEA SOLO PARA ESE DIA 
    * ASI QUE SUBONGO QUE DEBEREMOS TENER UN BOOL PARA CUANDO HAGAMOS EL SIGUIENTE DIA
    * RESTABLECER A UNA TEM NORMAL
    */
    public void enfriamientoGlobal(){
        this.temperatura -= 10;
        
        // si me ponen una calor las otras se tienen que desactivar
        this.catastrofeCalor = false;
        this.catastrofeFrio = true;
        this.catastrofeZombie = false;
    }
    
    /**
     * Crea una opción que permita incrementar la probabilidad de
     * que un zombie alcance, y por tanto convierta a un humano en zombie, a 1/3.
     */
    public void invasionZombie(){
        for( Zombie zombie : zombies){
            zombie.setProbabilidad(33);
        }
        
         // si me ponen una calor las otras se tienen que desactivar
        this.catastrofeCalor = false;
        this.catastrofeFrio = false;
        this.catastrofeZombie = true;
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
        
        //Cazar Cazavampiros saber si le toca matar
        int idvamp = 0;
        
        for(int i = 0; i < this.cazaVampiros.size(); i++){
            if(this.cazaVampiros.get(i).meTocaMatarVampiro()){
                if(!this.vampiros.isEmpty()){
                    idvamp = this.calcularRandom(0, (this.vampiros.size()-1));
                    this.vampiros.remove(idvamp);
                }
                else
                    System.out.println("No hay vampiros");
            }
        }
        
        //Convertir Zombies saber si le toca convertir
        Object o = this.masLento();
        
        for(int i = 0; i < this.zombies.size(); i++){
            if(this.zombies.get(i).MeTocaConvertir()){
                if(o instanceof Humano){
                    this.humanos.remove(o);
                }
                else{
                    this.cazaVampiros.remove(o);
                }
            }
        }
        
        //Comer Vampiros saber si le toca comer
        int idhum;
        
        for(int i = 0; i < this.vampiros.size(); i++){
            if(this.vampiros.get(i).tengoQueComer(this.humanos.isEmpty())){
                
                if(!this.humanos.isEmpty()){
                    idhum = this.calcularRandom(0, this.humanos.size()-1);
                
                    if(this.vampiros.get(i).getMatoHumano()){
                        //Matar a un humano
                        this.humanos.remove(idhum);
                    }
                    else{
                        //Convertir a humano en vampiro
                        this.humanos.remove(idhum);
                        this.vampiros.add(v = new Vampiro(this.ndia));
                    }
                }
                
            }
        }
        
        //Reproducir Humanos saber si va a tener hijos
        int numhijos = 0;
        
        for(int i = 0; i < this.humanos.size(); i++){
            
            if(this.humanos.get(i).tengoHijo(this.temperatura)){
                numhijos = this.humanos.get(i).getNhijos();
                
                for(int j = 0; j < numhijos; j++){
                    h = new Humano(this.ndia, this.humanos.get(i).getVelocidad());
                    this.humanos.add(h);
                }
            }
        }
        
        //Reproducir CazaVampiros saber si va a tener
        numhijos = 0;
        
        for(int i = 0; i < this.cazaVampiros.size(); i++){
            System.out.println("estoy reproduciendome " + numhijos);
            if(this.cazaVampiros.get(i).tengoHijo(this.temperatura)){
                numhijos = this.cazaVampiros.get(i).getNhijos();
                System.out.println("estoy reproduciendome " + numhijos);
                for(int j = 0; j < numhijos; j++){
                    cv = new CazaVampiro(this.ndia, this.cazaVampiros.get(i).getVelocidad());
                    this.cazaVampiros.add(cv);
                     System.out.println("estoy reproduciendome " + numhijos);
                }
            }
        }
        
        //Morir todos
        this.quienMuere();
    }
    
    public Object masLento(){
        
        int mash = 0, masv = 0;
        Object h = new Object();
        Object v = new Object();
        
        for(int i = 0; i < humanos.size();i++){
            
            mash = humanos.get(i).getVelocidad();
            
            if(humanos.get(i).getVelocidad() < mash){
                mash = humanos.get(i).getVelocidad();
                h = humanos.get(i);
                      
            }
        }
        
        for(int i = 0; i < cazaVampiros.size();i++){
            masv = cazaVampiros.get(i).getVelocidad();
            
            if(cazaVampiros.get(i).getVelocidad() < masv){
                masv = cazaVampiros.get(i).getVelocidad();
                v = cazaVampiros.get(i);
            }
            
        }
        
        if(mash > masv)
            return v;
        else
            return h;
            
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
            this.humanos.add(humano);
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
            
            Zombie zombie = new Zombie(this.ndia, this);
            zombies.add(zombie);
        }
                
    }
    
    @Override
    public String toString(){
        String hum = "";
        String cv = "";
        String zom = "";
        String vam = "";
        String catastrofe = "";
         
        for(int i = 0; i < this.humanos.size(); i++){
            hum += this.humanos.get(i);
        }
        
        for(int i = 0; i < this.cazaVampiros.size(); i++){
            cv += this.cazaVampiros.get(i);
        }
        
        for(int i = 0; i < this.vampiros.size(); i++){
            vam += this.vampiros.get(i);
        }
        
        for(int i = 0; i < this.zombies.size(); i++){
            zom += this.zombies.get(i);
        }
        
        if(this.catastrofeCalor){
            catastrofe = "CALENTAMIENTO GLOBAL\n";
        }
        else if (this.catastrofeFrio){
            catastrofe = "ENGRIAMIENTO GLOBAL\n";
        }
        else if (this.catastrofeZombie){
            catastrofe = "INVASIÓN ZOMBIE\n";
        }
        else {
            catastrofe = "";
        }
        
        return catastrofe +
               "DÍA: " + this.ndia  + "\n" +
               "TEMPERATURA: " + this.temperatura  + "\n" +
               "HUMANOS\n" + 
               hum  + "\n" + 
               "CAZAVAMPIROS\n" +
               cv + "\n" +
               "VAMPIROS\n" +
               vam + "\n" +
               "ZOMBIES\n" + 
               zom + "\n";
    }

    public int getNhumanos() {
        return this.humanos.size();
    }

    public int getNcazaVampiros() {
        return this.cazaVampiros.size();
    }

    public int getNzombies() {
        return this.zombies.size();
    }

    public int getNvampiros() {
        return this.vampiros.size();
    }

    public float getTemperatura() {
        return temperatura;
    }

    //SERIALIZABLE
    
    public void escribirFich(java.io.ObjectOutputStream oos) throws FileNotFoundException, IOException{
        
        oos = new ObjectOutputStream(new FileOutputStream(fichero));
        
        for (int i = 0; i < this.humanos.size(); i++)
        {
            oos.writeObject(this.humanos.get(i));
        }
        
        for (int i = 0; i < this.cazaVampiros.size(); i++)
        {
            oos.writeObject(this.cazaVampiros.get(i));
        }
        
        for (int i = 0; i < this.vampiros.size(); i++)
        {
            oos.writeObject(this.vampiros.get(i));
        }
        
        for (int i = 0; i < this.zombies.size(); i++)
        {
            oos.writeObject(this.zombies.get(i));
        }
        
        oos.close();
    }
    
    public void leerFich(java.io.ObjectInputStream ois) throws FileNotFoundException, IOException, ClassNotFoundException{
        
        ois = new ObjectInputStream(new FileInputStream(fichero));
        
        // Se lee el primer objeto
        Object aux = ois.readObject();

        // Mientras haya objetos
        while (aux!=null)
        {
            if (aux instanceof Humano)
                this.humanos.add((Humano) aux);
            
            if (aux instanceof CazaVampiro)
                this.cazaVampiros.add((CazaVampiro) aux);
            
            if (aux instanceof Vampiro)
                this.vampiros.add((Vampiro) aux);
            
            if (aux instanceof Zombie)
                this.zombies.add((Zombie) aux);
            
            aux = ois.readObject();
        }
        //ois.close();
        
    }
    
}

