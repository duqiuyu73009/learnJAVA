package day_1025;

import java.util.Random;

//各类网页上面的动态生成的验证码，有纯粹数字的，有字母数字混合的，
// 有大小写字母和数字混合的，它们究竟是怎么产生的？请研究其中的奥秘，
// 设计函数，实现动态验证码的生成和显示。
public class TestDemo1025_11 {
    public static String word() {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 8; i++){
            //随机生成8位验证码
            int key = random.nextInt(3);//有大写字母、小写字母、数字三种情况
            switch (key){
                case 0:
                    //情况0：0-9的整数
                    int code1 = random.nextInt(10);
                    str += code1;
                    break;
                case 1:
                    //情况1：26个大写字母
                    char code2 = (char)(random.nextInt(26)+65);
                    str += code2;
                    break;
                case 2:
                    //情况2：26个小写字母
                    char code3 = (char)(random.nextInt(26)+97);
                    str += code3;
                    break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println("随机验证码为："+word());
    }
}
