package model;

public class Main {
    public static void main(String[] args) {
        Betyg b = new Betyg();

        b.sättBetygPåKurs(Betyg.KursBetyg.B);
        b.sättBetygPåMoment(Betyg.MomentBetyg.VG);

        System.out.println(b);
    }
}
