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
public class Vampiro extends Seres implements Serializable{

    private boolean meMuero = false, convierto, matoHumano;
    private int nmata = 0, nconvierte = 0, birth, random, tengoQueComer = -50;
    
    public Vampiro(int birth){
        this.birth = birth;
    }

    public boolean tengoQueComer(boolean quedanHumanos){
        
        boolean meTocaComer = false;
        this.convierto = false;  // Para inicializar y que nose quede en true
        this.matoHumano = false;
        
        this.random = this.calcularRandom(1, 100); // ¿me toca comer?
        
        if (this.random >= 50){ // TENGO QUE COMEEER
            meTocaComer = true;
            if(!quedanHumanos)
                this.meMuero = true;
            else{
                this.random = this.calcularRandom(1, 100); // voy a ver si tengo que matarlo o si lo voy a tranformar 
                if (this.random >= 50){ // HUMANO MUERE
                    this.matoHumano = true;
                    this.nmata++; // contamos aqui ya que mato un humano
                }
                else{
                    //Convierto a humano en vampiro
                    this.convierto = true;
                    this.nconvierte ++;
                }
                    
            }
        }
        else{
            meTocaComer = false;/** para que si no se mete en la condicion podemos saber que es por que no le tocaba comer y podamos diferenciar
                                     el random de si no toca comer al de si toca tranformar o matar*/
        }
        
       return meTocaComer;
    }

    public boolean getConvierto() {
        return convierto;
    }

    public boolean getMatoHumano() {
        return matoHumano;
    }
    
    
    @Override
    public String toString(){
        return "\n\tFecha de nacimiento: " + this.birth +
                "\n\tNumero de humanos matados: " + this.nmata +
                "\n\tNumero de humanos convertidos" + this.nconvierte + "\n";
    }

    @Override
    public int calcularRandom(int desde, int hasta) {
        Random aleatorio = new Random(System.currentTimeMillis());
        
        return aleatorio.nextInt(hasta-desde+1) + desde;
    }
    
    @Override
    public boolean meMuero() {
        return meMuero;
    }
}
