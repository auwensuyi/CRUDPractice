public class SchoolDirectory {

    private int capacity;
    private int size;
    School[] directory;

    public SchoolDirectory(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        directory = new School[capacity];

    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //TODO -- Create
    public void addTeacher(String teacherName, int homeRoom, String subject) {
        if (!isFull()) {
            directory[size] = new School(teacherName, homeRoom, subject);
            size++;
        }

    }

    //TODO -- Read
    public School searchTeacher(String teacherName) {
        if(!isEmpty()) {
            for( int i = 0; i < size; i++) {
                if (directory[i].getTeacherName().equalsIgnoreCase(teacherName)) {
                    return directory[i];
                }
            }
        }

        return null;
    }

    //TODO -- Update
    public School updateSubject(String teacherName, String subject) {
        School subjectUpdated = searchTeacher(teacherName);
        if(subjectUpdated != null) {
            subjectUpdated.setSubject(subject);
        }

        return subjectUpdated;

    }

    //TODO -- Delete
    public boolean deleteTeacher(String teacherName) {
        boolean deleted = false;
        if(!isEmpty()) {
            School[] newDirectory = new School[capacity];
            int j = 0;
            for (int i = 0; i < size - 1; i++) {
                if (directory[i].getTeacherName().equalsIgnoreCase(teacherName)) {
                    j = i + 1;
                    deleted = true;
                }
                newDirectory[i] = directory[j++];

            }
            size--;
            directory = newDirectory;
        }
        return deleted;
    }

    public void print() {
        if(!isEmpty()) {
            for (int i = 0; i < size; i++) {
                System.out.println(directory[i]);
            }

        }
    }


    //TODO -- Testing

    public static void main(String[] args) {
        SchoolDirectory Dir = new SchoolDirectory(4);
        School Teacher1 = new School("Alan Smith", 300, "Mathematics");
        School Teacher2 = new School("John Doe", 301, "History");
        School Teacher3 = new School("Jane Doe", 302, "Science");
        School Teacher4 = new School("Mary Jones", 303, "Physical Education");
        School Teacher5 = new School("George Smith", 304, "English");

        //Adding Teachers
        Dir.addTeacher("Alan Smith", 300, "Mathematics");
        Dir.addTeacher("John Doe", 301, "History");
        Dir.addTeacher("Jane Doe", 302, "Science");
        Dir.addTeacher("Mary Jones", 303, "Physical Education");
        Dir.addTeacher("George Smith", 304, "English");
        Dir.print();

        //Search Teachers
        School searchedTeacher = Dir.searchTeacher("Alan Smith");
        if(searchedTeacher != null){
            System.out.println(searchedTeacher.getHomeRoom());
        }else{
            System.out.println("Teacher does not exist");
        }
        //System.out.println(Dir.searchTeacher("Alan Smith"));

        //Update Teacher
        //System.out.println(Dir.searchTeacher("Alan Smith"));
        //Dir.updateSubject("Alan Smith", "computer science");
        //System.out.println(Dir.searchTeacher("Alan Smith"));

        //Delete Teacher
        System.out.println("Teacher Directory before deletion");
        Dir.print();
        Dir.deleteTeacher("Mary Jones");
        System.out.println("Teacher Directory after deletion");
        Dir.print();
        Dir.addTeacher("Mary Jones", 303, "Physical Education");
        System.out.println();
        Dir.print();

    }

}
