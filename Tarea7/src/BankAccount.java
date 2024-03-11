public class BankAccount {
    private long accountNumber;
    private double amount;
    private char type;

    public BankAccount(long accountNumber, char type) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount=0;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public char getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }


    public String getDatos(){
        System.out.println("Numero de cuenta:"+getAccountNumber());
        System.out.println("Tipo de cuenta: "+getType());
        System.out.println("Cantidad de dinero: $"+getAmount());
        return ("");
    }

    public void agregarDinero(double amount) {
        if (type == 'A') agregarDineroA(amount);
        else if (type == 'B') agregarDineroB(amount);
        else this.amount += amount;
    }

    private void agregarDineroA(double amount) {
        if (this.amount + amount <= 50000) {
            this.amount += amount;
        } else {
            System.out.println("No puede tener más de 50,000 cuenta A");
        }
    }

    private void agregarDineroB(double amount) {
        if (this.amount + amount <= 100000) {
            this.amount += amount;
        } else {
            System.out.println("No puede tener más de 100,000 cuenta B");
        }
    }
    public double retirarDinero (double amount){
        if (type == 'A') retirarDineroA(amount);
        else if (type == 'B') retirarDineroB(amount);
        else retirarDineroC(amount);
        return amount;
    }
    private void retirarDineroA(double amount){
        if (this.amount - amount >= 1000) {
            this.amount -= amount;
        } else {
            System.out.println("No puede tener menos de $1,000 en una cuenta A");
        }
    }
    private void retirarDineroB(double amount){
        if (this.amount - amount >= 5000) {
            this.amount -= amount;
        } else {
            System.out.println("No puede tener menos de $1,000 en una cuenta B");
        }
    }
    private void retirarDineroC(double amount){
        if (this.amount - amount >= 10000) {
            this.amount -= amount;
        } else {
            System.out.println("No puede tener menos de $10,000 en una cuenta C");
        }
    }
}