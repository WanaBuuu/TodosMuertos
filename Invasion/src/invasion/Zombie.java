/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invasion;

/**
 *
 * @author nere1
 */
public class Zombie extends Seres{

    private boolean meMuero = false, tengoHijo = false ;
    
    
    @Override
    public boolean meMuero() {
        
        return this.meMuero;
    }

    @Override
    public boolean tengoHijo(float temperatura) {
        
        return this.tengoHijo;
    }
}
