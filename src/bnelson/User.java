package bnelson;

public class User {

    private String password;
    private String salt;
    private String hash;

    public User(String sPassword) {
        password = sPassword;
    }

    public String getPassword() {
        return password;
    }

    public String getSalt() {
        return salt;
    }

    public String getHashedPassword() {
        return hash;
    }

    public void setPassword(String newVal) {
        password = newVal;
    }

    public void setSalt(String newVal) {
        salt = newVal;
    }

    public void setHashedPassword(String newVal) {
        hash = newVal;
    }

}