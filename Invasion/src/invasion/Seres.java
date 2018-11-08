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
public abstract class Seres  {
    int birth;
    int id;

    public abstract boolean meMuero();
    public abstract boolean tengoHijo();
    
    public int getBirth() {
        return birth;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
