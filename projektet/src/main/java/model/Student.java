package model;

public class Student {
    private int studentId;
    private String name;
    private int personalNumber;
    private int yearGroup;

    public Student(int studentId, String name, int personalNumber, int yearGroup) {
        this.studentId = studentId;
        this.name = name;
        this.personalNumber = personalNumber;
        this.yearGroup = yearGroup;
    }

    // Getters and setters
    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getPersonalNumber() { return personalNumber; }
    public int getYearGroup() { return yearGroup; }

    public void setName(String name) { this.name = name; }
    public void setPersonalNumber(int personalNumber) { this.personalNumber = personalNumber; }
    public void setYearGroup(int yearGroup) { this.yearGroup = yearGroup; }

    @Override
    public String toString() {
        return String.format("StudentID: %d, Name: %s, SSN: %d, Year: %d",
                studentId, name, personalNumber, yearGroup);
    }
}
