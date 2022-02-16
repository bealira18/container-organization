/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classShippingOrder;

import JsonClasses.WriterShippingOrder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import order.base.OrderStatus;
import order.exceptions.ContainerException;
import order.exceptions.OrderException;
import order.exceptions.PositionException;
import packing_gui.PackingGUI;
import projeto_pp.Projeto_pp;
import shippingorder.IExporter;
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
 * Class of the exporter
 * It implements the interface of IExporter
 * It's main function is to export a shipping order by validating and the render it
 */
public class Exporter implements IExporter{
    
    WriterShippingOrder writer = new WriterShippingOrder();
    
    /**
     * It allows to ship a shipping order
     * @param iso shipping order that will be exported
     * @throws IOException In case it's not possible to write the shipping order
     * to a file .json
     */
    @Override
    public void export(IShippingOrder iso) throws IOException {
        try {
            iso.validate();
            iso.setStatus(OrderStatus.SHIPPED);
        } catch (ContainerException | PositionException | OrderException e) {
            System.out.println(e.getMessage());
        }
        
        String path = "files/ShippingOrder" + iso.getId() + ".json";
        try {
            writer.writesShippingOrder(path, (ShippingOrder)iso);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        try{
            PackingGUI.validate(path);
            PackingGUI.render(path);
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }catch(org.json.simple.parser.ParseException ex) {
            Logger.getLogger(Projeto_pp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
