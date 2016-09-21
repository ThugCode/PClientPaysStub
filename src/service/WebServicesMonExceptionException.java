
/**
 * WebServicesMonExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package service;

public class WebServicesMonExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1444029085432L;
    
    private service.WebServicesStub.WebServicesMonException faultMessage;

    
        public WebServicesMonExceptionException() {
            super("WebServicesMonExceptionException");
        }

        public WebServicesMonExceptionException(java.lang.String s) {
           super(s);
        }

        public WebServicesMonExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public WebServicesMonExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(service.WebServicesStub.WebServicesMonException msg){
       faultMessage = msg;
    }
    
    public service.WebServicesStub.WebServicesMonException getFaultMessage(){
       return faultMessage;
    }
}
    