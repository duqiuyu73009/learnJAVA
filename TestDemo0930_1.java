package day_0930;

import javax.swing.*;

/**
 * switch的用法
 *
 * 月份判断春夏秋冬
 *
 */
public class TestDemo0930_1 {
    public static void main(String[] args) {
        //用户输入一个月份值
        int m = 0;
        m = Integer.parseInt(JOptionPane.showInputDialog("请输入一个月份值","1"));
        //把月份转换成整形赋值给m
        String str = "";
        str = MonthToQuarter(m);
        JOptionPane.showMessageDialog(null,str);
    }

    public static String MonthToQuarter(int n){
        String result = "";
        switch (n){
            case 2:
            case 3:
            case 4:
                result = "春季";
                break;
            case 5:
            case 6:
            case 7:
                result = "夏季";
                break;
            case 8:
            case 9:
            case 10:
                result = "秋季";
                break;
            default:
                result = "冬季";
        }
        return result;
    }
}
