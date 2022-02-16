/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonClasses;

import java.io.IOException;
import order.base.IAddress;
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
 * Writer of an address
 */
public class WriterAddress {
    
    /**
     * It writes a address to an JSONObject to then be written into a .json file
     * @param iaddress Address that will be written
     * @return A JSONObject with the address
     * @throws IOException In case it can't write something
     */
    public JSONObject writesAddress(IAddress iaddress) throws IOException {
        JSONObject address = new JSONObject();
        address.put("city", iaddress.getCity());
        address.put("country", iaddress.getCountry());
        address.put("number", iaddress.getNumber());
        address.put("state", iaddress.getState());
        address.put("street", iaddress.getStreet());
        return address;
    }
}
