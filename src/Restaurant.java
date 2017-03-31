/**
 * Created by MagicGary on 11/7/2016.
 */
public class Restaurant extends Contact {

    private int rating; //relative to other ratings, so it can be any int
    public int getRating(){
        return rating;
    }
    public void setRating(int rating){
        this.rating = rating;
    }
    public Restaurant(String name, long phone, String address, String comments, int rating){

        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setComments(comments);
        this.setRating(rating);

    }
    public String toString(){

        return this.getName() + "\n" + this.getPhone() + "\n" + this.getAddress() + "\n" + this.getComments()+ "\n" +
                this.getRating();

    }

}
