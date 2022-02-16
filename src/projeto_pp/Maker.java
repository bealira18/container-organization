/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_pp;

import classOrderBase.Address;
import classOrderBase.Customer;
import classOrderBase.Person;
import classOrderPacking.Container;
import classOrderPacking.Item;
import classOrderPacking.ItemPacked;
import classOrderPacking.Position;
import classShippingOrder.ShippingOrder;
import java.util.Scanner;
import order.exceptions.BoxException;
import order.exceptions.PositionException;
import order.packing.Color;

/*
* Nome: Beatriz Fonseca Lira de Meireles
* Número: 8190124
* Turma: 2
*
* Nome: Fábio dos Santos Sousa
* Número: 8190181
* Turma: 4
*/

public class Maker {
    
    public Scanner s=new Scanner(System.in);
    
    /**
     * asks the user for input and builds the object address
     * @return address
     */
    public Address makeAddress(){
        
        System.out.print("City: ");
        String city=s.nextLine();
        
        System.out.print("Country: ");
        String country=s.nextLine();
        
        System.out.print("Number: ");
        int number=s.nextInt();
        s.nextLine();
        
        System.out.print("State: ");
        String state=s.nextLine();
        
        System.out.print("Street: ");
        String street=s.nextLine();
        
        Address address=new Address(city, country, number, state, street);
        
        return address;
    }
    
    /**
     * asks the user for input and builds the object person
     * @return person
     */
    public Person makePerson(){
        
        System.out.println("\nAddress:");
        Address address=makeAddress();
        System.out.print("Name: ");
        String name=s.nextLine();
        
        Person person=new Person(address, name);
        
        return person;
    }
    
    /**
     * asks the user for input and builds the object customer
     * @return customer
     */
    public Customer makeCustomer(){
        
        Person person=makePerson();
        
        System.out.println("\nBilling Address:");
        Address billingAddress=makeAddress();
        
        Customer customer=new Customer((Address) person.getAddress(), person.getName(), billingAddress);
        
        return customer;
    }
    
    /**
     * asks the user for input for dimensions of the box
     * @return array with dimensions
     */
    public int[] makeBox(){
        
        System.out.print("Depth: ");
        int depth=s.nextInt();
        s.nextLine();
        
        System.out.print("Height: ");
        int height=s.nextInt();
        s.nextLine();
        
        System.out.print("Length: ");
        int length=s.nextInt();
        s.nextLine();
        
        int[] dimensions=new int[]{length,height,depth};
        
        return dimensions;
    }
    
    /**
     * asks the user for input and builds the object item
     * @return item
     */
    public Item makeItem(){
        
        System.out.println("Reference: ");
        String reference=s.nextLine();
        System.out.println("Description: ");
        String description=s.nextLine();
        
        boolean ver=true;
        do{
            System.out.println("Dimensions of item:\n");
            int[] dimensions=makeBox();
            try{
                Item item=new Item(dimensions[0], dimensions[1], dimensions[2], reference, description);
                return item;
            }catch (BoxException e){
                System.out.println(e.getMessage());
                ver=false;
            }
            
        }while(ver=false);
        
        return null;
    }
    
    /**
     * asks the user for input and builds the object position
     * @return position
     */
    public Position makePosition(){
        
        boolean ver=true;
        
        do{
            System.out.println("Insert coordinates:");
            System.out.print("x: ");
            int x=s.nextInt();
            s.nextLine();
        
            System.out.print("y: ");
            int y=s.nextInt();
            s.nextLine();
        
            System.out.print("z: ");
            int z=s.nextInt();
            s.nextLine();
        
            try{
                Position position=new Position(x, y, z);
                return position;
            } catch (PositionException e){
                e.getMessage();
            }
            
        }while(ver);
        
       return null; 
    }
    
    /**
     * asks the user for input and builds the object item packed
     * @return item packed
     */
    public ItemPacked makeItemPacked(){
        
        System.out.println("Color: ");
        String color=s.nextLine();
        
        ItemPacked itemPacked=new ItemPacked(Color.valueOf(color.toLowerCase()), makeItem(), makePosition());
        
        return itemPacked;
        
    }
    
    /**
     * checks if x, y e z are greater than 0
     * @param x
     * @param y
     * @param z
     * @return true if they are greater than 0 or false if it isn't
     */
    public boolean verifeContainer(int x, int y, int z){
        
        if(x<=0 || y<=0 || z<=0){
            return false;
        }
        return true;
        
    }
    
    /**
     * asks the user for input and builds the object container
     * @return container
     */
    public Container makeContainer(){
        
        System.out.println("Reference: ");
        String reference=s.nextLine();
        System.out.println("Color: ");
        String color=s.nextLine();
        
        boolean ver = true;
        do{
            System.out.println("Dimensions of container:\n");
            int[] dimensions=makeBox();
            try{
                Container container=new Container(dimensions[0], dimensions[1], dimensions[2], reference, Color.valueOf(color.toLowerCase()));
                return container;
            }catch (BoxException e){
                System.out.println(e.getMessage());
            }
            
        }while(ver);
        
        return null;
        
    }
    
    /**
     * asks the user for input and builds the object shipping order
     * @param person
     * @param customer
     * @return shipping order
     */
    public ShippingOrder makeShippingOrder(Person person, Customer customer){
        
        ShippingOrder shippingOrder=new ShippingOrder(person, customer);
        
        return shippingOrder;
    }
    
    
    
    
}
