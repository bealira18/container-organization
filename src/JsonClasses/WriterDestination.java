/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonClasses;

import java.io.IOException;
import order.base.IPerson;
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
 * Writer of a destination
 */
public class WriterDestination {
    
    /**
     * It writes a destination to an JSONObject to then be written into a .json file
     * @param iperson Person that will be written
     * @return A JSONObject with the destination
     * @throws IOException In case it can't write something
     */
    public JSONObject writesDestination(IPerson iperson) throws IOException {
        JSONObject person = new JSONObject();
        WriterAddress wAddress = new WriterAddress();
        person.put("address", wAddress.writesAddress(iperson.getAddress()));
        person.put("name", iperson.getName());
        return person;
    }
}
