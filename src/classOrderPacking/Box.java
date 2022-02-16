/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderPacking;

import classOrderExceptions.ClassBoxException;
import order.exceptions.BoxException;
import order.packing.IBox;

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
 * Class of Box
 * It extends the interface of IBox
 * It's an object with lenght, height, depth and volume
 */
public abstract class Box implements IBox{
    private int length;
    private int height;
    private int depth;
    private int volume;
    
    /**
     * Constructor of a Box object
     * @param length lenght of the box
     * @param height height of the box
     * @param depth depth of the box
     * @throws BoxException In case lenght, height or depth are equal to 0 or negative
     */
    public Box (int length, int height, int depth) throws BoxException{
        if (length < 1 || height < 1 ||  depth < 1){
            throw new ClassBoxException();
        }else if (length > 50 || height > 50 ||  depth > 50){
            throw new ClassBoxException();
        }else{
            this.length = length;
            this.height = height;
            this.depth = depth;
            this.volume = length * height * depth;
        }
    }
    
    /**
     * Constructor of a box object
     * It's only used to initialize a box object
     */
    public Box (){}
    
    /**
     * Getter of lenght
     * @return the lenght of the object
     */
    @Override
    public int getLenght() {
        return length;
    }
    
    /**
     * Getter of height
     * @return the height of the object
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Getter of depth
     * @return the depth of the object
     */
    @Override
    public int getDepth() {
        return depth;
    }
    
    /**
     * Getter of volume
     * @return the volume of the object
     */
    @Override
    public int getVolume() {
        return volume;
    }
    
    /**
     * 
     * @return values of the object box
     */
    @Override
    public String toString(){
        return "\nDepth= " + getDepth()+
                "\nHeight= " + getHeight()+
                "\nLenght= " + getLenght()+
                "\nVolume= " + getVolume();
    }
    
    
}
