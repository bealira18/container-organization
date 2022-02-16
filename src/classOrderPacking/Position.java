/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderPacking;

import classOrderExceptions.ClassPositionException;
import order.exceptions.PositionException;
import order.packing.IPosition;

/*
* Nome: Beatriz Fonseca Lira de Meireles
* Número: 8190124
* Turma: 2
*
* Nome: Fábio dos Santos Sousa
* Número: 8190181
* Turma: 4
*/

/**
 * Class of Posistion
 * It implements the interface IPosition
 * It's an object with a value of x, y and z coordinates
 */
public class Position implements IPosition{
    private int x;
    private int y;
    private int z;
    
    /**
     * Constructor of the class Position
     * @param x The x value
     * @param y The y value
     * @param z The z value
     * @throws ClassPositionException In case either x, y, or z and negative
     */
    public Position (int x, int y, int z) throws ClassPositionException{
        if (x < 0 || y < 0 || z < 0){
            throw new ClassPositionException();
        }else{
            this.x = x;
            this.y = y;
            this.z = z;
        }
        
    }
    
    /**
     * Getter of the x value
     * @return The x value
     */
    @Override
    public int getX() {
        return x;
    }
    
    /**
     * Getter of the y value
     * @return The y value
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * Getter of the z value
     * @return The z value
     */
    @Override
    public int getZ() {
        return z;
    }

    /**
     * Setter of the x value
     * @param i New value of x
     * @throws PositionException In case i is negative
     */
    @Override
    public void setX(int i) throws PositionException {
        if (i < 0){
            throw new ClassPositionException();
        }else{
            this.x = i;
        }
    }

    /**
     * Setter of the y value
     * @param i New value of y
     * @throws PositionException In case i is negative
     */
    @Override
    public void setY(int i) throws PositionException {
        if (i < 0){
            throw new ClassPositionException();
        }else{
            this.y = i;
        }
    }

    /**
     * Setter of the z value
     * @param i New value of z
     * @throws PositionException In case i is negative
     */
    @Override
    public void setZ(int i) throws PositionException {
        if (i < 0){
            throw new ClassPositionException();
        }else{
            this.z = i;
        }
    }
    /**
     * @return values of the object item
     */
    @Override
    public String toString(){
        return "x= " + getX()+
                "\ny= " + getY()+
                "\nz= " + getZ();
    }
    
    
}
