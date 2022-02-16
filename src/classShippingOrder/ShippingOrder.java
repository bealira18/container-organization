/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classShippingOrder;

import classOrderBase.Customer;
import classOrderBase.Person;
import classOrderExceptions.ClassContainerException;
import classOrderExceptions.ClassOrderException;
import classOrderPacking.Container;
import java.util.Arrays;
import order.base.ICustomer;
import order.base.IPerson;
import order.base.OrderStatus;
import static order.base.OrderStatus.AWAITS_TREATMENT;
import static order.base.OrderStatus.CLOSED;
import static order.base.OrderStatus.IN_TREATMENT;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import order.packing.IContainer;
import shippingorder.IShippingOrder;

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
 * Class of shippingOrder
 * It extends the interface of IShippingOrder
 */

public class ShippingOrder implements IShippingOrder{

    private final int id;
    private static int nextId = 1;
    private int nContainers;
    private int size=5;
    private IContainer[] containers=new IContainer[size];
    private Person destination;
    private final Customer customer;
    private OrderStatus orderStatus;
    private final int nextSize=5;
    
    /**
     * constructor
     * used to set initial values for object attribute
     * the customer id is incremented 
     * @param destination
     * @param customer 
     */
    public ShippingOrder(Person destination, Customer customer){
        this.destination=destination;
        this.customer=customer;
        id=nextId++;
        orderStatus=AWAITS_TREATMENT;
    }
    
    /**
     * increase or decrease the size of the array as needed
     * @param var 
     */
    public void changeSizeArray(int var){
        IContainer[] tempArray = new IContainer[size + var];
        System.arraycopy(containers, 0, tempArray, 0, nContainers);
        containers = tempArray;
        size += nextSize;
    }
    
    /**
     * checks if the container is closed because it can only be added if it is
     * checks if the container is in treatment and if everything is well filled
     * if the container already exists it cannot be added
     * if the array where the containers are stored is full, the array is increased
     * adds a new container to the shipping order
     * @param ic container to be added
     * @return true if the container is inserted in the shipping order and false if the container already existsContainer in the shipping order
     * @throws OrderException if the shipping order status is not equal to IN_TREATMENT
     * @throws ContainerException if any parameter is null and if the container is not closed
     */
    @Override
    public boolean addContainer(IContainer ic) throws OrderException, ContainerException {
        
        if(ic.isClosed()){
            if (orderStatus!=IN_TREATMENT){
                throw new ClassOrderException("The container isn't closed");
            }else if (destination == null || customer == null){
                throw new ClassContainerException("The parameters weren't filled correctly");
            }

            for (int i = 0; i < nContainers; i++){
                if (((Container)containers[i]).getReference().equals(ic.getReference())){
                    return false;
                }
            }

            if (size == nContainers){
                changeSizeArray(nextSize);
            }

            containers[nContainers++] = ic;

            return true;
            
        } else
            return false;
    }

    /**
     * checks if the container is in treatment and if everything is well filled
     * find the container to remove
     * removes a container from the shipping order
     * if the container array has a lot of empty space the array is decremented
     * @param ic container to be removed
     * @return true if the container is removed in the shipping order and false if the container doesn't exists in the shipping order
     * @throws OrderException if the status is not IN_TREATMENT
     * @throws ContainerException if the parameter is null
     */
    @Override
    public boolean removeContainer(IContainer ic) throws OrderException, ContainerException {
        boolean found=false;
        
        if (orderStatus!=IN_TREATMENT){
            throw new ClassOrderException("The container isn't closed");
        }else if (destination == null || customer == null){
            throw new ClassContainerException("The parameters weren't filled correctly");
        }
        
        for (int i = 0; i < nContainers; i++){
            if (containers[i].equals(ic)){
                found = true;
            }
            if (found && i < nContainers - 1){
                containers[i] = containers[i + 1];
            }
        }
        
        if (found){
            containers[--nContainers] = null;
            if (size - nContainers >= 5 && size != 5){
                changeSizeArray(-nextSize);
            }
        }
        
        return found;
        
    }

    /**
     * Checks if the container exists in the shipping order
     * @param ic to check existence
     * @return true if the container exists in the shipping order and false if the container does not exists in the shipping order
     */
    @Override
    public boolean existsContainer(IContainer ic) {
        boolean x=false;
        for(int i=0;i<nContainers;i++){
            if(containers[i]==ic){
                x=true;
            }
        }
        return x;
    }

