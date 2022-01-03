import java.util.HashMap;
import java.util.Set;

public class Сalculations {

    public static void ChooseDiscount( HashMap<String, Integer> purchases, HashMap<String, Integer> promoСodes) {
        String strpromo = "промо";
        int discountByCategory = 0;
        int discount;
        int sum = 0;
        Set<HashMap.Entry<String, Integer>> set = promoСodes.entrySet();
        Set<HashMap.Entry<String, Integer>> sets = purchases.entrySet();
        for (HashMap.Entry<String, Integer> hm : set) {
            if (purchases.containsKey(hm.getKey())) {
                discountByCategory += promoСodes.get(hm.getKey());
            }
        }
        discount = promoСodes.get(strpromo);

        if (discountByCategory > discount) {
            for (HashMap.Entry<String, Integer> hm : set) {
                purchases.computeIfPresent(hm.getKey(), (key, value) -> value = purchases.get(hm.getKey()) - (promoСodes.get(hm.getKey()) * purchases.get(hm.getKey()) / 100));
            }
        }
        else {
            for (HashMap.Entry<String, Integer> hm : sets) {
                int finalDiscount = discount;
                purchases.computeIfPresent(hm.getKey(), (key, value) -> value = purchases.get(hm.getKey()) - (finalDiscount * purchases.get(hm.getKey()) / 100));
            }
        }
        for (HashMap.Entry<String, Integer> hm : sets) {
            sum+=hm.getValue();
        }
        System.out.println("Наиболее выгодный вариант:");
        System.out.println(sum);
    }
}
