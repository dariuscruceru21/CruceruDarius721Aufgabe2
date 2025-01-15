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


        addProduktToCharaket(1, produkt2);
        addProduktToCharaket(1, produkt3);
        addProduktToCharaket(4, produkt1);
        addProduktToCharaket(2, produkt3);
    }


    /**
     * Adds a Film to a Client's list of films.
     *
     * @param charaktertId  the ID of the Produkt
     * @param produkt the ID of the Charakter
     */
    public void addProduktToCharaket(Integer charaktertId, Produkt produkt) {
        Charktere charktere = charktereIRepository.get(charaktertId);
        if(charktere != null) {
            charktere.getErwobeneProdukte().add(produkt);
            charktereIRepository.update(charktere);
        }

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


    public List<Produkt>sortCharaktereProdukte(Integer charakterId, boolean ascending){
        Charktere charaktere = charktereIRepository.get(charakterId);
        if(charaktere==null){
            return List.of();
        }
        return charaktere.getErwobeneProdukte().stream().sorted((p1,p2)->ascending ?
                p1.getPreis().compareTo(p2.getPreis()):
                p2.getPreis().compareTo(p2.getPreis())).collect(Collectors.toList());
    }
}
