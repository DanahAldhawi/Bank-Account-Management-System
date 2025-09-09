/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */

package bankaccountds;

import java.util.Scanner;

//SinglyLinkedList
public class LinkedList<E>  {
//---------------- nested Node class ----------------

    private static class Node<E> {

        private E element; 
        private Node<E> next; 

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }
//----------- end of nested Node class -----------

    
    private Node<E> head = null; 
    private Node<E> tail = null; 
    private int size = 0; 

    public LinkedList() {
    } // constructs an initially empty list

    
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { 
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() { 
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    
    public void addFirst(E e) { 
        head = new Node<>(e, head); 
        if (size == 0) {
            tail = head; 
        }
        size++;
    }

    public void addLast(E e) { 
        Node<E> newest = new Node<>(e, null); 
        if (isEmpty()) {
            head = newest; 
        } else {
            tail.setNext(newest); 
        }
        tail = newest; 
        size++;
    }

    public E removeFirst() { 
        if (isEmpty()) {
            return null; 
        }
        E answer = head.getElement();
        head = head.getNext(); 
        size--;
        if (size == 0) {
            tail = null; 
        }
        return answer;
    }

    public E removeLast() {  
        if (size == 0) {
            return null; 
        } else {
            E data = tail.getElement();  
            if (size == 1) { 
                head = tail = null;
            } else { 
                Node temp1 = head;;
                Node temp2 = null; 
                while (temp1.getNext() != null) { 
                    temp2 = temp1;
                    temp1 = temp1.getNext();
                }
                temp2.setNext(null); 
                tail = temp2; 
            }
            size--; 
            return data; 
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("The list is empty!");
        } else {
            Node<E> current = head;
            while (current != null) {
                System.out.println(current.getElement());
                System.out.println("-----------------------------");
                current = current.getNext();
            }
        }
    }

    public void createAccount(LLQueue<Client> clientQueue) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your id: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter your phone number: ");
        String phone = input.next();
        Client client = new Client(id, name, phone);
        clientQueue.Enqueue(client);
        Account account;
        int accountTypeOption;
        do {
            System.out.print("Select Account Type: \n"
                    + "1-> Transactional Account\n"
                    + "2-> Savings Account\n"
                    + "--> ");
            accountTypeOption = input.nextInt();

        } while (accountTypeOption < 1 || accountTypeOption > 2);

        if (accountTypeOption == 1) {
            account = new TransactionalAccount(client);
        } else {
            account = new SavingsAccount(client);
        }
        addLast((E) account);
        System.out.println("Your account has been created successfully!");
        System.out.println(account);
    }

    public Account getAccount(String accountNumber) {
        Account account = null;
        int size = size();
        for (int i = 0; i < size; i++) {
            Account acc = (Account) removeFirst();
            if (acc.getAccountNumber().equals(accountNumber)) {
                account = acc;
            }
            addLast((E) acc);
        }
        return account;
    }

    public void viewAccountHistory() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = input.next();
        Account account = getAccount(accountNumber);
        if (account != null) {
            account.displayPastTransactions();
        } else {
            System.out.println("Account with number " + accountNumber + " is not found!");
        }
    }

    public void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = input.next();
        Account account = getAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = input.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account with number " + accountNumber + " is not found!");
        }
    }

    public void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = input.next();
        Account account = getAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = input.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account with number " + accountNumber + " is not found!");
        }
    }

    public void transfer() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = input.next();
        Account account = getAccount(accountNumber);

        if (account != null) {
            System.out.println("Enter Receiver  Name: ");
            String receiverName = input.next();
            System.out.println("Enter Receiver  ID: ");
            int receiverID = input.nextInt();
            Client receiver = new Client(receiverID, receiverName);
            System.out.print("Enter the amount you want to transfer: ");
            double amount = input.nextDouble();
            account.transfer(amount, receiverID);
        } else {
            System.out.println("Account with number " + accountNumber + " is not found!");
        }
    }

    public void viewAccount() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your account number: ");
        String accountNumber = input.next();
        if (isEmpty()) {
            System.out.println("No accounts!");
        } else {
            Account account = getAccount(accountNumber);
            if (account != null) {
                System.out.println(account);
            } else {
                System.out.println("Account with number " + accountNumber + " is not found!");
            }
        }

    }

}
