package ink.lsq.db.demo;

public class User {

    private String userId;

    public User(String userId) {
        this.userId = userId;
    }

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
