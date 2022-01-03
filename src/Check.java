public class Check {
        public static void check(String[] purchase, String category) {
            if (category.equals("промо") && purchase.length == 1) {
                throw new IllegalArgumentException("Отсутствует размер скидки");
            }
            if (!(category.equals("промо")) && purchase.length == 1) {
                throw new IllegalArgumentException("Отсутствует цена покупки");
            }
        }

        public static void check(String[] purchase) {
            try {
                Integer.parseInt(purchase[1]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Отсутствует размер скидки");
            }
        }
    }

