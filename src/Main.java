import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        InitializedList initializedList = new InitializedList();
        initializedList.listInitialization(list);
        HashMap<String, Integer> purchases = new HashMap<>();
        HashMap<String, Integer> promoCodes = new HashMap<>();
        FillingHashTable fillingHashTable = new FillingHashTable();
        fillingHashTable.fillInTable(list, purchases, promoCodes);
        Calculations calculations = new Calculations();
        calculations.chooseDiscount(purchases, promoCodes);
    }
}

