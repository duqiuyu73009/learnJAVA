package day_1116;

public class Test {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        room r=new room();
        room.DEVICE light=r.new Light();
        room.DEVICE fan =r.new Fan();
        r.add(fan);
        r.add(light);
        r.上课();
        r.下课();
    }
}


class room {
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
    void 上课() {
        System.out.println("准备上课");
        for(int i=0;i<dev.length;i++)
        {
            if(dev[i]!=null)
            {
                dev[i].turnon8();;
            }
        }
    }
    void 下课() {
        System.out.println("准备下课");
        for(int i=0;i<dev.length;i++)
        {
            if(dev[i]!=null)
            {
                dev[i].turnoff8();
            }
        }
    }

    interface DEVICE {
        void turnon8();
        void turnoff8();
    }

    class Light implements DEVICE
    {
        @Override
        public void turnon8()
        {
            System.out.println("Light is on");
        }
        @Override
        public void turnoff8()
        {
            System.out.println("Light is off");
        }
    }
    class Fan implements DEVICE
    {
        @Override
        public void turnon8()
        {
            System.out.println("Fan is on");
        }
        @Override
        public void turnoff8()
        {
            System.out.println("Fan is off");
        }
    }
}
