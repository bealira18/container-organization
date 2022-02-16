/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderExceptions;

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

/**
 * Class of exceptions of positions
 * It extends the class of PositionException
 */
public class ClassPositionException extends PositionException{
    
    /**
     * Contructor of an exception of a position
     * It has a built in message
     */
    public ClassPositionException (){
        super("Invalid coordinate. Every coordinate should be greater or equal to 0");
    }
    
    /**
     * Contructor of an exception of a position
     * @param message the message that will be displayed
     */
    public ClassPositionException (String message){
        super(message);
    }
}
