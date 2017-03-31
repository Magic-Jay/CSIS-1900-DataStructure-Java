/**
 * Created by MagicGary on 11/7/2016.
 */
public class Friend extends Contact {
    private int birthday; //store as YYYYMMDD

    public int getBirthday(){
        return birthday;
    }

    public void setBirthday(int birthday){
        this.birthday =birthday;
    }

    public Friend(String name, long phone, String address, String comments, int birthday){
        this.setName(name);
        this.setPhone(phone);
        this.setAddress(address);
        this.setComments(comments);
        this.setBirthday(birthday);
    }

    public String toString(){

        return this.getName() + "\n" + this.getPhone() + "\n" + this.getAddress() + "\n" + this.getComments()+ "\n" +
                this.getBirthday();

    }
}
