/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonClasses;

import classShippingOrder.ShippingOrder;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
 * Writer of a shipping order
 */
public class WriterShippingOrder {
    
    /**
     * It writes a shipping order to an JSONObject to then be written into a .json file
     * @param so Shipping order that will be written to a .json file
     * @param path Path of the .json file
     * @throws IOException In case it can't write something
     */
    public void writesShippingOrder(String path, ShippingOrder so) throws IOException {
        JSONObject obj = new JSONObject();
        WriterDestination wDestination = new WriterDestination();
        WriterContainer wContainer = new WriterContainer();
        WriterCustomer wCustomer = new WriterCustomer();
        JSONArray containers = new JSONArray();
        
        obj.put("orderId", so.getId());
        obj.put("destination", wDestination.writesDestination(so.getDestination()));
        for (int i = 0; i < so.getNContainers(); i++){
            containers.add(wContainer.writesContainer(so.getContainers()[i]));
        }
        obj.put("containers", containers);
        obj.put("customer", wCustomer.writesCustomer(so.getCustomer()));
        obj.put("status", so.getStatus().toString());

        try (FileWriter file = new FileWriter(path)) {
            file.write(obj.toJSONString());
        }
    }
}
