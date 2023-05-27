import java.util.Scanner;

public class ATM extends ABC_Bank{
    int foundOutClientId;
    Scanner scanner=new Scanner(System.in);

    public void process(){
        System.out.println("Welcome!");
        if(this.checkPin()){
            boolean iterationBankAccount=true;
            while(iterationBankAccount){
                System.out.println("These are your bank Accounts : ");
                this.clientsBankAccounts(foundOutClientId);
                BankAccounts processingBankAccount;
                do{
                    System.out.println("Select one of them to proceed");
                    int selectedBankAccount=scanner.nextInt();
                    processingBankAccount=getBankAccounts(selectedBankAccount);
                }while(processingBankAccount.getClient()==null);
                boolean iterationMainMenu=true;
                while(iterationMainMenu){
                    System.out.println("Main Menu");
                    System.out.println("1.View Balance");
                    System.out.println("2.Withdraw money");
                    System.out.println("3.Deposit money");
                    System.out.println("4.Exit");
                    int option=scanner.nextInt();
                    switch(option){
                        case 1:
                            System.out.println("Account Balance is: ");
                            System.out.println(processingBankAccount.getAccountBalance());
                            iterationMainMenu=iterationMainMenu();
                            break;
                        case 2:
                            System.out.println("Enter the amount you want to withdraw : ");
                            double withdrawAmount=scanner.nextInt();
                            if(withdrawAmount>=processingBankAccount.getAccountBalance()){
                                System.out.println("Account balance is not enough for Transaction");
                            }else if(withdrawAmount<0){
                                System.out.println("Invalid amount");
                            }else{
                                processingBankAccount.setAccountBalance(processingBankAccount.getAccountBalance()-withdrawAmount);
                                System.out.println("Account Balance is: "+processingBankAccount.getAccountBalance());
                            }
                            iterationMainMenu=iterationMainMenu();
                            break;
                        case 3:
                            System.out.println("Enter the amount you want to deposit : ");
                            double depositAmount=scanner.nextInt();
                            processingBankAccount.setAccountBalance(processingBankAccount.getAccountBalance()+depositAmount);
                            System.out.println("Account Balance is: "+processingBankAccount.getAccountBalance());
                            iterationMainMenu=iterationMainMenu();
                            break;
                        case 4:
                            iterationMainMenu=false;
                            scanner.nextLine();
                            break;
                    }
                }

                iterationBankAccount=iterationBankAccount();
            }
        }
    }

    public boolean iterationMainMenu(){
        System.out.println("Do you want another service from this bank account");
        scanner.nextLine();
        String iterationMainMenuChoice=scanner.nextLine();
        if(iterationMainMenuChoice.equals("yes")){
            return true;
        }else if(iterationMainMenuChoice.equals("no")){
            return false;
        }
        return false;
    }

    public boolean iterationBankAccount(){
        System.out.println("Do you want another service from another bank account");
        String iterationBankAccountChoice=scanner.nextLine();
        if(iterationBankAccountChoice.equals("yes")){
            return true;
        }else if(iterationBankAccountChoice.equals("no")){
            System.out.println("Thank you");
            return false;
        }
        return false;
    }

    public boolean checkPin(){
        boolean correctEnter=true;
        while(correctEnter){
            System.out.println("Enter the pin");
            int pinNumber=scanner.nextInt();
            foundOutClientId=ABC_Bank.getClientPin(pinNumber);
            if(foundOutClientId!=-1){
                correctEnter=false;
            }else{
                System.out.println("Your entered pin is wrong.");
            }
        }
        return true;
    }

    public void clientsBankAccounts(int foundOutClientId){
        Client foundOutOne=getClientsMap(foundOutClientId);
        for(BankAccounts i: foundOutOne.getBankAccounts(foundOutClientId)){
            System.out.println(i.getAccountNumber());
        }
    }
}




