package Model;

public class Produkt implements HasId {
    private Integer idProdukt;
    private String name;
    private Double preis;
    private String herkunftRegion;

    public Produkt(Integer idProdukt, String name, Double preis, String herkunftRegion) {
        this.idProdukt = idProdukt;
        this.name = name;
        this.preis = preis;
        this.herkunftRegion = herkunftRegion;
    }

    @Override
    public Integer getId() {
        return this.idProdukt;
    }

    @Override
    public void setId(Integer id) {
        this.idProdukt = id;
    }


    public Double getPreis() {
        return preis;
    }



    public String getHerkunftRegion() {
        return herkunftRegion;
    }



    @Override
    public String toString() {
        return "Produkt{" +
                "idProdukt=" + idProdukt +
                ", name='" + name + '\'' +
                ", preis=" + preis +
                ", herkunftRegion='" + herkunftRegion + '\'' +
                '}';
    }
}
