/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_pp;

import classOrderPacking.Container;
import classOrderPacking.Item;
import classOrderPacking.ItemPacked;
import classShippingOrder.Exporter;
import classShippingOrder.ShippingOrder;
import java.io.IOException;
import java.util.Scanner;
import order.base.OrderStatus;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;

/*
* Nome: Beatriz Fonseca Lira de Meireles
* Número: 8190124
* Turma: 2
*
* Nome: Fábio dos Santos Sousa
* Número: 8190181
* Turma: 4
*/

public class Menus {
    
    public Scanner s=new Scanner(System.in);
    
    /**
     * show the main menu
     * @return option
     */
    public int mainMenu(){
        
        System.out.println("\nChoose one of the options:");
        
        System.out.println("1- Shipping Order");
        System.out.println("0- Leave");
        
        int num=s.nextInt();
        
        return num;
    }
    
    /**
     * show the shipping order menu
     * @param shippingOrder 
     */
    public void shippingOrderMenu(ShippingOrder shippingOrder){
        
        ShippingOrder shippingOrder2=shippingOrder;
        Maker maker=new Maker();
        
        System.out.println("\nChoose one of the options:");
        int num;
        
        do{
            System.out.println("1- Add container");
            System.out.println("2- Remove containers");
            System.out.println("3- Summary shipping order");
            System.out.println("4- Export");
            System.out.println("0- Leave");
            num=s.nextInt();
            s.nextLine();
            
            switch(num){
                case 1:
                    Container container=maker.makeContainer();
                    System.out.println("Do you want to add an item?");
                    System.out.println("1- Yes");
                    System.out.println("2- No");
                    int x=s.nextInt();
                    s.nextLine();
                    if(x==1){
                        containerMenu(container);
                    }
                    try{
                        container.close();
                        shippingOrder2.addContainer(container);
                    }catch(ContainerException | OrderException | PositionException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Insert container's reference: ");
                    int i=shippingOrder2.findContainer(s.nextLine());
                    if(i!=-1){
                        try{
                            shippingOrder2.removeContainer(shippingOrder2.getContainers()[i]);
                        }catch(ContainerException | OrderException e){
                            System.out.println(e.getMessage());
                        }
                    } else{
                        System.out.println("The container doesn't exist");
                    }
                    break;
                case 3:
                    System.out.print("Summary: ");
                    System.out.println(shippingOrder2.summary());
                    break;
                case 4:
                    Exporter exporter = new Exporter();
        
                    try{
                        shippingOrder2.setStatus(OrderStatus.CLOSED);
                        try{
                            exporter.export(shippingOrder2);
                        }catch(IOException e){
                        System.out.println(e.getMessage());
                        }
                    }catch(ContainerException | PositionException | OrderException e){
                        System.out.println(e.getMessage());
                    }catch(NullPointerException e){
                        System.out.println("Os parâmetros não foram escritos corretamente no ficheiro .json");
                    }
                    break;
                default:
                    if(num!=0)
                        System.out.println("Insert a valid number");
                    break;
            }
        }while(num!=0);
        
    }
    
    /**
     * show the container menu
     * @param container 
     */
    public void containerMenu(Container container){
        
        Maker maker=new Maker();
        
        System.out.println("\nChoose one of the options:");
        int num;
        
        do{
            System.out.println("1- Add item");
            System.out.println("2- Remove item");
            System.out.println("3- Summary container");
            System.out.println("0- Close");
            num=s.nextInt();
            s.nextLine();
            
            switch(num){
                case 1:
                    ItemPacked itemPacked=maker.makeItemPacked();
                    try{
                        container.addItem(itemPacked.getItem(), itemPacked.getPosition(), itemPacked.getColor());
                    }catch(ContainerException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    try{
                        System.out.print("Insert item's reference: ");
                        String i=s.nextLine();
                        Item item=(Item) container.getItem(i);
                        container.removeItem(item);
                    }catch(ContainerException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println(container.toString());
                    break;
                default:
                    if(num!=0)
                        System.out.println("Insert a valid number");
                    break;
            }
        }while(num!=0);
        
        
    }
    
}
