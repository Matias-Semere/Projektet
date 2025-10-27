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

    public int getStudentId() { return studentId; }
    public String getName() { return name; }
    public int getPersonalNumber() { return personalNumber; }
    public int getYearGroup() { return yearGroup; }

    public void setName(String name) { 
        if(name != null && name.length() > 1) this.name = name; 
    }

    public void setPersonalNumber(int personalNumber) {
        
         this.personalNumber = personalNumber; 
        }
    public void setYearGroup(int yearGroup) {
        if(yearGroup > 0 && yearGroup < 5) {
            this.yearGroup = yearGroup; 
        }
    }

    @Override
    public String toString() {
        return String.format("StudentID: %d, Name: %s, SSN: %d, Year: %d",
                studentId, name, personalNumber, yearGroup);
    }
}
