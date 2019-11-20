package sample;

public class Loader extends Datahandler {

    private static Loader L = new Loader();
    public static Loader GetInstance()
    {
     return L;
    }
    public User LoadUserProfileFromDatabase(String UserName, String Password) {
        Database.Connect();
        User ret = Database.ManipulateTables("Select * from User where UserName = '"+UserName+"' and Password = '"+Password+"'",0);
        Database.CloseConnection();
        return ret;
    }
}
