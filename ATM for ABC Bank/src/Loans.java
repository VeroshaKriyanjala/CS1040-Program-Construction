import java.util.List;
import java.util.Scanner;

public class Loans {
    private Client client;
    private BankAccounts bankAccount;
    private static int loanId=0;
    private double loanAmount;
    private double interest;

    public Loans(Client client,BankAccounts bankAccount,double loanAmount) {
        this.client = client;
        this.bankAccount=bankAccount;
        this.loanAmount = loanAmount;
        this.interest = 12.5;
        loanId++;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public static int getLoanId() {
        return loanId;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public BankAccounts getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccounts bankAccount) {
        this.bankAccount = bankAccount;
    }
    static Scanner scanner=new Scanner(System.in);

    public static void addLoan(Client client){
        List<BankAccounts> retrievedList=client.getAccounts().get(client.getClientId());
        if(retrievedList != null && !retrievedList.isEmpty()){
            System.out.println("These are the bank accounts related to you ");
            for(BankAccounts i: retrievedList){
                System.out.println(i.getAccountNumber());
            }
            System.out.println("You have to link loan with one of these Bank Accounts");
            int selectedAccountNumber;
            BankAccounts selectedAccount=null;
            while (true) {
                boolean accountFound = false;
                selectedAccountNumber=scanner.nextInt();
                for (BankAccounts i : retrievedList) {
                    if (i.getAccountNumber() == selectedAccountNumber) {
                        selectedAccount = i;
                        accountFound = true;
                        break;
                    }
                }
                if (accountFound) {
                    break;
                } else {
                    System.out.println("You entered the wrong account number. Enter again");
                }
            }
            
            System.out.println("Enter the amount do yoou want : ");
            double loanMoney=scanner.nextInt();
            Loans loan=new Loans(client,selectedAccount,loanMoney);
            System.out.println("This is your loan "+loan.getLoanAmount()+" loan money is credited to your "+selectedAccountNumber+" bank account.");
        }else{
            System.out.println(client.getName()+", you can not apply for a loan because you have not an account in the bank ");
        }
    }

}
