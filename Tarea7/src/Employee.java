import java.util.ArrayList;

public class Employee {

    private String name;
    private String lastName;
    private ArrayList<BankAccount> accountList;

    public Employee(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        this.accountList = new ArrayList<>();
    }


    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFullName(){
        System.out.println(name+" "+lastName);
        return ("");
    }
    public ArrayList<BankAccount> getAccountList() {
        return accountList;
    }

    public void addAccount(BankAccount account) {
        accountList.add(account);
    }

    public String getDatosUsuario (){
        System.out.println("Titular de la cuenta: "+getName()+ " "+getLastName());
        System.out.println(accountList);
        return ("");
    }
}