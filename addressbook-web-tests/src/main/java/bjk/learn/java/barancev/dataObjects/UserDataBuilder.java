package bjk.learn.java.barancev.dataObjects;

public class UserDataBuilder {
    private String name;
    private String password;

    public UserDataBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserDataBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserData createUserData() {
        return new UserData(name, password);
    }
}