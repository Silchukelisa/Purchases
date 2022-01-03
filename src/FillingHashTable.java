import java.util.ArrayList;
import java.util.HashMap;

public class FillingHashTable {

    public static int getPrice(int price) {
        return price;
    }

    public static int getPrice(Integer value, int price) {
        if (price > value) {
            return price;
        } else {
            return value;
        }
    }

    public static void fillInTable(ArrayList<String> list, HashMap<String, Integer> purchases, HashMap<String, Integer> promoСodes) {
        String category;
        int price;
        String promo;
        String strpromo = "промо";
        Check check = new Check();
        System.out.println("\n");
        for (int i = 0; i < list.size() - 1; i++) {
            String[] purchase = list.get(i).split(" ");
            category = purchase[0];
            check.check(purchase, category);

            if (!(category.equals(strpromo))) {
                check.check(purchase);
                price = Integer.parseInt(purchase[1]);
                int finalPrice = price;
                purchases.computeIfPresent(category, (key, value) -> value += finalPrice);
                purchases.computeIfAbsent(category, value -> getPrice(finalPrice));
            }
            if (purchase.length == 3 && category.equals(strpromo)) {
                category = purchase[1];
                price = Integer.parseInt(purchase[2]);
                int finalPrice = price;
                promoСodes.computeIfPresent(category, (key, value) -> value = getPrice(value, finalPrice));
                promoСodes.computeIfAbsent(category, value -> getPrice(finalPrice));
            }
            if (purchase.length == 2 && category.equals(strpromo)) {
                check.check(purchase);
                promo = purchase[0];
                price = Integer.parseInt(purchase[1]);
                int finalPrice = price;
                promoСodes.computeIfPresent(promo, (key, value) -> value = getPrice(value, finalPrice));
                promoСodes.computeIfAbsent(category, value -> getPrice(finalPrice));
            }
        }
    }
}

