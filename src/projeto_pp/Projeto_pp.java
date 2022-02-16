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
import classOrderPacking.ItemPacked;
import classShippingOrder.ShippingOrder;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import java.util.Scanner;
import order.base.OrderStatus;

/*
* Nome: Beatriz Fonseca Lira de Meireles
* Número: 8190124
* Turma: 2
*
* Nome: Fábio dos Santos Sousa
* Número: 8190181
* Turma: 4
*/

public class Projeto_pp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner x = new Scanner (System.in);
        
        System.out.println("---------- Welcomeeeeeeeee ------------");
        
        Menus menus=new Menus();
        
        int num=menus.mainMenu();
        
        Maker maker=new Maker();
        
        Address address=new Address("nn", "ee", 12, "ww", "r");
        Person person=new Person(address, "rr");
        Customer customer=new Customer(address, "idk", address);
        
        if(num==1){
            System.out.println("Enter your details:");
            //Customer customer=maker.makeCustomer();
            
            System.out.println("Enter your destination:");
            //Person person=maker.makePerson();
            ShippingOrder shippingOrder=maker.makeShippingOrder(person,customer);
            try{
                shippingOrder.setStatus(OrderStatus.IN_TREATMENT);
            }catch(ContainerException | PositionException | OrderException e){
                System.out.println(e.getMessage());
            }  
            
            System.out.println("How many containers?");
            int numContentores=x.nextInt();
            
            for(int i=0;i<numContentores;i++){
                System.out.println("Container " + (i+1));
                Container container=maker.makeContainer();
                System.out.println("How many items?");
                x.nextLine();
                int numItems=x.nextInt();
                for(int j=0;j<numItems;j++){
                    System.out.println("Item " + (j+1));
                    ItemPacked itemPacked=maker.makeItemPacked();
                    try{
                        container.addItem(itemPacked.getItem(), itemPacked.getPosition(), itemPacked.getColor());
                    }catch(ContainerException e){
                        System.out.println(e.getMessage());
                    }  
                }
                
                menus.containerMenu(container);
                
                try{
                    container.close();
                    shippingOrder.addContainer(container);
                }catch(ContainerException | PositionException | OrderException e){
                    System.out.println(e.getMessage());
                }  
            }
            
            menus.shippingOrderMenu(shippingOrder);
            
        }
           
    }
}
