/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Duqiuyu
 * Date: 2020-03-20
 * Time: 21:57
 */
class Text{
    public String name;
    public int age;
    public int number;
    public void show(){
        System.out.println("姓名："+name+" 年龄："+age +" 学号："+number);
    }

    //============================================================

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //=========================================================

    Text(){
    }
    Text(String name,int age,int number){
        this.name = name;
        this.age = age;
        this.number = number;
        System.out.println("姓名："+name+" 年龄："+age +" 学号："+number);
    }


}

public class Homework {
    public static void main(String[] args) {
        //第一种赋值方法
        Text p1 = new Text();
        p1.name = "cathy";
        p1.age = 10;
        p1.number = 20180406;
        p1.show();

        //第二种赋值方法
        Text p2 = new Text();
        p2.setName("dongdong");
        System.out.println(p2.getName());
        p2.setAge(20);
        System.out.println(p2.getAge());
        p2.setNumber(20180304);
        System.out.println(p2.getNumber());

        //第三种赋值方法
        Text p3 = new Text("bobi",50,20180302);
    }
}
