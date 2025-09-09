/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */

package bankaccountds;


public class Transaction {

    private final int id;
    private String type;
    private double amount;

    public Transaction() {
        this("", 0);
    }

    public Transaction(String type, double amount) {
        this.id = generateId();
        setType(type);
        setAmount(amount);
    }

    private int generateId() {
        int num = (int) (1000 * Math.random() + 1);
        return num;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Type: %s, Amount: %.2f", getId(), getType(), getAmount());
    }

}
