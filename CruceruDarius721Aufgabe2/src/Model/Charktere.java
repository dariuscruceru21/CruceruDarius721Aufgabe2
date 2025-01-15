package Model;

import java.util.ArrayList;
import java.util.List;

public class Charktere implements HasId{
    private int id;
    private String name;
    private String herkunftsOrt;
    private List<Produkt> erwobeneProdukte;

    public Charktere(int id, String name, String herkunftsOrt) {
        this.id = id;
        this.name = name;
        this.herkunftsOrt = herkunftsOrt;
        this.erwobeneProdukte = new ArrayList<>();
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHerkunftsOrt() {
        return herkunftsOrt;
    }

    public void setHerkunftsOrt(String herkunftsOrt) {
        this.herkunftsOrt = herkunftsOrt;
    }

    public List<Produkt> getErwobeneProdukte() {
        return erwobeneProdukte;
    }

    public void setErwobeneProdukte(List<Produkt> erwobeneProdukte) {
        this.erwobeneProdukte = erwobeneProdukte;
    }

    @Override
    public String toString() {
        return "Charktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", herkunftsOrt='" + herkunftsOrt + '\'' +
                ", erwobeneProdukte=" + erwobeneProdukte +
                '}';
    }
}


