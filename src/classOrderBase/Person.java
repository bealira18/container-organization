/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderBase;

import order.base.IAddress;
import order.base.IPerson;

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
 * Class of Person
 * It extends the interface of IPerson
 */

public class Person implements IPerson{
    
    private Address address;
    private String name;
    
    /**
     * constructor
     * used to set initial values for object attribute
     * @param address
     * @param name 
     */
    public Person(Address address, String name){
        this.address=address;
        this.name=name;
    }
    
    /**
     * getter for the person address
     * @return address
     */
    @Override
    public IAddress getAddress(){
        return address;
    }
    
    /**
     * getter for person name
     * @return name
     */
    @Override
    public String getName(){
        return name;
    }
    /**
     * setter for the customer address
     * @param address 
     */
    @Override
    public void setAddress(IAddress address){
        this.address=(Address) address;
    }
    
    /**
     * setter for the person name
     * @param name 
     */
    @Override
    public void setName(String name){
        this.name=name;
    }
    
    /**
     * 
     * @return values of the object person
     */
    @Override
    public String toString(){
        return "Name: " + getName()
                +"\nAddress: \n" + getAddress();
    }
}
