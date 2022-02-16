/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderBase;

import order.base.IAddress;
import order.base.ICustomer;

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
 * Class of Customer
 * It extends the interface of ICustomer
 */

public class Customer extends Person implements ICustomer{
    
    private Address billingAddress;
    private final int customerId;
    private static int nextId = 1;
    
    /**
     * constructor
     * used to set initial values for object attribute
     * the customer id is incremented 
     * @param address
     * @param name
     * @param billingAddress 
     */
    public Customer(Address address, String name, Address billingAddress){
        super(address, name);
        this.billingAddress=billingAddress;
        this.customerId=nextId++;
    }
    
    /**
     * getter for billing address
     * @return billing address
     */
    @Override
    public IAddress getBillingAddress() {
        return billingAddress;
    }

    /**
     * getter for customer identification
     * @return customer id
     */
    @Override
    public int getCustomerId() {
        return customerId;
    }

    /**
     * setter for the billing address
     * @param billingAddress 
     */
    @Override
    public void setBillingAddress(IAddress billingAddress) {
        this.billingAddress=(Address) billingAddress;
    }
    
    /**
     * 
     * @return values of the object customer
     */
    @Override
    public String toString(){
        return "Name: " + getName()
                +"\nAddress: \n" + getAddress()+
                "\nBilling Address: \n" + getBillingAddress()+
                "\nCustomer ID: " + getCustomerId();
    }
}
