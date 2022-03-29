public class Record {
    private Double prijs;
    private String label;

    public Record(String label, Double prijs) {
        this.label = label;
        this.prijs = prijs;
    }

    public Double getPrijs() {
        return prijs;
    }

    public String getLabel() {
        return label;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
