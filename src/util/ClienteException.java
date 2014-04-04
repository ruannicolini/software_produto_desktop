/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author 1547816
 */
public class ClienteException extends Exception {
    
    String msg;

    public ClienteException () {
        this.msg = "Exceção na classe Cliente.";
    }

    public ClienteException (String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
    
}
