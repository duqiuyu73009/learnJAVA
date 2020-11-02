package day_1102;

public class TestDemo1102_1 {
    public static void main(String[] args) {
        USB a1 = new mouse();
        USB a2 = new mic();
        Computer c = new Computer();
        c.addUSB(a1);
        c.addUSB(a2);
        c.TurnOn();
        c.TurnOff();
    }
}

class USB{
    void turnOn(){

    }
    void turnOff(){

    }
}

class mouse extends USB{
    @Override
    void turnOn(){
        System.out.println("mouse is on");
    }
    @Override
    void turnOff(){
        System.out.println("mouse is off");
    }
}

class mic extends USB{
    @Override
    void turnOn(){
        System.out.println("mic is on");
    }
    @Override
    void turnOff(){
        System.out.println("mic is off");
    }
}

class Computer{
    USB[] USBDEV = new USB[4];
    void addUSB(USB u){
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
        System.out.println("all is on");
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
