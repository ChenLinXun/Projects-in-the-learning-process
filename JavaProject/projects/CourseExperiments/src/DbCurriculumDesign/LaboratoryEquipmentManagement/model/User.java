package DbCurriculumDesign.LaboratoryEquipmentManagement.model;



//这是一个用户账户的javaBean
public class User {
    private int id;
    private String userName;
    private String password;


    public User() {}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    //get和set方法是给反射使用的

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
