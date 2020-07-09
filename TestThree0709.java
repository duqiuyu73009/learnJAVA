package day_34;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 坏键问题
 */

public class TestThree0709 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String right = scanner.nextLine();
        String wrong = scanner.nextLine();
        Set<Character> set = new TreeSet<>();
        for (char c : wrong.toCharArray()){
            set.add(c);
        }

        Set<Character> write = new TreeSet<>();
        for (char c : right.toCharArray()) {
            if (!set.contains(c)) {
                c = Character.toUpperCase(c);
                if (!write.contains(c)){
                    System.out.println(c);
                    write.add(c);
                }
            }
        }
        System.out.println();
    }
}
