package customers;

public class Grade {
    private String courseName;
    private String grade;
    //getters setters to string and constructor
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "courseName='" + courseName + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
    //constructor
    public Grade(String courseName, String grade) {
        this.courseName = courseName;
        this.grade = grade;
    }
    //default constructor
    public Grade() {
    }
}
