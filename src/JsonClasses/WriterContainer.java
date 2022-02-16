/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonClasses;

import classOrderPacking.Container;
import java.io.IOException;
import order.packing.IContainer;
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
 * Writer of a container
 */
public class WriterContainer {
    
    /**
     * It writes a container to an JSONObject to then be written into a .json file
     * @param icontainer Container that will be written
     * @return A JSONObject with the container
     * @throws IOException In case it can't write something
     */
    public JSONObject writesContainer(IContainer icontainer) throws IOException {
        JSONObject container = new JSONObject();
        JSONArray items = new JSONArray();
        WriterItemPacked wItemPacked = new WriterItemPacked();
        container.put("reference", icontainer.getReference());
        container.put("length", icontainer.getLenght());
        container.put("depth", icontainer.getDepth());
        container.put("height", icontainer.getHeight());
        container.put("volume", icontainer.getVolume());
        container.put("occupiedVolume", icontainer.getOccupiedVolume());
        container.put("color", ((Container)icontainer).getColor().toString());
        container.put("colorEdge", ((Container)icontainer).getColorEdge().toString());
        for (int i = 0; i < icontainer.getNumberOfItems(); i++){
            items.add(wItemPacked.writesItem(icontainer.getPackedItems()[i]));
        }
        container.put("items", items);
        return container;
    }
}
