/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */
package bankaccountds;

public class LLStack<E> {
    //-------------------------------- Node Class --------------------------------------- 

    static class Node<E> {

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

        public void setelement(E element) {
            this.element = element;
        }
    }
    //-------------------------------- End Node Class ---------------------------------------

    private Node<E> top;  
    private int size;    

    public LLStack() {   
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E top() {
        if (isEmpty()) {
            return null;
        }
        return top.getElement();
    }

    public void push(E elem) {
        Node<E> v = new Node<E>(elem, top);   
        top = v;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E temp = top.getElement();
        top = top.getNext();    
        size--;
        return temp;
    }

    
   
    public void display() {
        if (isEmpty()) {
            System.out.println("No Transactions, Stack is empty!");
            return;
        }

        LLStack<E> tempStack = new LLStack<>();
        while (!isEmpty()) {
            E ele = pop();
            System.out.println(ele);
            System.out.println("-----------------------------------------");
            tempStack.push(ele);
        }

        
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }

    public void showTransactionsByType(String type) {
        LLStack<E> tempStack = new LLStack<>();
        while (!isEmpty()) {
            E ele = pop();
            if (((Transaction) ele).getType().equalsIgnoreCase(type)) {
                System.out.println(ele);
                System.out.println("-----------------------------------------");
            }
            tempStack.push(ele);
        }

        
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }

    public void removeLastTransactions(int n) {

        if (size() >= n) {
            for (int i = 0; i < n; i++) {
                pop();
            }
            System.out.println("Last " + n + " transactions have been removed!");
        } else {
            System.out.println("There is no " + n + " transactions in your account!");
        }

    }

    public void resetAccountHistory() {
        while (!isEmpty()) {
            pop();
        }
        System.out.print("Account history has been rest!");
    }
    
    public int countTransaction(String type){
        int count = 0;
         LLStack<E> tempStack = new LLStack<>();
        while (!isEmpty()) {
            E ele = pop();
            if (((Transaction) ele).getType().equalsIgnoreCase(type)) {
                count++;
            }
            tempStack.push(ele);
        }

        
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
        return count;
    }
}
