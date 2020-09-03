package bjk.learn.java.barancev.dataObjects;

public class userDataBuilder {
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

  public userDataBuilder() {

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

  public userDataBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public userDataBuilder setPassword(String password) {
    this.password = password;
    return this;
  }

  public userDataBuilder setFirst(String first) {
    this.first = first;
    return this;
  }

  public userDataBuilder setLast(String last) {
    this.last = last;
    return this;
  }

  public userDataBuilder setEmail(String email) {
    this.email = email;
    return this;
  }

  public userDataBuilder setPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public userDataBuilder setAddr1(String addr1) {
    this.addr1 = addr1;
    return this;
  }

  public userDataBuilder setAddr2(String addr2) {
    this.addr2 = addr2;
    return this;
  }

  public userDataBuilder setCity(String city) {
    this.city = city;
    return this;
  }

  public userDataBuilder setState(String state) {
    this.state = state;
    return this;
  }

  public userDataBuilder setZip(String zip) {
    this.zip = zip;
    return this;
  }

  public userDataBuilder setCountry(String country) {
    this.country = country;
    return this;
  }

  public UserData createUserData() {
    return new UserData(name, password, first, last, email, phone, addr1, addr2, city, state, zip, country);
  }
}