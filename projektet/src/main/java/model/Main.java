package model;

public class Main {
    public static void main(String[] args) {

        // Betyg a = new KursBetyg(13, 12, KursBetyg.kBetyg.A);
        Betyg b = new MomentBetyg(13, 12, 123, MomentBetyg.mBetyg.VG);

        // System.out.println(a.getGrade());
        System.out.println(b.getGrade());

    }
}
