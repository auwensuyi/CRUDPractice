public class School {

    private String teacherName;
    private int homeRoom;
    private String subject;

    public School () {
    }

    public School(String teacherName, int homeRoom, String subject) {
        this.teacherName = teacherName;
        this.homeRoom = homeRoom;
        this.subject = subject;


    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getHomeRoom() {
        return homeRoom;
    }

    public void setHomeRoom(int homeRoom) {
        this.homeRoom = homeRoom;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String toString() {
        return teacherName + " is in room " + homeRoom + " and teaches " + subject;
    }
}