    /**
     * Searches for a given container based on its reference
     * @param string reference - to find container
     * @return the index number that refers to the position occupied by the container in the shipping order list
     */
    @Override
    public int findContainer(String string) {
        int pos=-1;
        for(int i=0;i<nContainers;i++){
            if(containers[i].getReference().equals(string)){
                pos=i;
            }
        }
        return pos;
    }

    /**
     * getter for destination person
     * @return destination person
     */
    @Override
    public IPerson getDestination() {
        return destination;
    }

    /**
     * setter for destination person
     * @param ip 
     */
    @Override
    public void setDestination(IPerson ip) {
        destination=(Person) ip.getAddress();
    }

    /**
     * Getter for customer who is responsabile by the shipping order
     * @return customer who is responsabile by the shipping order
     */
    @Override
    public ICustomer getCustomer() {
        return customer;
    }

    /**
     * getter for order status
     * @return order status
     */
    @Override
    public OrderStatus getStatus() {
        return orderStatus;
    }

    /**
     * Setter for status
     * A specific order for status should be preserved:
     *  1-if the @param status is IN_TREATMENT then the status should be: AWAITS_TREATMENT
     *  2-if the @param status is CLOSED then the status should be: IN_TREATMENT and the number of containers in the shipping order should be greater than 0. Additionally, to close the shipping order, the shipping order should be validated
     *  3-if the @param status is SHIPPED then the order status should be: closed
     * @param os represents the order status to change the status
     * @throws OrderException if the current status is not compatible with the status @param status to change
     * @throws ContainerException if the volume greater than the current volume (when shipping order is validated)
     * @throws PositionException if some item is outside (or is overflowing) the container or if some item is overlapping with other item (when shipping order is validated)
     */
    @Override
    public void setStatus(OrderStatus os) throws OrderException, ContainerException, PositionException {
        boolean isValid = false;
        switch (os){
            case IN_TREATMENT:
                if (orderStatus == AWAITS_TREATMENT){
                    isValid = true;
                }
                break;
            case CLOSED:
                if (orderStatus == IN_TREATMENT && nContainers > 0){
                    for (int i = 0; i < nContainers; i++){
                        containers[i].close();
                    }
                    isValid = true;
                }else{
                    throw new ClassContainerException();
                }
                break;
            case SHIPPED:
                if (orderStatus == CLOSED){
                    isValid = true;
                }
                break;
            case CANCELLED:
                isValid=true;
                break;
        }
        if (isValid){
            orderStatus = os;
        }else{
            throw new ClassOrderException();
        }
    }

    /**
     * Getter for shipping order unique identifier
     * @return shipping order unique identifier
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * uses a temporary array to return only containers and not null positions
     * @return an array (without null positions) for the containers in the shipping order
     */
    @Override
    public IContainer[] getContainers() {
        IContainer[] tempArray = new Container[nContainers];
        System.arraycopy(containers, 0, tempArray, 0, nContainers);
        return tempArray;
    }

    /**
     * Checks if any container is invalid
     * @throws ContainerException if the volume greater than the current volume
     * @throws PositionException if some item is outside (or is overflowing) the container or if some item is overlapping with other item
     */
    @Override
    public void validate() throws ContainerException, PositionException {
        for(int i=0;i<nContainers;i++){
            if(!containers[i].isClosed()){
                throw new ClassContainerException("One of the containers ins't closed");
            }
            containers[i].validate();
        }
    }

    /**
     * Returns a string representation with a summary of the existing containers and their items
     * @return a string representation with a summary of the existing containers and their items
     */
    @Override
    public String summary() {
        return "ID: " + getId()+
                "\nContentores:\n" + Arrays.toString(getContainers());
    }
 
    /**
     * 
     * @return values of the object address
     */
    @Override
    public String toString(){
        return "ID: " + getId()+
                "\nContentores:\n" + Arrays.toString(getContainers())+
                "\nDestino:\n " + getDestination()+
                "\nCustomer:\n " + getCustomer()+
                "\nEstado: " + getStatus();
    }
    
    /**
     * getter for number of containers
     * @return number of containers
     */
    public int getNContainers(){
        return nContainers;
    }
    
}
