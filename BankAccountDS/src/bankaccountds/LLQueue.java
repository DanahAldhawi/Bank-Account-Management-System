/*
3i2 CS212
Danah Aldhawi 444009172 , Raghad Alduiaj 444009150
Amani Alhusseini 444009162 , Haifa Alghafis 444009128
Leen Alsaif 444009244
 */
package bankaccountds;

 
public class LLQueue<E> {

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
    protected Node<E> front;
    protected Node<E> rear;
    protected long size;

    public LLQueue() { 
        front = null;
        rear = null;
        size = 0;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() { 
        if (isEmpty()) {
            return null;
        }
        return front.getElement();
    }

    public E last() { 
        if (isEmpty()) {
            return null;
        }
        return rear.getElement();
    }

    public void Enqueue(E elem) {
        Node<E> newest = new Node<E>(elem, null);
        if (isEmpty()) {
            front = newest;  
        } else {
            rear.setNext(newest); 
        }
        rear = newest; 
        size++;
    }

    public E Dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = front.getElement();
        front = front.getNext();
        size--;
        if (size == 0) {
            rear = null; 
        }
        return answer;
    }

    public void display() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        long s = getSize();
        for (int i = 0; i < s; i++) {
            E element = Dequeue();
            System.out.print(element + " ");
            Enqueue(element);
        }
        System.out.println();
    }
    
    //Client Queue

    public void clientQueue() {
        if (isEmpty()) {
            System.out.println("Zero clients in the queue!");
        } else {
            int size = (int) getSize();
            System.out.print("[1st] ");
            for (int i = 0; i < size; i++) {
                Client client = (Client)Dequeue();
                System.out.print(client.getName() + " -> ");
                 Enqueue((E)client);
            }
        }
    }

    public void viewNextClient() {
        if (isEmpty()) {
            System.out.println("Zero clients in the queue.");
        } else {
            Client client = (Client)first();
            System.out.print("The next client in the queue is '" + client.getName() + "'");
        }
    }

    public void assistNextClient() {
        if (isEmpty()) {
            System.out.println("Zero clients in the queue");
        } else {
            Client client = (Client)Dequeue();
            System.out.println("Banker is assisting '" + client.getName() + "' in the moment");
            viewNextClient();
        }
    }
}
