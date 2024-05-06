package Homework8;

public class PepsiHandler extends SnackDispenseHandler{
    
    
        @Override
        public void handleRequest(String snackName, VendingMachine vendingMachine) {
            if(snackName.equalsIgnoreCase("Pepsi")){
                vendingMachine.setCurrentState(vendingMachine.getWaitingForMoneyState());
                vendingMachine.setSelectedSnack(snackName);
            } 
            else if (nextHandler != null) {
                nextHandler.handleRequest(snackName, vendingMachine);
            }
            else{
                System.out.println("Snack not available.");
                vendingMachine.setCurrentState(vendingMachine.getIdleState());
            }
        }
}
