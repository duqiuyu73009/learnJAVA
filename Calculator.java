/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-03-21
 * Time: 17:24
 */
class Cal{
    private double num1;
    private double num2;
    public Cal(){
    }
    public Cal(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    public double add(){
        return this.num1+this.num2;
    }
    public double sab(){
        return this.num1-this.num2;
    }
    public double mul(){
        return this.num1*this.num2;
    }
    public double dev(){
        return this.num1/this.num2;
    }
}
public class Calculator {
    public static void main(String[] args) {
        Cal cal = new Cal(3,5);
        System.out.println(cal.add());
        System.out.println(cal.sab());
        System.out.println(cal.mul());
        System.out.println(cal.dev());
    }
}
