import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        InitializedList initializedList = new InitializedList();
        initializedList.listInitialization(list);
        HashMap<String, Integer> purchases = new HashMap<>();
        HashMap<String, Integer> promoСodes = new HashMap<>();
        FillingHashTable fillingHashTable = new FillingHashTable();
        fillingHashTable.fillInTable(list, purchases, promoСodes);
        Сalculations сalculations = new Сalculations();
        сalculations.ChooseDiscount(purchases, promoСodes);
    }
}

