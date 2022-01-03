import java.util.HashMap;
import java.util.Set;

public class Calculations {
    public void chooseDiscount(HashMap<String, Integer> purchases, HashMap<String, Integer> promoCodes, HashMap<String, Integer> calculationByPromo) {
        String STR_PROMO = "ПРОМО";
        int sumByCategory = 0;
        int sumPromo = 0;
        int discount;
        int sum;
        Set<HashMap.Entry<String, Integer>> set = promoCodes.entrySet();
        Set<HashMap.Entry<String, Integer>> sets = purchases.entrySet();
        Set<HashMap.Entry<String, Integer>> prom = calculationByPromo.entrySet();
        discount = promoCodes.get(STR_PROMO);

        for (HashMap.Entry<String, Integer> hm : sets) {
            Integer value = purchases.get(hm.getKey()) - (discount * purchases.get(hm.getKey()) / 100);
            calculationByPromo.put(hm.getKey(), value);
        }
        for (HashMap.Entry<String, Integer> hm : set) {
            purchases.computeIfPresent(hm.getKey(), (key, value) -> value = purchases.get(hm.getKey()) - (promoCodes.get(hm.getKey()) * purchases.get(hm.getKey()) / 100));
        }

        for (HashMap.Entry<String, Integer> hm : sets) {
            sumByCategory += hm.getValue();
        }
        for (HashMap.Entry<String, Integer> hm : prom) {
            sumPromo += hm.getValue();
        }
        sum = Math.min(sumByCategory, sumPromo);
        System.out.println("Наиболее выгодный вариант:");
        System.out.println(sum);
    }
}
