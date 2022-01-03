import java.util.ArrayList;
import java.util.Scanner;

public class InitializedList {
    public static void listInitialization(ArrayList<String> list) {
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        while (flag == false) {
            list.add(scanner.nextLine());
            flag = list.contains("счет");
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
