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




    public String getHerkunftsOrt() {
        return herkunftsOrt;
    }



    public List<Produkt> getErwobeneProdukte() {
        return erwobeneProdukte;
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


