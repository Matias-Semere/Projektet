package model;

public class Student {
    private int studentId;
    private int userId;        // Add this field
    private String name;
    private int yearGroup;

    public Student(int studentId, int userId, String name, int yearGroup) {
        this.studentId = studentId;
        this.userId = userId;
        this.name = name;
        this.yearGroup = yearGroup;
    }

    public int getStudentId() { return studentId; }
    public int getUserId() { return userId; }      // Add this getter
    public String getName() { return name; }
    public int getYearGroup() { return yearGroup; }

    public void setStudentId(int studentId) {
        if (studentId >= 0) {
            this.studentId = studentId;
        }
    }
    
    public void setUserId(int userId) {           // Add this setter
        if (userId >= 0) {
            this.userId = userId;
        }
    }
    
    public void setName(String name) { 
        if(name != null && !name.trim().isEmpty()) this.name = name; 
    }
    
    public void setYearGroup(int yearGroup) {
        if(yearGroup > 0) {
            this.yearGroup = yearGroup; 
        }
    }

    @Override
    public String toString() {
        return String.format("StudentID: %d, UserID: %d, Name: %s, Year: %d",
                studentId, userId, name, yearGroup);
    }
}