/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderExceptions;

import order.exceptions.OrderException;

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
 * Class of exceptions of order
 * It extends the class of OrderException
 */
public class ClassOrderException extends OrderException{
    
    /**
     * Contructor of an exception of a order
     * It has a built in message
     */
    public ClassOrderException() {
        super("The status you've defined isn't valid for this order");
    }
    
    /**
     * Contructor of an exception of a order
     * @param message the message that will be displayed
     */
    public ClassOrderException (String message){
        super(message);
    }
}
