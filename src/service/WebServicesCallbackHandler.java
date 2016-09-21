
/**
 * WebServicesCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package service;

    /**
     *  WebServicesCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class WebServicesCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public WebServicesCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public WebServicesCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getNomsPays method
            * override this method for handling normal response from getNomsPays operation
            */
           public void receiveResultgetNomsPays(
                    service.WebServicesStub.GetNomsPaysResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNomsPays operation
           */
            public void receiveErrorgetNomsPays(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getTousLesPays method
            * override this method for handling normal response from getTousLesPays operation
            */
           public void receiveResultgetTousLesPays(
                    service.WebServicesStub.GetTousLesPaysResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getTousLesPays operation
           */
            public void receiveErrorgetTousLesPays(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getUnPays method
            * override this method for handling normal response from getUnPays operation
            */
           public void receiveResultgetUnPays(
                    service.WebServicesStub.GetUnPaysResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getUnPays operation
           */
            public void receiveErrorgetUnPays(java.lang.Exception e) {
            }
                


    }
    