package day21_2_8;

//反射

import java.lang.reflect.*;

class Cat{
    private String name;

    public Cat(){
        this.name = "小猫";
    }

    public Cat(String name) {
        this.name = name;
    }

    public void eat(String food){
        System.out.println(this.name + "正在吃" + food);
    }
}

public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //1.如何获取类对象-----------------------------------------------------------------------
        //a)通过字符串获取到类,参数是类的全限定类名
        //最重要
        //Class catClass = Class.forName("day21_2_8.Cat");
        //catClass  这就是Cat类的图纸，里面描述了Cat类的内部构造

        //b)通过实例来获取
        //Cat cat = new Cat("小黑");
        //Class catClass2 = cat.getClass();

        //System.out.println(catClass == catClass2);//true

        //c)通过类来获取
        //Class catClass3 = Cat.class;
        //System.out.println(catClass == catClass3);//true


        //2.通过类对象来创建实例----------------------------------------------------------------
//        Class catClass = Class.forName("day21_2_8.Cat");
//        Cat cat = (Cat)catClass.newInstance();//创建一个cat类型的对象
//        cat.eat("🐟");

//       //3.通过反射获取/修改属性（可以修改private）---------------------------------------------
//        Class catClass = Class.forName("day21_2_8.Cat");
//        //Cat 类中包含name属性，private的属性
//        //catClass 类对象是整个类的图纸
//        Field field = catClass.getDeclaredField("name");
//        //通过 getDeclaredField 能得到局部内容，通过 Field 对象来表示
//
//        //这一行代码加上之后才能访问private
//        field.setAccessible(true);
//
//        Cat cat = new Cat();
//        //拿着图纸中的局部信息，拆开cat对象，看看里面是什么
//        field.get(cat);
//
//        //除了获取属性之外，还可以根据名字来修改属性
//        field.set(cat,"花花");
//
//        String name = (String)field.get(cat);//这个代码相当于 cat.name
//        System.out.println(name);

        //4.通过反射获取到类中的方法------------------------------------------------------------
//        Class catClass = Class.forName("day21_2_8.Cat");
//        //根据catClass这个图纸，找到Cat类中的eat方法
//        //方法是可以重载的 ，就可以通过后续的变长参数列表来指定，要获取哪一个版本的eat
//        //下面代码的意思是获取到只有一个参数且类型为String的eat方法
//        Method method = catClass.getMethod("eat",String.class);
//
//        Cat cat = new Cat();
//        method.invoke(cat,"猫粮");


        //5.获取构造方法，借助构造方法来实例化对象------------------------------------------------
        Class catClass = Class.forName("day21_2_8.Cat");
        //获取到Cat类中，只有一个参数且类型为String的构造方法
        Constructor constructor = catClass.getConstructor(String.class);
        Cat cat = (Cat) constructor.newInstance("小黑");
        cat.eat("鱼");
    }
}
