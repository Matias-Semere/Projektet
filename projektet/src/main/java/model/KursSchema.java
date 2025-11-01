package model;

public class KursSchema extends BaseModel {
    private int kurstillfälleId;
    private String datum;
    private String starttid;
    private String sluttid;
    private String lokal;

    public KursSchema(int kurstillfälleId, String datum, String starttid, String sluttid, String lokal) {
        this.kurstillfälleId = kurstillfälleId;
        this.datum = datum;
        this.starttid = starttid;
        this.sluttid = sluttid;
        this.lokal = lokal;
    }

    public int getKurstillfälleId() { return kurstillfälleId; }
    public void setKurstillfälleId(int kurstillfälleId) { this.kurstillfälleId = kurstillfälleId; }

    public String getDatum() { return datum; }
    public void setDatum(String datum) { this.datum = datum; }

    public String getStarttid() { return starttid; }
    public void setStarttid(String starttid) { this.starttid = starttid; }

    public String getSluttid() { return sluttid; }
    public void setSluttid(String sluttid) { this.sluttid = sluttid; }

    public String getLokal() { return lokal; }
    public void setLokal(String lokal) { this.lokal = lokal; }

    @Override
    public String toString() {
        return String.format("SchemaID: %d, KurstillfälleID: %d, Datum: %s, %s-%s, Lokal: %s",
            id, kurstillfälleId, datum, starttid, sluttid, lokal);
    }
}
