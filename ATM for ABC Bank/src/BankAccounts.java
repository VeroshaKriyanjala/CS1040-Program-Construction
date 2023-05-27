import java.util.List;
import java.util.Scanner;

public class BankAccounts extends ABC_Bank{
    private Client client;
    private static int accountNumberCounter=100000;
    private int accountNumber;
    private String branch;
    private String currency;
    private double accountBalance;

    public BankAccounts(Client client,String branch,String currency) {
        this.client=client;
        accountNumberCounter = accountNumberCounter+25;
        this.accountNumber=accountNumberCounter;
        this.branch=branch;
        this.currency = currency;
        this.accountBalance = 0;
        ABC_Bank.addBankAccount(this);
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    static Scanner scanner=new Scanner(System.in);

    public static void addBankAccount(Client client){
        System.out.println(" ");
        System.out.println("Hello "+client.getName()+",");
        System.out.println("What type of bank account do you want ? ");
        System.out.println("1.Savings Account");
        System.out.println("2.Current Account");
        int accountChoice=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the branch");
        String branch=scanner.nextLine();
        List<BankAccounts> retrievedList=client.getAccounts().get(client.getClientId());
        if(retrievedList != null && !retrievedList.isEmpty()){
            BankAccounts firstAccount=retrievedList.get(0);
            String currency=firstAccount.getCurrency();
            switch(accountChoice){
                case 1:
                    SavingAccounts.addSavingAccount(client,branch,currency);
                    break;
                case 2:
                    CurrentAccount.addCurrentAccount(client,branch,currency);
                    break;
            }
        }else{
            System.out.println("What is the type of currency");
            String currency=scanner.nextLine();
            switch(accountChoice){
                case 1:
                    SavingAccounts.addSavingAccount(client,branch,currency);
                    break;
                case 2:
                    CurrentAccount.addCurrentAccount(client,branch,currency);
                    break;
            }
        }
    }
}





