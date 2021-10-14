public class CollegeStudent {
    public String name;
    public double gpa;
    public String year;

    public CollegeStudent(String name, double gpa, String year) {
        this.name = name;
        this.gpa = gpa;
        this.year = year;


    }

    public String getName() {
        return this.name;
    }

    public void setName() {
        this.name = name;

    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "CollegeStudent{" +
                "name='" + name + '\'' +
                ", gpa=" + gpa +
                ", year='" + year + '\'' +
                '}';
    }
}
