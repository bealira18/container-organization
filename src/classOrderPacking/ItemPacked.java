/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderPacking;

import order.packing.Color;
import order.packing.IItem;
import order.packing.IItemPacked;
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
 * Class of ItemPacked
 * It implements the interface IItemPacked
 */
public class ItemPacked implements IItemPacked{
    private Color color;
    private Color colorEdge;
    private final IItem item;
    private Position position;
    
    /**
     * Constructor of ItemPacked
     * @param color Color of the package
     * @param item Item that will be packed
     * @param position Position of the package
     */
    public ItemPacked (Color color, IItem item, Position position){
        this.color = color;
        this.item = item;
        this.position = position;
        this.colorEdge = color;
    }

    /**
     * Getter of the color of the package
     * @return 
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Getter of the item of the package
     * @return 
     */
    @Override
    public IItem getItem() {
        return item;
    }

    /**
     * Getter of the position of the package
     * @return 
     */
    @Override
    public IPosition getPosition() {
        return position;
    }

    /**
     * Setter of the color of the package
     * @param color New color of the package
     */
    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Setter of the position of the package
     * @param ip New position of the package
     */
    @Override
    public void setPosition(IPosition ip) {
        this.position = (Position)ip;
    }
    
    /**
     * @return values of the object item
     */
    @Override
    public String toString(){
        return "\nItem:" + getItem()+
                "\nColor:" + getColor()+
                "\nPosition:\n" + getPosition();
    }

    /**
     * Getter of the edge color of the package
     * @return The egde color of the package
     */
    public Color getColorEdge() {
        return colorEdge;
    }

    /**
     * Setter of the edge color of the package
     * @param colorEdge New edge color of the package
     */
    public void setColorEdge(Color colorEdge) {
        this.colorEdge = colorEdge;
    }
}
