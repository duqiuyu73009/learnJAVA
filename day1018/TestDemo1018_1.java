package day1018;


public class TestDemo1018_1 {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(0,0);
        myArrayList.add(1,1);
        myArrayList.add(2,2);
        myArrayList.add(3,3);
        myArrayList.add(4,4);
        myArrayList.add(5,5);
        myArrayList.add(6,6);
//        也可以这样赋值：
//        for (int i = 0; i < 10; i++){
//            myArrayList.add(i, i);
//        }
        myArrayList.add(7,19);
        myArrayList.display();

        System.out.println(myArrayList.search(19));

        System.out.println(myArrayList.getPos(5));

        myArrayList.setPos(2,64);
        myArrayList.display();

    }
}
