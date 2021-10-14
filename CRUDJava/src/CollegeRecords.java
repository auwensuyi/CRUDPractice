public class CollegeRecords {
    int capacity;
    int size;
    CollegeStudent[] records;

    public CollegeRecords(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.records = new CollegeStudent[capacity];
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //TODO- CREATE
    public boolean addStudent(CollegeStudent newStudent) {
        boolean added = false;
        if (!isFull()) {
            records[size] = newStudent;
            size++;
            added = true;

        }
        return added;
    }


    //TODO- READ

    //TODO- UPDATE

    //TODO- DELETE







    public void printRecords() {
        System.out.println("*** College Records ***");
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                System.out.println(records[i] + "\n");
            }
            return;
        }
        System.out.println("Records Is Currently Empty");
    }

    public static void main(String[] args) {
        CollegeRecords studentRecords = new CollegeRecords(5);

    }
}
