/**
 * Created by MagicGary on 11/7/2016.
 */
public class Coworker extends Contact {

    private String email;
    public String getEmail(){
        return  email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public Coworker(String name, long phone, String address, String comments, String email){
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setComments(comments);
        this.setEmail(email);
    }
    public String toString(){

        return this.getName() + "\n" + this.getPhone() + "\n" + this.getAddress() + "\n" + this.getComments()+ "\n" +
                this.getEmail();

    }

}
