/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderExceptions;

import order.exceptions.BoxException;

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
 * Class of exceptions of box
 * It extends the class of BoxException
 */
public class ClassBoxException extends BoxException{
    
    /**
     * Contructor of an exception of a box
     * It has a built in message
     */
    public ClassBoxException (){
        super("Invalid size. Every dimension should be greater the 0 and below or equal to 50");
    }
    
    /**
     * Contructor of an exception of a box
     * @param message the message that will be displayed
     */
    public ClassBoxException (String message){
        super(message);
    }
}
