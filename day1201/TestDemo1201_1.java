package day1201;

abstract class USB{
    public abstract void turnOn();
    public abstract void turnOff();
}

class mouse extends USB{
    @Override
    public void turnOn() {
        System.out.println("正在打开鼠标");
    }

    @Override
    public void turnOff() {
        System.out.println("正在关闭鼠标");
    }
}

class mic extends USB{
    @Override
    public void turnOn(){
        System.out.println("正在打开耳机");
    }

    @Override
    public void turnOff() {
        System.out.println("正在关闭耳机");
    }
}

class Computer{
    USB[] USBIEKOU = new USB[4];

    public void add(USB b){
        for (int i = 0; i < USBIEKOU.length; i++){
            if (USBIEKOU[i] == null){
                USBIEKOU[i] = b;
                break;
            }
        }
    }

    public void turnOn(){
        System.out.println("打开");
        for (int i = 0; i < USBIEKOU.length; i++){
            if (USBIEKOU[i] != null){
                USBIEKOU[i].turnOn();
            }
        }
        System.out.println("已全部打开");
    }

    public void turnOff(){
        System.out.println("关闭");
        for (int i = 0; i < USBIEKOU.length; i++){
            if (USBIEKOU[i] != null){
                USBIEKOU[i].turnOff();
            }
        }
        System.out.println("已全部关闭");
    }
}

public class TestDemo1201_1 {
    public static void main(String[] args) {
        USB mic = new mic();
        USB mouse = new mouse();
        Computer computer = new Computer();
        computer.add(mic);
        computer.add(mouse);
        computer.turnOn();
        computer.turnOff();
    }
}
