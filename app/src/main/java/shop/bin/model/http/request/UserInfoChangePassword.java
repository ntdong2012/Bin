package shop.bin.model.http.request;

/**
 * Created by nguyenthanhdong0109@gmail.com on 5/31/17.
 */

public class UserInfoChangePassword {

    private String passwordNew;
    private String passwordNewConfirm;
    private String password;

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }

    public String getPasswordNewConfirm() {
        return passwordNewConfirm;
    }

    public void setPasswordNewConfirm(String passwordNewConfirm) {
        this.passwordNewConfirm = passwordNewConfirm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
