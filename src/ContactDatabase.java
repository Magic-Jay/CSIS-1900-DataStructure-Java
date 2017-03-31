import java.util.Arrays;

/**
 * Created by MagicGary on 11/7/2016.
 */
public class ContactDatabase {

    private List<Contact> list; //underlying list of contacts

    //initialize the underlying list based on the value of type
    //If type.equals("array"),underlying list is a ArrayList
    //If type.equals("linked"), underlying list is a LinkedList
    public ContactDatabase(String type){

        if(type.equals("array")){

             list = new ArrayList();

        }
        if (type.equals("linked")){

             list = new LinkedList();
        }

    }

    //add c to the end of the list and return true if successful, false otherwise.
    public boolean add(Contact c){
        return list.add(c);
    }

    //This will try to find a contact with name field that contains
    //name. Do the same as in lab and use the built in String method public boolean contains(String
    //anotherString)∗∗. Return null if no contact was found.
    public Contact find(String name) {

        for(int i =0; i<list.size(); i++){
            if(list.get(i).getName().contains(name)){
                return list.get(i);
            }
        }
        return null;
    }

    //This will remove the contact object currently at index index,
    // if index is out of bounds, return null.
    public Contact remove(int index){
        return list.remove(index);
    }

    //This will return the contact object currently at index index. If index is out of bounds, return null.
    public Contact get(int index){
        return list.get(index);
    }

    //This will sort the list in alphabetical order based on compareTo.
    public void sort() {
        list.sort(false);
    }

    //This will return an array of Contact objects
    //that have the type type. You can assume that type will only take on the values "friend", "coworker",
    //or "restaurant".
    public Contact[] getContactsByType(String type) {
        Contact[] result;

        if(type.equals("friend")) {
            int counter = 0;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Friend){
                    counter++;
                }
            }

            result = new Contact[counter];
            int j =0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Friend){
                    result[j] = list.get(i);
                    j++;
                }
            }

            return result;
        } else if(type.equals("coworker")) {

            int counter = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Coworker){
                    counter++;
                }
            }

            result = new Contact[counter];
            int j=0;
            for (int i = 0; i < list.size(); i++) {

                if (list.get(i) instanceof Coworker){
                    result[j] = list.get(i);
                    j++;
                }
            }

            return  result;
        } else if(type.equals("restaurant")){

            int counter = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) instanceof Restaurant){
                    counter++;
                }
            }

            result = new Contact[counter];
            int j =0;
            for(int i =0; i< list.size(); i++){
                if(list.get(i) instanceof Restaurant){
                    result[j] = list.get(i);
                    j++;
                }
            }

            return result;
    }else{
            return null;
        }

    }

    //This will return the friend with the earliest birthday. In the case
    //where no Friend objects are in the list, return null.
    public Contact getOldestFriend(){

        int minimumBirthday = 99999999; //initialize the minimum birthday to the maximum integer.
        int index = -1; //initialize the index of which friend instance has minimum birthday to -1;

        //find the minimum birthday and set the index to the one with minimum birthday
        for(int i =0; i< list.size(); i++){
            if(list.get(i) instanceof  Friend) {
                if (((Friend) list.get(i)).getBirthday() < minimumBirthday) {
                    minimumBirthday = ((Friend) list.get(i)).getBirthday();
                    index = i;
                }
            }
        }

        //return the friend with earliest birthday if Friend object exists.
        return list.get(index);
    }

    //This will return a “mailto” address containing all Coworker emails.
    //For example, if we had emails user@site.net and otheruser@othersite.net, the “mailto” link would
    //be the string "mailto:user@site.net,otheruser@othersite.net".
    public String getMailToLink(){
        String result ="mailto:";//initialize the heading of the string.
        Contact [] coworker = getContactsByType("coworker");//get the list of all coworkers.

       for(int i =0; i< coworker.length; i++){

               result = result + ((Coworker)coworker[i]).getEmail();
       }
        return result;
    }

    // This will return an array containing the top-k restaurants in the list.
    // In the event that there are less than k, say l, restaurants in the list, return all of them
    //in an array of length l. In the event that there are no restaurants in the list, return null.
    public Contact[] getTopKRestaurants(int k){
        Contact[] restaurant = getContactsByType("restaurant"); //get the restaurant list.

        //sort by rating
        boolean flag = true;
        while (flag){
            flag = false;
            for(int i=0; i<restaurant.length-1; i++){
                if(((Restaurant)restaurant[i]).getRating()<((Restaurant)restaurant[i+1]).getRating()){
                    Restaurant tmp = (Restaurant)restaurant[i];
                    restaurant[i] = restaurant[i+1];
                    restaurant[i+1] = tmp;
                    flag = true;
                }
            }
        }

        if(restaurant.length < k){
            return restaurant;
        }else{
            Restaurant[] result = new Restaurant[k];
            for(int i = 0; i<k; i++ ){
                result[i] = (Restaurant) restaurant[i];
            }

            return result;
        }

    }

    public static void main(String[] args) {


        Friend a = new Friend( "Josh0", 1234 , "address",  "comments", 19920927);
        Friend b = new Friend( "Josh1", 1234 , "address",  "comments", 19900927);
        Friend c = new Friend( "Josh2", 1234 , "address",  "comments", 19990927);
        Friend d = new Friend( "Josh1", 1234 , "address",  "comments", 19910927);
        Restaurant e = new Restaurant("Pagoda0", 3456, "address2", "good", 10);
        Restaurant f = new Restaurant("Pagoda1", 3456, "address2", "good", 9);
        Restaurant g = new Restaurant("Pagoda2", 3456, "address2", "good", 6);
        Restaurant h = new Restaurant("Pagoda3", 3456, "address2", "good", 8);




        ContactDatabase mydatabase= new ContactDatabase("linked");

        mydatabase.add(a);
        mydatabase.add(b);
        mydatabase.add(c);
        mydatabase.add(d);
        mydatabase.add(e);
        mydatabase.add(f);
        mydatabase.add(g);
        mydatabase.add(h);


        System.out.println(Arrays.toString(mydatabase.getTopKRestaurants(1)));

    }
}


