/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderExceptions;

import order.exceptions.ContainerException;

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
 * Class of exceptions of container
 * It extends the class of ContainerException
 */
public class ClassContainerException extends ContainerException{  
    
    /**
     * Contructor of an exception of a container
     * It has a built in message
     */
    public ClassContainerException (){
        super("The container is already closed");
    }
    
    /**
     * Contructor of an exception of a container
     * @param message the message that will be displayed
     */
    public ClassContainerException (String message){
        super(message);
    }
}
