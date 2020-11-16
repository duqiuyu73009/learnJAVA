package day_1116;
//计算机系统上一般配置了若干USB接口，可以连接不同类型的USB设备，
// 比如鼠标、键盘、USB耳麦、甚至蓝牙、ZIGBEE、GSM／GPRS等USN接口的电子模块。
// 计算机上可以在其USB接口上添加／删除这些设备。每次计算机开机时，都会逐一打开所有连接的USB设备，
// 同样，每一次关机前，计算机都会逐一关闭所有联机的USB设备，
// 请借助于面向对象中的类、内部类、向上类型转型等概念，设计程序，模拟计算机USB设备管理程序


class Computer4{
    USB4[] USBDEV = new USB4[6];
    void addUSB(USB4 u){
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

    interface USB4{
        void turnOn();
        void turnOff();
    }

    class mouse4 implements USB4 {
        @Override
        public void turnOn(){
            System.out.println("鼠标已经打开！");
        }
        @Override
        public void turnOff(){
            System.out.println("鼠标已经关闭！");
        }
    }


    class keyboard4 implements USB4 {
        @Override
        public void turnOn(){
            System.out.println("键盘已经打开！");
        }
        @Override
        public void turnOff(){
            System.out.println("键盘已经关闭！");
        }
    }

    class mic4 implements USB4 {
        @Override
        public void turnOn(){
            System.out.println("耳机已经打开！");
        }
        @Override
        public void turnOff(){
            System.out.println("耳机已经关闭！");
        }
    }

    class ZIGBEE4 implements USB4 {
        @Override
        public void turnOn(){
            System.out.println("ZIGBEE已经打开！");
        }
        @Override
        public void turnOff(){
            System.out.println("ZIGBEE已经关闭！");
        }
    }

    class GSM4 implements USB4 {
        @Override
        public void turnOn(){
            System.out.println("GSM已经打开！");
        }
        @Override
        public void turnOff(){
            System.out.println("GSM已经关闭！");
        }
    }
}


public class TestDemo1116_4 {
    public static void main(String[] args) {
        Computer4 computer4 = new Computer4();
        Computer4.USB4 a1 = computer4.new mouse4();
        Computer4.USB4 a2 = computer4.new mic4();
        Computer4.USB4 a3 = computer4.new keyboard4();
        Computer4.USB4 a4 = computer4.new ZIGBEE4();
        Computer4.USB4 a5 = computer4.new GSM4();

        computer4.addUSB(a1);
        computer4.addUSB(a2);
        computer4.addUSB(a3);
        computer4.addUSB(a4);
        computer4.addUSB(a5);
        computer4.TurnOn();
        computer4.TurnOff();
    }
}
