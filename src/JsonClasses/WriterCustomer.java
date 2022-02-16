/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonClasses;

import java.io.IOException;
import order.base.ICustomer;
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
 * Writer of a customer
 */
public class WriterCustomer {
    
    /**
     * It writes a customer to an JSONObject to then be written into a .json file
     * @param icustomer Customer that will be written
     * @return A JSONObject with the customer
     * @throws IOException In case it can't write something
     */
    public JSONObject writesCustomer(ICustomer icustomer) throws IOException {
        JSONObject customer = new JSONObject();
        WriterAddress wAddress = new WriterAddress();
        WriterAddress wBillingAddress = new WriterAddress();
        customer.put("name", icustomer.getName());
        customer.put("address", wAddress.writesAddress(icustomer.getAddress()));
        customer.put("billingAddress", wBillingAddress.writesAddress(icustomer.getBillingAddress()));
        customer.put("id", icustomer.getCustomerId());
        return customer;
    }
}
