/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasion;

import java.io.Serializable;

/**
 *
 * @author nere1
 */
public class CazaVampiro extends Humano implements Serializable{
    private static final long serialVersionUID = 8799656478674716636L;
    private boolean meMuero = false, tengoHijo = false ;
    private int nmata = 0;

    public CazaVampiro(int birth, int velocidad) {
        super(birth, velocidad);
        
    }

   public boolean meTocaMatarVampiro(){
       boolean matar = false;
       int random;
       
       random = this.calcularRandom(1, 3);
       
       if(random == 1){
           matar = true;
           this.nmata ++;
       }
       
       return matar;
    }
   
    @Override
    public String toString(){
       return  "\n\tFecha de nacimiento: " + this.birth +
               "\n\tVelocidad del humano: " + this.velocidad +
               "\n\tHijos que ha tenido: " + this.totalhijos+
               "\n\tVampiros a los que mata: " + this.nmata + "\n";
    }
   
}
