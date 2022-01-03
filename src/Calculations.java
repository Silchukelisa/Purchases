import java.util.HashMap;
import java.util.Set;

public class Calculations {

    public void chooseDiscount( HashMap<String, Integer> purchases, HashMap<String, Integer> promoCodes) {
        String STR_PROMO = "ПРОМО";
        int discountByCategory = 0;
        int discount;
        int sum = 0;
        Set<HashMap.Entry<String, Integer>> set = promoCodes.entrySet();
        Set<HashMap.Entry<String, Integer>> sets = purchases.entrySet();
        for (HashMap.Entry<String, Integer> hm : set) {
            if (purchases.containsKey(hm.getKey())) {
                discountByCategory += promoCodes.get(hm.getKey());
            }
        }
        discount = promoCodes.get(STR_PROMO);

        if (discountByCategory > discount) {
            for (HashMap.Entry<String, Integer> hm : set) {
                purchases.computeIfPresent(hm.getKey(), (key, value) -> value = purchases.get(hm.getKey()) - (promoCodes.get(hm.getKey()) * purchases.get(hm.getKey()) / 100));
            }
        }
        else {
            for (HashMap.Entry<String, Integer> hm : sets) {
                purchases.computeIfPresent(hm.getKey(), (key, value) -> value = purchases.get(hm.getKey()) - (discount * purchases.get(hm.getKey()) / 100));
            }
        }
        for (HashMap.Entry<String, Integer> hm : sets) {
            sum+=hm.getValue();
        }
        System.out.println("Наиболее выгодный вариант:");
        System.out.println(sum);
    }
}
