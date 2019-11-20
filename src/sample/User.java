package sample;

public class User {

    private int ID;
    private String FirstName;
    private String LastName;
    private String Email;
    private String PhoneNumber;
    private String Username;
    private String Password;
    private String BankAccountNo;

    public User()
    {

    }
    public User(String firstName, String lastName, String email, String phoneNumber, String username, String password, String bankAccountNo) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
        Username = username;
        Password = password;
        BankAccountNo = bankAccountNo;
    }

    public String getBankAccountNo() {
        return BankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        BankAccountNo = bankAccountNo;
    }
    public int GetID()
    {
        return this.ID;
    }
    public String getPassword()
    {
        return this.Password;
    }
    public String getUsername()
    {
        return this.Username;
    }
    public String getLastName()
    {
        return this.LastName;
    }
    public String GetFirstName()
    {
        return this.FirstName;
    }
    public String GetLastName()
    {
        return this.LastName;
    }
    public String GetEmail()
    {
        return this.Email;
    }
    public String GetPhone()
    {
        return this.PhoneNumber;
    }
    public UserType getpath(UserType _links_UTL) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public void setFirstName(String FirstName)
    {
        if (!FirstName.isEmpty()&&FirstName.matches("[A-Za-z]+"))
        this.FirstName=FirstName;
        
    }
    public void setLastName(String LastName)
    {
        if (!LastName.isEmpty()&&FirstName.matches("[A-Za-z]+"))
        this.LastName = LastName;
    }
    public void setEmail(String Email)
    {
        if(!Email.isEmpty())
        this.Email=Email;
    }
    public void setPhoneNumber(String PhoneNumber)
    {
        if(!PhoneNumber.isEmpty()&&PhoneNumber.matches("[0-9]+"))
        this.PhoneNumber = PhoneNumber;
    }
    public void setPassword(String password)
    {
        if(!password.isEmpty()&&!password.matches("(0123456789|123456789|012345678)")&&password.length()>7)
        this.Password=password;
    }

    public void setID(int ID) {
        if(ID>0)
        this.ID = ID;
    }

    public void setUsername(String Username)
    {
        if(!Username.isEmpty())
        this.Username=Username;
    }
}
