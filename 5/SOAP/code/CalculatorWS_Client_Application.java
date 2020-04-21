
package calculatorws_client_application;


public class CalculatorWS_Client_Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        org.me.calculator.client.CalculatorWS_Service service = new org.me.calculator.client.CalculatorWS_Service();
        org.me.calculator.client.CalculatorWS port = service.getCalculatorWSPort();
        int i= 7;
        int j= 5;
        int result = port.add(i, j);
        System.out.println("Result"+result);
       }

   
    
    
}
