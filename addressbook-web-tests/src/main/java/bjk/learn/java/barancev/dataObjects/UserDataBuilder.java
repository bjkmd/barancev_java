package bjk.learn.java.barancev.dataObjects;

public class UserDataBuilder {
  private String name;
  private String password;
  private String first;
  private String last;
  private String email;
  private String phone;
  private String addr1;
  private String addr2;
  private String city;
  private String state;
  private String zip;
  private String country;

  public UserDataBuilder() {
        this.name = "Name";
        this.password = "password";
        this.first = "First";
        this.last = "Last";
        this.email = "a@b.c";
        this.phone = "1234567";
        this.addr1 = "addr1";
        this.addr2 = "addr2";
        this.city = "City";
        this.state = "State";
        this.zip = "1212";
        this.country = "Country";
  }

  public UserDataBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public UserDataBuilder setPassword(String password) {
    this.password = password;
    return this;
  }

  public UserDataBuilder setFirst(String first) {
    this.first = first;
    return this;
  }

  public UserDataBuilder setLast(String last) {
    this.last = last;
    return this;
  }

  public UserDataBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public UserDataBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public UserDataBuilder setAddr1(String addr1) {
    this.addr1 = addr1;
    return this;
  }

  public UserDataBuilder setAddr2(String addr2) {
    this.addr2 = addr2;
    return this;
  }

  public UserDataBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public UserDataBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public UserDataBuilder setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public UserDataBuilder setCountry(String country) {
    this.country = country;
    return this;
  }

  public UserData createUserData() {
    return new UserData(name, password, first, last, email, phone, addr1, addr2, city, state, zip, country);
  }
}