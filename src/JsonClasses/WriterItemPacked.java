/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JsonClasses;

import java.io.IOException;
import classOrderPacking.Item;
import classOrderPacking.ItemPacked;
import order.packing.IItemPacked;
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
 * Writer of an item packed
 */
public class WriterItemPacked {
    
    /**
     * It writes a item packed to an JSONObject to then be written into a .json file
     * @param iitemPacked ItemPacked that will be written
     * @return A JSONObject with the item packed
     * @throws IOException In case it can't write something
     */
    public JSONObject writesItem(IItemPacked iitemPacked) throws IOException {
        JSONObject item = new JSONObject();
        item.put("reference", (((Item)iitemPacked.getItem()).getReference()));
        item.put("length", (((Item)iitemPacked.getItem()).getLenght()));
        item.put("depth", (((Item)iitemPacked.getItem()).getDepth()));
        item.put("height", (((Item)iitemPacked.getItem()).getHeight()));
        item.put("x", iitemPacked.getPosition().getX());
        item.put("y", iitemPacked.getPosition().getY());
        item.put("z", iitemPacked.getPosition().getZ());
        item.put("description", iitemPacked.getItem().getDescription());
        item.put("color", iitemPacked.getColor().toString());
        item.put("colorEdge", ((ItemPacked)iitemPacked).getColorEdge().toString());
        return item;
    }
}
