package View;

import Controller.Controller;
import Model.Charktere;
import Model.Produkt;

import java.util.List;
import java.util.Scanner;

public class View {
    private Scanner scanner;
    private Controller controller;

    public View(Controller controller) {
        this.scanner = new Scanner(System.in);
        this.controller = controller;
    }

    public void start(){
        boolean running = true;
        while(running){
            System.out.println("\n--- Choose an option ---");
            System.out.println("1. Charakter von KerkunsftOrt");
            System.out.println("2. Charakter der ein Produkt von ein Region gekauft hat");
            System.out.println("3. Sortieren VOn produkte einer Charakter in ascending order or not");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    filterCharakterByLocation();
                    break;
                case 2:
                    findenCharakterProduktRegion();
                    break;
                case 3:
                    sortCharakterProduct();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }


        }
    }

    private void filterCharakterByLocation(){
        System.out.println("Gibt ein Herkunft");
        String herkunft = scanner.nextLine();

        List<Charktere>filteredCharakeren = controller.charaktereVonHerkunfstOrt(herkunft);
        if(filteredCharakeren.isEmpty()){
            System.out.println("Charakter ist nicht gefunden aus Herkunft " + herkunft);
        }else {
            for (Charktere charktere : filteredCharakeren) {
                System.out.println(charktere);
            }
        }
    }

    private void findenCharakterProduktRegion(){
        System.out.println("Gibt ein Region");
        String region = scanner.nextLine();

        List<Charktere>gefundenCharaktere = controller.charaktereDieEinenProduktVonRegionGekauft(region);
        if(gefundenCharaktere.isEmpty()){
            System.out.println("Charakter gibt nicht au Region " + region);
        }else{
            for (Charktere charktere : gefundenCharaktere) {
                System.out.println(charktere);
            }
        }
    }

    private void sortCharakterProduct(){
        System.out.println("Gibt Charakter id");
        Integer charakterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Sortieren ascendin? (True/False");
        boolean ascending = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        List<Produkt>produkts = controller.sortCharaktereProdukte(charakterId, ascending);
        if (produkts.isEmpty()){
            System.out.println("Charakter ist nicht gefunden ");
        }else{
            for (Produkt produkt : produkts) {
                System.out.println(produkt);
            }
        }
    }
}
