package sample;

import java.sql.*;
public class Database {

    public static Connection conn;
    public static void Connect()
    {
        try
        {
        conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Mostafa\\Desktop\\Donation System\\src\\sample\\OOSEDB.db");
        //Statement statement = conn.createStatement();
        //statement.execute("Create");
      //     ResultSet resultSet = statement.getResultSet();
    //        while (resultSet.next())
        //    {
       //         String name  =  resultSet.getString("");
         //       String Phone = resultSet.getString("");
           //     String Email = resultSet.getString("");
           // }
            //statement.close();
            //conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Something went wrong "+e.getMessage());
        }
        
    }
    public void Createtable() {
    }

    public static void CloseConnection()
    {
        try
        {
            if (conn!=null)
                conn.close();
        }
        catch(SQLException e)
        {
            System.out.println("error happened when closing conn");
        }
        
        
    }
    public void Altertable() {
    }

    public void Renametable() {
    }

    public static User ManipulateTables(String sstatement,int operation) {
       // throw new UnsupportedOperationException("Not supported yet.");
       try{
        Statement statement = conn.createStatement();
        boolean exec = statement.execute(sstatement);
        if(operation==0)
        {
        User ret = new User();
        ResultSet resultSet = statement.getResultSet();
        int ID;
        String fname;
        String LastName;
        String Phone;
        String Email;
        String password;
        String uname;
        String baccount;
        int opmade;
        ID    = resultSet.getInt("User_ID");
        fname  =  resultSet.getString("FirstName");
        LastName = resultSet.getString("LastName"); 
        Phone = resultSet.getString("PhoneNumber");
        Email = resultSet.getString("Email");
        password = resultSet.getString("Password");
        uname = resultSet.getString("UserName");
        baccount=resultSet.getString("BankAccount");
        ret.setID(ID);
        ret.setFirstName(fname);
        ret.setLastName(LastName);
        ret.setPhoneNumber(Phone);
        ret.setEmail(Email);
        ret.setPassword(password);
        ret.setUsername(uname);
        ret.setBankAccountNo(baccount);
        return ret;
        }
        if(operation==1)
        {
          
           if(exec)System.out.println("Operation failed");
           else System.out.println("Operation successful");
            
        }
            statement.close();
            return null;
       }
       catch(SQLException e)
       {
           e.printStackTrace();
           System.out.println("Error creating statement "+ sstatement);
       }
       return null;
    }
}
