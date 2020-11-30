package day1130;

public class TestDemo1130_1 {
    //这是使用内部类实现的多媒体教室上下课管理模拟程序
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        room1 r=new room1();
        room1.Light light= new room1.Light();
        room1.Fan fan =r.new Fan();
        r.add(fan);
        r.add(light);
        r.上课();
        r.下课();
    }
}

class room1
{
    DEVICE[] dev=new DEVICE[20];
    void add(DEVICE d)
    {
        for(int i=0;i<dev.length;i++)
        {
            if(dev[i]==null)
            {
                dev[i]=d;
                break;
            }
        }
    }
    void 上课()
    {
        System.out.println("准备上课");
        for(int i=0;i<dev.length;i++)
        {
            if(dev[i]!=null)
            {
                dev[i].turnon();;
            }
        }
    }
    void 下课()
    {
        System.out.println("准备下课");
        for(int i=0;i<dev.length;i++)
        {
            if(dev[i]!=null)
            {
                dev[i].turnoff();
            }
        }
    }

    interface DEVICE
    {
        void turnon();
        void turnoff();
    }

    static class Light implements DEVICE
    {
        @Override
        public void turnon()
        {
            System.out.println("Light is on");
        }
        @Override
        public void turnoff()
        {
            System.out.println("Light is off");
        }
    }
    class Fan implements DEVICE
    {
        @Override
        public void turnon()
        {
            System.out.println("Fan is on");
        }
        @Override
        public void turnoff()
        {
            System.out.println("Fan is off");
        }
    }