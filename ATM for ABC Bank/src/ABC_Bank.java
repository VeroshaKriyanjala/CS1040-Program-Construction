import java.util.HashMap;

public class ABC_Bank {
        private static HashMap<Integer, Integer> pinNClients = new HashMap<>();;
        private static HashMap<Integer,Client> findClient = new HashMap<>();;
        private static HashMap<Integer,BankAccounts> bankAccountsMap = new HashMap<>();;

        public static void addClientPin(Client client) {
            pinNClients.put(client.getPin(), client.getClientId());
        }
    
        public static int getClientPin(int enteredPin) {
            return pinNClients.getOrDefault(enteredPin, -1);
        }

        public static void addClientsMap(Client client){
            findClient.put(client.getClientId(), client);
        }

        public static Client getClientsMap(int foundOutClientId){
            return findClient.get(foundOutClientId);
        }
        
        public static void addBankAccount(BankAccounts bankAccounts){
            bankAccountsMap.put(bankAccounts.getAccountNumber(), bankAccounts);
        }

        public static BankAccounts getBankAccounts(int selectedBankAccount){
            return bankAccountsMap.getOrDefault(selectedBankAccount,new BankAccounts(null, null, null));
        }

}