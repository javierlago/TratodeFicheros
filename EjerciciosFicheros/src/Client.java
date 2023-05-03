public class Client {
    int Id;
    String Name;
    double Account;

    public Client(int id, String name, double account) {
        Id = id;
        Name = name;
        Account = account;
    }

    public Client() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getAccount() {
        return Account;
    }

    public void setAccount(double account) {
        Account = account;
    }

    public void show() {
        System.out.println(Id+" "+Name+" "+Account);
    }
}
