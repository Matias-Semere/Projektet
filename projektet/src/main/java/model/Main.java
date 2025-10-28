package model;

public class Main {
    public static void main(String[] args) {
        Betyg b = new Betyg(14, 1, Betyg.Grades.A);
        b.setGrade(Betyg.Grades.VG);

        System.out.println(b.getGrade());

    }
}
