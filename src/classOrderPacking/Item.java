/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderPacking;


import order.exceptions.BoxException;
import order.packing.IItem;

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
 * Class of Item
 * It extends the class of Box and implements the interface of IItem
 * It's an object with the properties of Box, plus a reference and a description
 * @author fabio
 */
public class Item extends Box implements IItem{
    private String reference;
    private String description;
    
    /**
     * Contructor of an Item object
     * @param length Lenght of the item object
     * @param height Height of the item object
     * @param depth Depth of the item object
     * @param reference Reference of the item object
     * @param description Description of the item object
     * @throws BoxException In case lenght, height or depth are equal to 0 or negative
     */
    public Item (int length, int height, int depth, String reference, String description) throws BoxException{
        super(length, height, depth);
        this.reference = reference;
        this.description = description;
    }
    
    /**
     * Constructor of an item object
     * It's only used to initialize an item object
     */
    public Item(){}
    
    /**
     * Getter of the reference
     * @return The reference of the object
     */
    @Override
    public String getReference() {
        return reference;
    }

    /**
     * Getter of the description
     * @return The description of the object
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Setter of the description
     * @param string The new description of the item
     */
    @Override
    public void setDescription(String string) {
        this.description = string;
    }
    
    /**
     * 
     * @return values of the object item
     */
    @Override
    public String toString(){
        return super.toString()+
                "\nReferencia= " + getReference()+
                "\nDescription= " + getDescription();
    }
    
    
    
}
