import java.util.ArrayList;
import java.util.List;

public class CurrentAccount extends BankAccounts{

    public CurrentAccount(Client client, String branch, String currency) {
        super(client, branch, currency);
    }

    public static void addCurrentAccount(Client client,String branch,String currency){
        BankAccounts currentAccount=new CurrentAccount(client, branch, currency);
        List<BankAccounts> accountList = client.getAccounts().getOrDefault(client.getClientId(), new ArrayList<>());
        accountList.add(currentAccount);
        client.getAccounts().put(client.getClientId(), accountList);
    }
    
}
