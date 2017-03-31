import jdk.internal.org.objectweb.asm.util.TraceAnnotationVisitor;

/**
 * Created by MagicGary on 11/5/2016.
 */
public class ArrayList<T extends Comparable<T>> implements List<T> {

    T[] arrayList;
    int initialLength=2;//The length of this array buffer, which the capacity of the ArrayList.
    int size=0;//The size of the ArrayList, the number of elements it contains.

    //Initialize the array buffer into which the elements of the ArrayList are stored.
    public ArrayList() {

        arrayList = (T[]) new Comparable[initialLength];

    }

    //Returns the number of elements in the list.
    @Override
    public int size() {

        return size;
    }



    // increment the current list's length by twice,
    // copy over old list and set the new instance to new list
    private void incrementAndCopy(){


        initialLength = initialLength * 2;
        T[] newArrayList = (T[]) new Comparable[initialLength]; //creates a new list twice length of the original list


        // copy over the elements from old list to new list.
        for(int x = 0; x < arrayList.length; x++){
            newArrayList[x] = arrayList[x];
        }


        arrayList = newArrayList; //set the instance to the new list


    }


    //add the element to the end of the list and return true.
    //if element is null, return false.
    @Override
    public boolean add(T element) {

        if(element == null){
            return false;
        }else{
            if(size() >= arrayList.length){
                incrementAndCopy();
                arrayList[size] = element;
                size++;
            }else{
                arrayList[size] = element;
                size ++;
            }
        }
        return true;
    }


    // Inserts the specified element at the specified position in this list.
    // Shifts the element currently at that position (if any) and
    // any subsequent elements to the right (adds one to their indices).
    // If element is null, or if index is out-of-bounds return false.
    @Override
    public boolean add(int index, T element) {

        if(element == null || index >= size || index < 0){

            return false;

        }else{

            if(arrayList[size-1]!= null){

                incrementAndCopy();

                System.arraycopy(arrayList, index, arrayList, index + 1, size - index);
                arrayList[index] = element;
                size ++;

            }else{
                arrayList[index] = element;
                size++;
            }
        }

        return true;
    }

    //reset the arrayList to the length of 2 with null elements
    @Override
    public void clear() {
        arrayList = (T[]) new Comparable[initialLength];
        size = 0;
    }

    //Returns true if this list contains the specified element.
    @Override
    public boolean contains(T element) {

        for(int i = 0; i < size; i++){

            if(arrayList[i].equals(element)){
                return true;
            }
        }
        return false;
    }

    //Returns the element at the specified position in this list.
    //If index is out-of-bounds, it will return null.
    @Override
    public T get(int index) {

        if(index >= size || index < 0){
            return null;
        }
        return arrayList[index];
    }


    //return the index of the first occurrence of the specified element
    //else return -1
    @Override
    public int indexOf(T element) {

        for(int i = 0; i < size; i ++){

            if(arrayList[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    //return true if list is empty
    //else return false
    @Override
    public boolean isEmpty() {

        return size == 0;
    }


    //Returns the index of the last occurrence of the specified element in this list,
    // or -1 if this list does not contain the element.
    @Override
    public int lastIndexOf(T element) {

        for(int i = size-1; i>=0; i--){
            if(arrayList[i].equals(element)){
                return i;
            }
        }
        return -1;
    }

    //replace the element at index with element and return the
    //element that was previously at index.
    // if index is out-of-bounds or element is null, do nothing with
    //element and return null.
    @Override
    public T set(int index, T element) {

        if(index >= size || index < 0 || element == null){
            return null;
        }else {

            T oldValue = arrayList[index];
            arrayList[index] = element;
            return oldValue;

        }


    }



    //If order is true, sort the list in increasing order.
    //If order is false, sort the list in decreasing order.
    @Override
    public void sort(boolean order) {

        //soring the arrayList with ascending order
        //using bubble sort.
        boolean flag = true;
        while (flag){
            flag = false;
            for(int i=0; i<size-1; i++){
                if(arrayList[i].compareTo(arrayList[i+1])>=1){
                    T tmp = arrayList[i];
                    arrayList[i] = arrayList[i+1];
                    arrayList[i+1] = tmp;
                    flag = true;
                }
            }
        }

        //sort it in decreasing order.
        if(order==false){

            T[] newArrayList = (T[]) new Comparable[size];

            for(int i = 0; i< size; i++){
                newArrayList[i] = arrayList[size-1-i];
            }

            arrayList = newArrayList;
        }




    }

    //remove the first instance of element from the list.
    //shifts any subsequent elements to the left and return true.
    //return false if element is not found in the list.
    @Override
    public boolean remove(T element) {

        for(int i = 0; i < size; i++){

            if(element.equals(arrayList[i])){

                System.arraycopy(arrayList, i+1, arrayList, i, size - i - 1);
                arrayList[size] = null;
                size --;

                return true;
            }
        }

        return false;
    }

    //remove the element index index in the list and return it.
    //if index is out-of-bounds, return null.
    @Override
    public T remove(int index) {

        if(index<0 || index >= size){
            return null;
        }else{

           T tmp = arrayList[index];

            System.arraycopy(arrayList,index+1, arrayList, index, size-index);
            size--;

            return tmp;

        }


    }

    public static void main(String[] args) {

        ArrayList myarrayList = new ArrayList();


        myarrayList.add(0,"g");
        myarrayList.add("a");
        //myarrayList.remove(null);

        //myarrayList.sort(false);

        for(int i = 0; i<myarrayList.size; i++){
            System.out.println(myarrayList.arrayList[i]);
        }



    }
}