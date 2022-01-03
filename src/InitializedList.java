import java.util.ArrayList;
import java.util.Scanner;

public class InitializedList {
    public void listInitialization(ArrayList<String> list) {
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        while (!flag) {
            list.add(scanner.nextLine());
            flag = list.contains("СЧЕТ");
        }
        for (String s : list) {
            System.out.println(s);
        }
    }
}
