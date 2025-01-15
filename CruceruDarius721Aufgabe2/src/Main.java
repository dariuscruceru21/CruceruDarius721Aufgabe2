import Controller.Controller;
import Model.Charktere;
import Model.Produkt;
import Repository.IRepository;
import Repository.Repository;
import View.View;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Repository<Produkt>produktIRepository = new Repository();
        Repository<Charktere>charktereIRepository = new Repository();
        Controller controller = new Controller(produktIRepository,charktereIRepository);
        View view = new View(controller);
        view.start();
    }
}