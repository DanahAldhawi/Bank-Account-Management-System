/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */
package bankaccountds;


public class Client {

    private int id;
    private String name;
    private String phoneNum;

    public Client() {
        this(0, "", "");
    }

    public Client(int id, String name) {
        setId(id);
        setName(name);
    }

    public Client(int id, String name, String phoneNum) {
        setId(id);
        setName(name);
        setPhoneNum(phoneNum);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Name: %s, Phone: %s", getId(), getName(), getPhoneNum());
    }
}
