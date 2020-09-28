package day_0928;

import javax.swing.*;

/**
 * JOptionPane输出应用
 *
 * JOptionPane.showInputDialog
 * JOptionPane.showMessageDialog
 * JOptionPane.showConfirmDialog
 */
public class TestDemo0928_1 {
    public static void main(String[] args) {
        double a,b;
        String str1 = JOptionPane.showInputDialog("输入a的值","0");
        a = Integer.parseInt(str1);
        String str2 = JOptionPane.showInputDialog("输入运算符号","+");
        String str3 = JOptionPane.showInputDialog("输入b的值","0");
        b = Integer.parseInt(str3);
        double c = 0;
        if (str2.equals("+") ){
            c = a + b;
        }
        if (str2.equals("-")){
            //或者是str.contains("-")
            c = a - b;
        }
        if (str2.equals("*") ){
            c = a * b;
        }
        if (str2.equals("/") ){
            c = a / b;
        }
        JOptionPane.showMessageDialog(null, c);
    }

    public static void main1(String[] args) {
        int a,b;
        a = 100;
        b = 200;
        int c = a + b;
        //显示输入消息框，可以输入数据
        String str1 = JOptionPane.showInputDialog("输入消息框","0");
        //int n = JOptionPane.showConfirmDialog(null,"");


        //显示出一个弹框
        //null表示对话框显示在屏幕中间
        //第二个参数表示要显示的字符结果
        JOptionPane.showMessageDialog(null,str1);
        JOptionPane.showMessageDialog(null,"a + b =" + c);

    }
}
