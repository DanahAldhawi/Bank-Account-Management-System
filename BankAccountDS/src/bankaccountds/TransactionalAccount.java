/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */
package bankaccountds;


public class TransactionalAccount extends Account {

    private double maxWithdraw; //per day

    public TransactionalAccount() {
        this(null);
    }

    public TransactionalAccount(Client owner) {
        super(owner);
        setMaxWithdraw(20000);
    }

    public double getMaxWithdraw() {
        return maxWithdraw;
    }

    public void setMaxWithdraw(double maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    @Override
    public void withdraw(double amount) {

        if (amount > maxWithdraw) {
            System.out.println("Invalid amount!");
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public String toString() {
        return String.format("Checking Account\n%s\nMax Withdrawl: %.2f", super.toString(), getMaxWithdraw());
    }
}

