package model;

public class LärarTilldelning extends BaseModel {
    private int lärareId;
    private int kurstillfälleId;

    public LärarTilldelning(int lärareId, int kurstillfälleId) {
        this.lärareId = lärareId;
        this.kurstillfälleId = kurstillfälleId;
    }

    public int getLärareId() { return lärareId; }
    public void setLärareId(int lärareId) { this.lärareId = lärareId; }

    public int getKurstillfälleId() { return kurstillfälleId; }
    public void setKurstillfälleId(int kurstillfälleId) { this.kurstillfälleId = kurstillfälleId; }

    @Override
    public String toString() {
        return String.format("TilldelningID: %d, LärareID: %d, KurstillfälleID: %d",
            id, lärareId, kurstillfälleId);
    }
}
