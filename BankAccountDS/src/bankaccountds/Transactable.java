/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */
package bankaccountds;

public interface Transactable {

    public abstract void withdraw(double amount);

    public abstract void deposit(double amount);

    public abstract void transfer(double amount, int id);
}
