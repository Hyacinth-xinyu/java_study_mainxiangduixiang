public class User {
    private int userId;
    private String loginName;
    private String password;
    private String userName;
    private String email;
    private boolean isAdmin;

    //   构造函数
    public User(int useId, String loginName, String password, String userName, String email) {
        this.userId = useId;
        this.loginName = loginName;
        this.password = password;
        this.userName = userName;
        this.email = email;

    }

    // set方法
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    // get方法
    public int getUserId() {
        return userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    // equals方法和toString方法
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "useId=" + userId +
                ", loginName='" + loginName + '\'' +
                ", Password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }


}
