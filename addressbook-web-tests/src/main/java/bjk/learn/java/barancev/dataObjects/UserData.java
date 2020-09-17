package bjk.learn.java.barancev.dataObjects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("user")
public class UserData {
    private final String name;
    private final String password;
    private final String first;
    private final String last;
    private final String email;
    private final String phone;
    private final String addr1;
    private final String addr2;
    private final String city;
    private final String state;
    private final String zip;

    @Override
    public String toString() {
        return "UserData{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private final String country;

    public UserData(String name, String password,
                    String first,
                    String last,
                    String email,
                    String phone,
                    String addr1,
                    String addr2,
                    String city,
                    String state,
                    String zip,
                    String country){
        this.name = name;
        this.password = password;
        this.first = first;
        this.last = last;
        this.email = email;
        this.phone = phone;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddr1() {
        return addr1;
    }

    public String getAddr2() {
        return addr2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }
}
