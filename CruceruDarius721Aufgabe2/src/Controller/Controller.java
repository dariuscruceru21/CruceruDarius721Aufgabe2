package Controller;

import Model.Charktere;
import Model.Produkt;
import Repository.IRepository;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private IRepository<Produkt> produktIRepository;
    private IRepository<Charktere>charktereIRepository;

    /**
     * Constructs a Controller with the given Film and Client repositories.
     *
     * @param produktIRepository the repository for Produkt entities
     * @param charktereIRepository the repository for Charaktere entities
     */
    public Controller(IRepository<Produkt> produktIRepository, IRepository<Charktere> charktereIRepository) {
        this.produktIRepository = produktIRepository;
        this.charktereIRepository = charktereIRepository;
        initializeRepository();
    }

    /**
     * Initializes the repository with predefined Film and Client data.
     */
    public void initializeRepository() {


        Produkt produkt1 = new Produkt(1,"Wasser",2.0,"Fiji");
        Produkt produkt2 = new Produkt(2,"Cola",3.0,"America");
        Produkt produkt3 = new Produkt(3,"Sprite",4.0,"Romania");

        produktIRepository.create(produkt1);
        produktIRepository.create(produkt2);
        produktIRepository.create(produkt3);



        Charktere charktere1 = new Charktere(1,"Iron Man","America");
        Charktere charktere2 = new Charktere(2,"Batman","Gotham");
        Charktere charktere3 = new Charktere(3,"SuperMan","Detroit");

        charktereIRepository.create(charktere1);
        charktereIRepository.create(charktere2);
        charktereIRepository.create(charktere3);


        addProduktToCharaket(1, 2);
        addProduktToCharaket(1, 3);
        addProduktToCharaket(4, 1);
        addProduktToCharaket(2, 3);
    }


    /**
     * Adds a Film to a Client's list of films.
     *
     * @param produktId  the ID of the Produkt
     * @param charketrId the ID of the Charakter
     */
    public void addProduktToCharaket(Integer produktId, Integer charketrId) {
        Charktere charktere = charktereIRepository.get(charketrId);
        Produkt produkt = produktIRepository.get(produktId);
        charktere.getErwobeneProdukte().add(produkt);
    }


    public void addProdukt(Produkt produkt) {
        produktIRepository.create(produkt);
    }

    public void addCharakter(Charktere charktere) {
        charktereIRepository.create(charktere);
    }

    public void update(Produkt produkt) {
        produktIRepository.update(produkt);
    }

    public void uodate(Charktere charktere) {
        charktereIRepository.update(charktere);
    }

    public void removeProdukt(Integer produktId) {
        produktIRepository.delete(produktId);
    }

    public void removeCharakter(Integer charktereId) {
        charktereIRepository.delete(charktereId);
    }

    public Produkt getProduktById(Integer produktId) {
        return produktIRepository.get(produktId);
    }

    public Charktere getCharktereById(Integer charktereId) {
        return charktereIRepository.get(charktereId);
    }

    public List<Produkt>getAllProdukts() {
        return produktIRepository.getAll();
    }

    public List<Charktere>getAllCharkteres() {
        return charktereIRepository.getAll();
    }


    public List<Charktere>charaktereVonHerkunfstOrt(String herkunsftOrt){
        return getAllCharkteres().stream().filter(charakter->charakter.getHerkunftsOrt().equals(herkunsftOrt)).collect(Collectors.toList());
    }

    public List<Charktere>charaktereDieEinenProduktVonRegionGekauft(String region){
        return getAllCharkteres().stream()
                .filter(charktere -> charktere.getErwobeneProdukte().stream()
                        .anyMatch(produkt -> produkt.getHerkunftRegion().equals(region)))
                .collect(Collectors.toList());
    }


}
