package day1114;

class Shape {
    public void draw() {

    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("□");
        }
}
class Flower extends Shape {
    @Override
    public void draw() {
        System.out.println("♣");
    }
}

public class TestDemo1114_1 {
    public static void main(String[] args) {
        Shape shape1 = new Flower();
        Shape shape2 = new Cycle();
        Shape shape3 = new Rect();
        drawShape(shape1);
        drawShape(shape2);
        drawShape(shape3);
    }

    // 打印单个图形
    public static void drawShape(Shape shape) {
        shape.draw();
    }
}

