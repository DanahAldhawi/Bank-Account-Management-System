/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */
package bankaccountds;

public class SavingsAccount extends Account {

    private double interestPercent;

    public SavingsAccount() {
        this(null);
    }

    public SavingsAccount(Client owner) {
        super(owner);
        setInterestPercent(0.05);
    }

    public double getInterestPercent() {
        return interestPercent;
    }

    public void setInterestPercent(double interestPercent) {
        this.interestPercent = interestPercent;
    }

     @Override
    public String toString() {
        return String.format("Savings Account\n%s\nMax Interest Rate: %.1f%%", super.toString(), getInterestPercent() * 100);
    }
    
}

