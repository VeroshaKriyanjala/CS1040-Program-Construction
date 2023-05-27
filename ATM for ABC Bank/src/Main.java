public class Main {
    public static void dummyData(){
        Client verosha=new Client(250, "Verosha", "Sri Lankan", "Engineer", "No 22,Colombo", 0, "Male", 5000);
        Client Isuru=new Client(251, "Isuru", "Sri Lankan", "Engineer", "No 23,Colombo", 0, "Male", 5001);
        Client Nipuna=new Client(252, "Nipuna", "Sri Lankan", "Engineer", "No 24,Colombo", 0, "Male", 5002);
        Client Nethmi=new Client(253, "Nethmi", "Sri Lankan", "Engineer", "No 25,Colombo", 0, "Female", 5003);
        Client Sachini=new Client(254, "Sachini", "Sri Lankan", "Engineer", "No 26,Colombo", 0, "Female", 5004);
        Client Rayan=new Client(255, "Rayan", "Sri Lankan", "Engineer", "No 27,Colombo", 0, "Female", 5005);

        verosha.createBankAccount();
        verosha.createBankAccount();
        verosha.createBankAccount();
        Isuru.createBankAccount();
        Nipuna.createBankAccount();
        Nethmi.createBankAccount();
        Sachini.createBankAccount();
        Rayan.createBankAccount();
        
        verosha.requestLoan();
        Isuru.requestLoan();
    }
    public static void main(String[] args) {

        dummyData();

        ATM atm=new ATM();
        atm.process();

    }
}
