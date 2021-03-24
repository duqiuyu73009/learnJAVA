package Test0324;

//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.
// 则经过替换之后的字符串为We%20Are%20Happy。

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TestDemo0314_1 {
    public static String replaceSpace (String s) {
        return  s.replaceAll("\\s+", "%20");
    }
}
