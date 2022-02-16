/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderPacking;

import classOrderExceptions.ClassContainerException;
import classOrderExceptions.ClassPositionException;
import java.util.Arrays;
import order.exceptions.BoxException;
import order.exceptions.ContainerException;
import order.exceptions.PositionException;
import order.packing.Color;
import order.packing.IContainer;
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
 * Class of Container
 * It extends the class of Box and implements the interface of Container
 * It has the properties of Box, plus a reference, a color, a color edge and an array of items
 */
public class Container extends Box implements IContainer{
    private String reference;
    private int size = 5;
    private IItemPacked[] packedItems = new IItemPacked[size];
    private int nItems = 0;
    private int occupiedVolume = 0;
    private boolean isClosed = false;
    private final int nextSize=5;
    private Color color;
    private Color colorEdge;
    
    /**
     * Contructor of a container object
     * @param length Lenght of the container
     * @param height Height of the container
     * @param depth Depth of the container
     * @param reference Reference of the container
     * @param color Color of the container
     * @throws BoxException 
     */
    public Container (int length, int height, int depth, String reference, Color color) throws BoxException {
        super(length, height, depth);
        this.reference = reference;
        this.color = color;
        this.colorEdge = color;
    }
    
    /**
     * Contructor of a container object
     * It's only used to initialize a container object 
     */
    public Container(){}
    
    /**
     * It allows to change the size of the array of items
     * It can either make it increase or decrease
     * @param var 
     */
    public void changeSizeArray(int var){
        IItemPacked[] tempArray = new IItemPacked[size + var];
        System.arraycopy(packedItems, 0, tempArray, 0, nItems);
        packedItems = tempArray;
        size += nextSize;
    }
    
    /**
     * It allows to add a new item to the container
     * @param iitem The item that will be packed and added
     * @param ip The position of the item in the container when packed
     * @param color The color of the item when packed
     * @return True if the item was added and false if the item already exists
     * @throws ContainerException In case the container is either closed, or one 
     * of the parameters is null
     */
    @Override
    public boolean addItem(IItem iitem, IPosition ip, Color color) throws ContainerException {
        
        if (isClosed){
            throw new ClassContainerException();
        }else if (iitem == null || ip == null || color == null){
            throw new ClassContainerException("The parameters weren't filled correctly");
        }
        
        for (int i = 0; i < nItems; i++){
            if (((ItemPacked)packedItems[i]).getItem().getReference().equals(((Item)iitem).getReference())){
                return false;
            }
        }
        
        if (size == nItems){
            changeSizeArray(nextSize);
        }
        
        IItemPacked itemPacked = new ItemPacked(color, iitem, (Position)ip);
        packedItems[nItems++] = itemPacked;
        occupiedVolume += iitem.getVolume();
        return true;
    }
    
    /**
     * It allow to find a certain item in the container
     * @param reference Reference of the item that will be found
     * @return Returns the item if it was found and null otherwise
     */
    public IItem findItem(String reference) {
        int pos=-1;
        for(int i=0;i<nItems;i++){
            if(packedItems[i].getItem().getReference().equals(reference)){
                pos=i;
            }
        }
        if (pos == -1){
            return null;
        }
        return packedItems[pos].getItem();
    }
    
    /**
     * It allows to remove an item from the container
     * @param iitem Item to be removed
     * @return True if the item was removed and false otherwise
     * @throws ContainerException In case the container is closed or the item is null
     */
    @Override
    public boolean removeItem(IItem iitem) throws ContainerException {
        boolean found = false;
        if (isClosed){
            throw new ClassContainerException();
        }else if (iitem == null){
            throw new ClassContainerException("The parameters weren't filled correctly");
        }
        
        for (int i = 0; i < nItems; i++){
            if (packedItems[i].getItem() == iitem){
                found = true;
            }
            if (found && i < nItems - 1){
                packedItems[i] = packedItems[i + 1];
            }
        }
        if (found){
            packedItems[--nItems] = null;
            if (size - nItems >= 5 && size != 5){
                changeSizeArray(-nextSize);
            }
        }
        return found;
    }
    
    /**
     * It verifies if an item intersects the bounds of the Container
     * @param item Item that will be verified
     * @return False if it is intersecting the container and true otherwise
     */
    private boolean isItemOutside(ItemPacked item){
        if (item.getPosition().getX() + item.getItem().getLenght() > getLenght()){
            return false;
        }else if (item.getPosition().getY() + item.getItem().getDepth() > getDepth()){
            return false;
        }else if (item.getPosition().getZ() + item.getItem().getHeight() > getHeight()){
            return false;
        }
        return true;
    }
    
