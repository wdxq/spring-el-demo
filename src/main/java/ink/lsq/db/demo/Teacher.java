package ink.lsq.db.demo;

public class Teacher {

    private String teacherId;

    public Teacher(String teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher() {
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }
}
