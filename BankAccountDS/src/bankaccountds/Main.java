/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */
package bankaccountds;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static LinkedList<Account> accountList = new LinkedList<>();
    static LLQueue<Client> clientQueue = new LLQueue<>();

    public static void main(String[] args) {
        DemoData();
        Scanner input = new Scanner(System.in);
        System.out.print("\u001B[36m" + ">>> Welcome To CIS Bank <<<" + "\u001B[0m");
        int selection = 0;
        do {
            try {
                System.out.print("\n------------------------------\nSelect your operation: \n"
                        + "1-> Client Queue\n"
                        + "2-> View Next Client\n"
                        + "3-> Assist Next Client\n"
                        + "4-> Account Creation\n"
                        + "5-> View All Past Transaction\n"
                        + "6-> Deposit\n"
                        + "7-> Withdraw\n"
                        + "8-> Transfer\n"
                        + "9-> View Account\n"
                        + "10-> Reset Account History\n"
                        + "0-> Leave\n"
                        + "selection ---> ");
                selection = input.nextInt();
                switch (selection) {

                    case 1:
                        clientQueue.clientQueue();
                        break;

                    case 2:
                        clientQueue.viewNextClient();
                        break;

                    case 3:
                        clientQueue.assistNextClient();
                        break;

                    case 4:
                        accountList.createAccount(clientQueue);
                        break;

                    case 5:
                        accountList.viewAccountHistory();
                        break;

                    case 6:
                        accountList.deposit();
                        break;

                    case 7:
                        accountList.withdraw();
                        break;

                    case 8:
                        accountList.transfer();
                        break;
                    case 9:
                        accountList.viewAccount();
                        break;
                    case 10:
                        System.out.print("Enter your account number: ");
                        String accountNumber = input.next();
                        Account account = accountList.getAccount(accountNumber);
                        if (account != null) {
                            LLStack<Transaction> stack = account.getPastTransactions();                            
                            stack.resetAccountHistory();
                            
                        } else {
                            System.out.println("Account is Not Found!");
                        }
                        break;
                    
                    case 0:
                        System.out.println("Thank you!");
                        break;
                    default:
                        System.out.println("Invalid selection!");
                }
            } catch (InputMismatchException ex) {
                System.err.println("invalid input!");
                input.next();
            }

        } while (selection != 0);

    }

    //Testing run
    public static void DemoData() {

        Client c1 = new Client(11, "Danah", "111");
        Client c2 = new Client(22, "Raghad", "222");
        Client c3 = new Client(33, "Amani", "333");
        Client c4 = new Client(44, "Haifa", "444");
        Client c5 = new Client(55, "Leen", "55");

        clientQueue.Enqueue(c1);
        clientQueue.Enqueue(c2);
        clientQueue.Enqueue(c3);
        clientQueue.Enqueue(c4);
        clientQueue.Enqueue(c5);

    }
}
