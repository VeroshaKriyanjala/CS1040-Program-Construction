import java.util.HashMap;
import java.util.List;

public class Client {
    private int clientId;
    private String name;
    private String nationality;
    private String occupation;
    private String address;
    private int age;
    private String gender;
    private int pin;
    private HashMap<Integer,List<BankAccounts>> accounts;

    public Client(int clientId,String name,String nationality,String occupation,String address,int age,String gender,int pin){
        this.clientId=clientId;
        this.name=name;
        this.nationality=nationality;
        this.occupation=occupation;
        this.address=address;
        this.age=age;
        this.gender=gender;
        this.pin=pin;
        this.accounts=new HashMap<>();
        ABC_Bank.addClientPin(this);
        ABC_Bank.addClientsMap(this);
    }

    public HashMap<Integer, List<BankAccounts>> getAccounts() {
        return accounts;
    }

    public List<BankAccounts> getBankAccounts(int foundOutClientId){
        return this.accounts.get(foundOutClientId); 
    }

    public void setAccounts(HashMap<Integer, List<BankAccounts>> accounts) {
        this.accounts = accounts;
    }

    public int getClientId(){
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void createBankAccount(){
        BankAccounts.addBankAccount(this);
    }

    public void requestLoan(){
        Loans.addLoan(this);
    }
}
