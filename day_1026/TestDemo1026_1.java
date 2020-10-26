package day_1026;

class Date{
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    //判断是否为闰年
    public boolean IsLeapYear(){
        if ((this.year % 400 == 0) || ((this.year % 4 == 0)&&(this.year % 100 != 0))){
            return true;
        }else {
           return false;
        }
    }

    public void printInfo(){
        System.out.println(year + "年"+month + "月"+ day + "日");
    }


}

public class TestDemo1026_1 {
    public static void main(String[] args) {
        Date date = new Date(2020,10,26);
//        date.year = 2020;
//        date.month = 10;
//        date.day = 26;
        System.out.println(date.IsLeapYear());
        date.printInfo();

    }
}
