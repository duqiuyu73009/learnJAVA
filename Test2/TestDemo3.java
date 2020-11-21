package Test2;

class Paint {
    public String name;
    public int size;

    public void Paint() {
    }

    public Paint(String name) {
        this.name = name;
    }

    //重载一个构造方法
    public Paint(String name,int size) {
        this.name = name;
        this.size = size;
    }

}
class line extends Paint {
    public line(String name) {
        super(name);
    }

    @Override
    public void Paint() {
        System.out.println(this.name+"画了一条直线");
    }
}

class circle extends Paint {
    public circle(String name) {
        super(name);
    }

    @Override
    public void Paint() {
        System.out.println(this.name+"画了一个圆");
    }
}

class rectangle extends Paint {
    public rectangle(String name) {
        super(name);
    }

    @Override
    public void Paint() {
        System.out.println(this.name+"画了一个矩形");
    }
}

class shanX extends Paint {
    public shanX(String name) {
        super(name);
    }

    @Override
    public void Paint() {
        System.out.println(this.name+"画了一个扇形");
    }
}
public class TestDemo3 {
    public static void main(String[] args) {
        Paint paint = new shanX("小明");
        paint.Paint();
        Paint paint2 = new line("小丽");
        paint2.Paint();
        Paint paint3 = new circle("小花");
        paint3.Paint();
        Paint paint4 = new rectangle("小王");
        paint4.Paint();
    }
}