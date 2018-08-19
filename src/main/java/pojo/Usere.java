package pojo;

import java.io.Serializable;

public class Usere implements Serializable {
    private Integer uwerId;
    private String userName;
    private String userpwd;

    public Usere() {
    }


    public Usere(Integer uwerId, String userName, String userpwd) {

        this.uwerId = uwerId;
        this.userName = userName;
        this.userpwd = userpwd;
    }

    public Integer getUwerId() {

        return uwerId;
    }

    public void setUwerId(Integer uwerId) {
        this.uwerId = uwerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
}
