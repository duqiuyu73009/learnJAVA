package day1108;

class Room{
    public int n;
    public String room;

    public Room(int n, String room) {
        this.n = n;
        this.room = room;
    }

    public void Ret(){
        System.out.println("门牌号为"+n+", 店名"+room + "Room");
    }
}

class Desk extends Room{

    public int num;
    public Desk(int n, String room, int num) {
        super(n, room);
        this.num = num;
    }


    //加入以下重写方法（也就是跟父类一样的方法）就可以完成运行时绑定
    @Override
    public void Ret(){
        System.out.println("门牌号为"+n+", 店名"+room + "Dest");
    }
}


public class TestDemo1108_1 {
    public static void main(String[] args) {
        Room room = new Desk(203,"花田",34);
        room.Ret();
    }
}
