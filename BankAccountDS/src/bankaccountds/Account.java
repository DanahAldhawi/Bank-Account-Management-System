/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */

package bankaccountds;


public abstract class Account implements Transactable {

    private String accountNumber;
    private double balance;
    private Client owner;
    private LLStack<Transaction> pastTransactions;
    private String membershipType;

    public Account() {
        this(null);
    }

    public Account(Client owner) {
        accountNumber = generateAccountNumber();
        setOwner(owner);
        setBalance(0);
        pastTransactions = new LLStack<>();
        setMembershipType("Silver");
    }

    private String generateAccountNumber() {
        String s = "";
        for (int i = 1; i <= 14; i++) {
            s += (int) (Math.random() * 10);
        }
        return s;
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0 || amount > balance) {
            System.out.println("Invalid amount!");
        } else {
            balance -= amount;
            System.out.println("You withdrew " + amount + " successfully!");
            System.out.printf("Your new balance is %.2f\n", getBalance());

            //log the transaction to push in stack
            Transaction transaction = new Transaction("Withdrawal", amount);
            pastTransactions.push(transaction);
        }

    }
@Override
    public void transfer(double amount, int id) {

        if (amount <= 0 || amount > getBalance()) {
            System.out.println("Invalid amount!");
        } else {           
            balance -= amount;
            System.out.println("You transferd to " + id + ", " + amount + " successfully!");
            System.out.printf("Your new balance is %.2f\n", getBalance());

            //log the transaction to push in stack
            Transaction transaction = new Transaction("Transfered", amount);
            pastTransactions.push(transaction);
        }

    }
    
    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance += amount;
            System.out.println("You deposited " + amount + " successfully!");
            System.out.printf("Your new balance is %.2f\n", getBalance());

            //log the transaction to push in stack
            Transaction transaction = new Transaction("Deposit", amount);
            pastTransactions.push(transaction);
        }
    }

    public void displayPastTransactions() {
        System.out.println("Account Transaction History: ");
        pastTransactions.display();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }

    public void setOwner(Client owner) {
        this.owner = owner;
    }

    public LLStack<Transaction> getPastTransactions() {
        return pastTransactions;
    }

    public void setPastTransactions(LLStack<Transaction> pastTransactions) {
        this.pastTransactions = pastTransactions;
    }

  public String MembershipType(double balance) {
        if (getBalance() >= 40000) {
            setMembershipType("Platinum");
        } else if (getBalance() >= 10000 && balance < 40000) {
            setMembershipType("Gold");
        } else if (getBalance() >= 0) {
            setMembershipType("Silver");
        }
        return membershipType;
    }

    public String getMembershipType() {
        return MembershipType(getBalance());
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

   @Override
    public String toString() {
        return String.format("---------------------------\nClient Info: %s\nAccount Number: %s\nAccount Balance: %.2f\nAccount Membership: %s\n---------------------------", getOwner(), getAccountNumber(), getBalance(), getMembershipType());
    }
}
