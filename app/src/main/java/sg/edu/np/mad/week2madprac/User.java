package sg.edu.np.mad.week2madprac;

public class User {
    public String name;
    public String description;
    public int id;
    public static boolean followed;

    // public User(String a, String b, int c, boolean d){
    //    name = a;
    //    description = b;
    //    id = c;
    //    followed = d;
    //}

    public boolean isFollowed(){
        if (followed == true){
            return true;
        }
        else
            return false;
    }

    public User(){}
}
