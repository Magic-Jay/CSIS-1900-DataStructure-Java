/**
 * Created by MagicGary on 11/6/2016.
 */
public class LinkedList<T extends Comparable<T>> implements List<T> {


    //Make an empty list.
    private Node<T> head = new Node<>();

    //add element to the end of the list and return true
    //return false if element is null
    @Override
    public boolean add(T element) {

        if(element == null){
            return false;
        }else{

            //create a new pointer and traversing the linkedlist
            Node<T> current = head;
            while(current.getNext()!=null){
                current = current.getNext();

            }
            current.setNext(new Node<> (element));

        }
        return true;
    }

    //add element to index index and return true
    //return false if element is empty or index is out of bound
    @Override
    public boolean add(int index, T element) {

        if(element == null || index < 0 || index >=size()){
            return false;
        } else{

            Node<T> current = head;
            for(int i =0; i<index; i++){
                current = current.getNext();
            }
            Node<T> newNode = new Node<T>(element,current.getNext());
            current.setNext(newNode);

        }

        return true;

    }

    //clear everything in the list to make it an empty list.
    @Override
    public void clear() {
        head = new Node<>();
    }

    //return true if the list contains element
    //else return false
    @Override
    public boolean contains(T element) {
        Node<T> current = head;

        while(current.getNext()!=null){
            current = current.getNext();
            if(current.getData().equals(element)){
                return true;
            }
        }
        return false;
    }
    //return the element at index index
    //else return null if index is out of bound
    @Override
    public T get(int index) {

        if(index < 0 || index >= size()){

            return null;
        }else{
            Node <T> current = head;

            for(int i =0; i<=index; i++){
                current = current.getNext();
            }
            return current.getData();
        }

    }

    //return the index of first appearance of the element
    //if element not in the list, return -1
    @Override
    public int indexOf(T element) {

        int index =0;

        Node<T> current = head;
        while(current.getNext()!=null){
            current = current.getNext();

            if(current.getData().equals(element)){
                return index;
            }

            index++;
        }
        return -1;
    }

    //return true if the list is empty
    //else return false
    @Override
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    //Returns the index of the last occurrence of the specified element in this list,
    // or -1 if this list does not contain the element.
    @Override
    public int lastIndexOf(T element) {

        int index = -1;
        int counter = -1;

        Node<T> current = head;
        while(current.getNext()!=null){
            current = current.getNext();

            counter++;

            if(current.getData().equals(element)){
                index=counter;
            }

        }
        return index;
    }

    //replace the element at index with element and return the
    //element that was previously at index.
    //if index is out-of-bounds or element is null, do nothing with
    //element and return null
    @Override
    public T set(int index, T element) {

        if(index >= size() || index < 0 || element == null){
            return null;

        }else {

            int counter = -1;
            Node<T> current = head;
            T tmp = current.getData();

            while(current.getNext()!=null){

                current = current.getNext();
                counter++;

                if(counter == index ){

                    tmp = current.getData();
                    current.setData(element);
                }

            }

         return  tmp;
        }

    }

    @Override
    public int size() {

        int counter = 0;

        Node<T> current = head;
        while(current.getNext()!=null){
            current = current.getNext();
            counter ++;

        }
        return counter;
    }

    //If order is true, sort the list in increasing order.
    //If order is false, sort the list in decreasing order.
    @Override
    public void sort(boolean order) {

        boolean flag = true;
        Node<T> current = head;


        while(flag){
            flag = false;
            while(current.getNext().getNext()!= null){

                if(current.getNext().getData().compareTo(current.getNext().getNext().getData())>=1){

                    T temp = current.getNext().getData();
                    current.getNext().setData(current.getNext().getNext().getData());
                    current.getNext().getNext().setData(temp);
                    flag = true;
                }
                current = current.getNext();
            }

        }

        //Create a new list and add each element in increasing sorted list
        //reversely to the new list.
        if(order == false) {
            LinkedList<T> newL = new LinkedList<>();
            while (head.getNext() != null) {
                newL.add(get(size() - 1));
                remove(size() - 1);
            }
            head = newL.head;
        }

    }

    //remove the first instance of element from the list.
    //shifts any subsequent elements to the left and return true.
    //return false if element is not found in the list.
    @Override
    public boolean remove(T element) {

        Node<T> current = head;

        while(current.getNext()!= null){
           if(current.getNext().getData().equals(element)){
               current.setNext(current.getNext().getNext());
               return  true;
           }else{
               current = current.getNext();
           }
        }
        return false;
    }

    //remove the element index index in the list and return it.
    //if index is out-of-bounds, return null.
    @Override
    public T remove(int index) {

        if(index<0 || index >=size()){
            return null;
        } else{


            int counter = -1;
            Node<T> current = head;
            T tmp = current.getData();

            while(current.getNext()!=null){

                if(counter == index-1){
                    tmp = current.getNext().getData();
                    current.setNext(current.getNext().getNext());
                    return tmp;
                }
                current = current.getNext();
                counter++;
            }
        }
        return null;
    }

    public static void main(String[] args) {

        LinkedList<String> myLinkedList = new LinkedList();
        myLinkedList.add("c");
        myLinkedList.add("a");
        myLinkedList.add("b");
        myLinkedList.add("f");
        myLinkedList.add("e");
        myLinkedList.add("o");
        myLinkedList.add("p");

        Node current = myLinkedList.head;

        while(current.getNext()!=null){
            current = current.getNext();
            System.out.println(current.getData());
        }

        myLinkedList.sort(true);
        System.out.println(" ");

        System.out.println("Sorted");
        current = myLinkedList.head;

        while(current.getNext()!=null){
            current = current.getNext();
            System.out.println(current.getData());
        }

    }


}
