
public class ToSyring{
//自己写一个toString
    public static void main(String[] args) {
        int array={1,2,3,4,5,6,7,8};
        String ret=myToString(array);
        System.out.println(ret);
    }
    public static String myToString(int[] array){
        String ret = "[";
        for(int i=0; i<array.length; i++){
            ret +=array[1];
            if(i != array.length) {
                ret = ret + ",";
            }
        }
        ret =ret+"]";
        return ret;
    }
}