package sample;

public class Saver extends Datahandler implements IDecrypt {

    private Saver()
    {}
    private static Saver saver = new Saver();
    public static Saver GetInstance()
    {
        return saver;
    }
    public void UpdateUserProfile(User u,String uname,String pass) {
        Database.Connect();
        Database.ManipulateTables("Update User SET UserName = '"+uname+"', Password = '"+pass+"' WHERE User_ID = '"+u.GetID()+"'",1);
        Main.u.setUsername(uname);
        Main.u.setPassword(pass);
        Database.CloseConnection();
    }

    public  void DeleteUserProfile(User u) {
        Database.Connect();
        Database.ManipulateTables("Delete From User Where User_ID = '"+u.GetID()+"'",1);
        Database.CloseConnection();
    }

    public  void AddUserProfile(User u) {
       Database.Connect();
       Database.ManipulateTables("INSERT INTO User (FirstName,LastName,Email,PhoneNumber,UserName,Password,BankAccount) " +
               "VALUES('"+u.GetFirstName()+"','"+u.GetLastName()+"','"+u.GetEmail()+"','"+u.GetPhone()+"','"+u.getUsername()+"','"+u.getPassword()+"','"+u.getBankAccountNo()+"')" , 1);
       Database.CloseConnection();
    }

    public void UpdateUserTransactions(User u,int DonationAmount,int DonationType) {
        Database.Connect();
        Database.ManipulateTables("INSERT INTO DonationHistory(DonationAmount,DonationType,Userid) VALUES ('"+DonationAmount+"'," +
                "'"+DonationType+"','"+u.GetID()+"')",1);
        Database.CloseConnection();
    }

    @Override
    public boolean Verify() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Decrypt() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
