package day_1116;
//计算机系统上一般配置了若干USB接口，可以连接不同类型的USB设备，
// 比如鼠标、键盘、USB耳麦、甚至蓝牙、ZIGBEE、GSM／GPRS等USN接口的电子模块。
// 计算机上可以在其USB接口上添加／删除这些设备。每次计算机开机时，都会逐一打开所有连接的USB设备，
// 同样，每一次关机前，计算机都会逐一关闭所有联机的USB设备，
// 请借助于面向对象中的类、继承、接口、向上类型转型等概念，设计程序，模拟计算机USB设备管理程序

interface USB2{
     void turnOn();
     void turnOff();
}

class mouse2 implements USB2 {
    @Override
    public void turnOn(){
        System.out.println("鼠标已经打开！");
    }
    @Override
    public void turnOff(){
        System.out.println("鼠标已经关闭！");
    }
}


class keyboard2 implements USB2 {
    @Override
    public void turnOn(){
        System.out.println("键盘已经打开！");
    }
    @Override
    public void turnOff(){
        System.out.println("键盘已经关闭！");
    }
}

class mic2 implements USB2 {
    @Override
    public void turnOn(){
        System.out.println("耳机已经打开！");
    }
    @Override
    public void turnOff(){
        System.out.println("耳机已经关闭！");
    }
}

class ZIGBEE2 implements USB2 {
    @Override
    public void turnOn(){
        System.out.println("ZIGBEE已经打开！");
    }
    @Override
    public void turnOff(){
        System.out.println("ZIGBEE已经关闭！");
    }
}

class GSM2 implements USB2 {
    @Override
    public void turnOn(){
        System.out.println("GSM已经打开！");
    }
    @Override
    public void turnOff(){
        System.out.println("GSM已经关闭！");
    }
}

class Computer2{
    USB2[] USBDEV = new USB2[6];
    void addUSB(USB2 u){
        for (int i = 0; i < USBDEV.length ;i++){
            if (USBDEV[i] == null){
                USBDEV[i] = u;
                break;
            }
        }
    }
    void TurnOn(){
        System.out.println("Computer is on");
        for (int i = 0; i < USBDEV.length ;i++){
            if (USBDEV[i] != null){
                USBDEV[i].turnOn();
            }
        }
        System.out.println("all is on"+"\n");
    }
    void TurnOff(){
        System.out.println("Computer is Off");
        for (int i = 0; i < USBDEV.length ;i++){
            if (USBDEV[i] != null){
                USBDEV[i].turnOff();
            }
        }
        System.out.println("all is Off");
    }
}


public class TestDemo1116_3 {
    public static void main(String[] args) {
        USB2 a1 = new mouse2();
        USB2 a2 = new mic2();
        USB2 a3 = new keyboard2();
        USB2 a4 = new ZIGBEE2();
        USB2 a5 = new GSM2();

        Computer2 computer2 = new Computer2();
        computer2.addUSB(a1);
        computer2.addUSB(a2);
        computer2.addUSB(a3);
        computer2.addUSB(a4);
        computer2.addUSB(a5);
        computer2.TurnOn();
        computer2.TurnOff();
    }
}
