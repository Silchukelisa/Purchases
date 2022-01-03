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

    public void fillInTable(ArrayList<String> list, HashMap<String, Integer> purchases, HashMap<String, Integer> promoCodes) {
        String category;
        int price;
        String promo;
        String STR_PROMO = "ПРОМО";
        System.out.println("\n");
        for (int i = 0; i < list.size() - 1; i++) {
            String[] purchase = list.get(i).split(" ");
            category = purchase[0];
            Check.check(purchase, category);

            if (!(category.equals(STR_PROMO))) {
                Check.check(purchase);
                price = Integer.parseInt(purchase[1]);
                int finalPrice = price;
                purchases.computeIfPresent(category, (key, value) -> value += finalPrice);
                purchases.computeIfAbsent(category, value -> getPrice(finalPrice));
            }
            if (purchase.length == 3 && category.equals(STR_PROMO)) {
                category = purchase[1];
                price = Integer.parseInt(purchase[2]);
                int finalPrice = price;
                promoCodes.computeIfPresent(category, (key, value) -> value = getPrice(value, finalPrice));
                promoCodes.computeIfAbsent(category, value -> getPrice(finalPrice));
            }
            if (purchase.length == 2 && category.equals(STR_PROMO)) {
                Check.check(purchase);
                promo = purchase[0];
                price = Integer.parseInt(purchase[1]);
                int finalPrice = price;
                promoCodes.computeIfPresent(promo, (key, value) -> value = getPrice(value, finalPrice));
                promoCodes.computeIfAbsent(category, value -> getPrice(finalPrice));
            }
        }
    }
}

