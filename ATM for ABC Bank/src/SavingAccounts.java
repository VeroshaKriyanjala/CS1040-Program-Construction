import java.util.ArrayList;
import java.util.List;

public class SavingAccounts extends BankAccounts{
    public SavingAccounts(Client client, String branch, String currency) {
        super(client, branch, currency);
    }

    public static void addSavingAccount(Client client,String branch,String currency){
        BankAccounts savingAccount=new SavingAccounts(client,branch,currency);
        List<BankAccounts> accountList = client.getAccounts().getOrDefault(client.getClientId(), new ArrayList<>());
        accountList.add(savingAccount);
        client.getAccounts().put(client.getClientId(), accountList);
    }
}
