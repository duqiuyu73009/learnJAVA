package day21_1_18_2;

//泛型
public class TestDemo0118_1<E> {
    private E[] data = (E[])new Object[100];
    private int size;

    public E get(int index){
        return data[index];
    }

    public void add(E elem){
        data[size] = elem;
        size++;
    }

    public static void main(String[] args) {
        TestDemo0118_1<String> test = new TestDemo0118_1<>();
        test.add("aaa");
        String str = test.get(0);
    }
}
