package day_42;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestOne0720 {
    /**
     * 输入某年某月某日，判断这一天是这一年的第几天？
     */
    /*
    分析：这道例题显然用到了Date类和Calender类
         * 用户输入的日期是一个字符串，要通过SimpleDateFormat类的parse()方法来将这个字符串格式化为日期对象
         * 使用Date类的getTime()方法来将日期对象转换成毫秒值
         * 得使用一个字符串的拼接得到当年的一月一日日期对象
         * 用客户输入的日期毫秒值减去当年一月一日的毫秒值，再除以60再除以60再除以24即可得到具体过了多少天
     */
    public static void main(String[] args) {
        // 定一个SimpleDateFormat的格式化规则
        SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd");
        // 获取用户的输入
        Scanner sc = new Scanner(System.in);
        String day = sc.next();
        // 对用户输入的字符串进行解析，解析为一个Date对象
        Date date=null;
        try {
            date = sd.parse(day);
        } catch (ParseException e) {
            System.out.println("您输入的日期格式不对，请输入正确的日期格式，为：(yyyy.MM.dd)");
        }
        // 获取用户输入的年数,并在后面拼接上一月一日
        String year = day.split("\\.")[0];
        year = year+".01.01";
        // 对一月一日也进行解析，解析为一个Date对象
        Date date01 = null;
        try {
            date01 = sd.parse(year);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 把获取到的两个date对象转换成毫秒值
        long date_input = date.getTime();
        long date_orign = date01.getTime();
        // 计算毫秒值差并转换成天数
        long distance = date_input-date_orign;
        // 为啥要加个1嘞，是因为一月一号是第一天啊，前面的算法是把这一天当第0天算的
        long checkedday = (distance/1000/60/60/24)+1;
        System.out.println("您输入的这一天是今年的第"+checkedday+"天。");
    }
}