    /**
     * It verifies if an item intersects the bounds of another item
     * @param item1 Item 1 of the verification
     * @param item2 Item 2 of the verification
     * @return False if it is intersecting and true otherwise
     */
    private boolean isOverLapping(ItemPacked item1, ItemPacked item2){
        if (item1.getPosition().getX() <= item2.getPosition().getX() && 
                item2.getPosition().getX() < (item1.getPosition().getX() + item1.getItem().getLenght())){
            if (item1.getPosition().getY() <= item2.getPosition().getY() && 
                    item2.getPosition().getY() < (item1.getPosition().getY() + item1.getItem().getHeight())){
                if (item1.getPosition().getZ() <= item2.getPosition().getZ() && 
                        item2.getPosition().getZ() < (item1.getPosition().getZ() + item1.getItem().getDepth())){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * It verifies if and item is floating in the container
     * @param item1 Item 1 of the verification
     * @param item2 Item 2 of the verification
     * @return True if it is floating and false otherwise
     */
    private boolean isFloating(ItemPacked item1, ItemPacked item2){
        if (item1.getPosition().getY() == 0){
            return false;
        }else if (item1.getPosition().getX() <= item2.getPosition().getX() && 
                item2.getPosition().getX() < (item1.getPosition().getX() + item1.getItem().getLenght())){
            if (item1.getPosition().getZ() <= item2.getPosition().getZ() && 
                    item2.getPosition().getZ() < (item1.getPosition().getZ() + item1.getItem().getDepth())){
                if (item1.getPosition().getY() == item2.getPosition().getY() + item2.getItem().getHeight()){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Validates if the container is ready to be closed
     * @throws ContainerException In case the container's occupied volume is 
     * greater than the total volume or if an item intersects the container
     * @throws PositionException In case two items are intersecting or if an item
     * is floating
     */
    @Override
    public void validate() throws ContainerException, PositionException {
        if (occupiedVolume > getVolume()){
            throw new ClassContainerException("The occupied volume os greater than the total volume");
        }
        for (int i = 0; i < nItems; i++){
            if (!isItemOutside(((ItemPacked)packedItems[i]))){
                throw new ClassContainerException("One of the items is partially"
                        + " or totally outside of the container");
            }
            boolean isItemFloating = true;
            if (nItems > 1){
                for (int j = 0; j < nItems; j++){
                    if (i != j){
                        if (!isOverLapping(((ItemPacked)packedItems[i]), ((ItemPacked)packedItems[j]))){
                            throw new ClassPositionException("Two items are intersecting each other");
                        }
                        if(!isFloating(((ItemPacked)packedItems[i]), ((ItemPacked)packedItems[j]))){
                            isItemFloating = false;
                        }
                    }
                }
            }else{
                if (packedItems[0].getPosition().getY() == 0){
                    isItemFloating = false;
                }
            }
            if (isItemFloating){
                throw new ClassPositionException("One of the items os floating");
            }
        }
    }

    /**
     * It allows to close the container after it validates it
     * @throws ContainerException In case the container's occupied volume is 
     * greater than the total volume or if an item intersects the container
     * @throws PositionException In case two items are intersecting or if an item
     * is floating
     */
    @Override
    public void close() throws ContainerException, PositionException {
        validate();
        isClosed = true;
    }

    /**
     * It allow to return a certain item
     * @param string Reference of the item that will be returned
     * @return The item if it finds it and null otherwise
     */
    @Override
    public IItem getItem(String string) {
        for(int i=0;i<nItems;i++){
            if(packedItems[i].getItem().getReference().equals(string)){
                return packedItems[i].getItem();
            }
        }
        return null;
    }

    /**
     * Getter of the occupied volume
     * @return The occupied volume of the container object
     */
    @Override
    public int getOccupiedVolume() {
        return occupiedVolume;
    }

    /**
     * Getter of the array of items in the container
     * @return The array of items of the container
     */
    @Override
    public IItemPacked[] getPackedItems() {
        IItemPacked[] tempArray = new IItemPacked[nItems];
        System.arraycopy(packedItems, 0, tempArray, 0, nItems);
        return tempArray;
    }

    /**
     * Getter of the reference of the container object
     * @return 
     */
    @Override
    public String getReference() {
        return reference;
    }

    /**
     * Getter of the number of items of the container object
     * @return 
     */
    @Override
    public int getNumberOfItems() {
        return nItems;
    }

    /**
     * Getter of the remaining volume of the container object
     * @return 
     */
    @Override
    public int getRemainingVolume() {
        return getVolume() - occupiedVolume;
    }
    
    /**
     * Checks if the container is closed or not
     * @return True if the container is closed and false otherwise
     */
    @Override
    public boolean isClosed() {
        return isClosed;
    }
    
    /**
     * @return values of the object item
     */
    @Override
    public String toString(){
        return super.toString()+
                "\nReference= " + getReference()+
                "\nNumber of Items= " + getNumberOfItems()+
                "\nPacked Items= \n" + Arrays.toString(getPackedItems())+
                "\nOccupied Volume= " + getOccupiedVolume()+
                "\nRemaining = " + getRemainingVolume()+
                "\nIs the container closed? " + isClosed();
    }

    /**
     * Getter of the color of the container object
     * @return 
     */
    public Color getColor() {
        return color;
    }

    /**
     * Setter of the color of the container object
     * @param color 
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter of the edge color of the container object
     * @return 
     */
    public Color getColorEdge() {
        return colorEdge;
    }

    /**
     * Setter of the edge color of the container object
     * @param colorEdge 
     */
    public void setColorEdge(Color colorEdge) {
        this.colorEdge = colorEdge;
    }
    
    
}
