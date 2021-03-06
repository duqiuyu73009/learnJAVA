import java.util.Arrays;
import java.util.Scanner;

public class TestDemo0306_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int[] disk = new int[p];
            for (int i = 0; i < p; i++) {
                disk[i] = scanner.nextInt();
            }
            //升序
            Arrays.sort(disk);

        }
    }
}