package day_17;

import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/97ba57c35e9f4749826dc3befaeae109
 * 来源：牛客网
 *
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，每辆火车以数字1-9编号，
 * 火车站只有一个方向进出，同时停靠在火车站的列车中，只有后进站的出站了，先进站的才能出站。
 * 要求以字典序排序输出火车出站的序列号。
 *
 *
 * 输入描述:
 * 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 *
 *
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //输入n个
            int n = scanner.nextInt();
            //输入包含的n个正整数
            int[] A = new int[10];
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
            int start = 0;
            //计算n个火车的出站的编号的排列组合
            ArrayList<int[]> result = new ArrayList<int[]>();
            Permutation(A,start,n,result);
            //出栈的结果，一个元素一个记录，例如：1 2 3 ； 1 3 2
            Set<String> sortResult = new TreeSet<String>();
            //循环排列组合
            for(int[] out : result){
                //判断是否满足出栈要求（后进先出）
                if(isLegal(A,out,n)){
                    //满足的组合，输入结果，每一个编号用空格分隔
                    StringBuilder sb = new StringBuilder();
                    for(int i=0;i<n-1;i++){
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    sortResult.add(sb.toString());
                }
            }
            //最后输出所有的符合出栈要求的组合
            for(String list:sortResult){
                System.out. println(list);
            }
        }
        scanner.close();
    }

    /*in : 火车编号数组
	out : 火车出站顺序
	n : 火 车 数 量
	*/
    private static boolean isLegal(int[] in,int[] out,int n){
        //栈：存储进站的火车编号
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int i=0;
        int j=0;
        while(i < n){
            // in 还有元素的时候都需要判断
            if(in[i] == out[j]){
                //相等时候就不用入栈，直接后移
                i++;
                j++;
            }else{
                if(stack.isEmpty()){
                    //空stack 就只有入栈了
                    stack.push(in[i]);
                    i++;
                }else{
                    int top = stack.peek();
                    // 栈顶元素相等，进行出栈
                    if(top == out[j]){
                        j++;
                        stack.pop();
                    }else if(i < n){
                        //不相等时候入栈，说明还有待进站的车
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        while(!stack.isEmpty() && j<n){
            // in 的结束后，栈中元素进程出栈序列应该和out剩余的元素相同
            int top = stack.pop();
            if(top == out[j]){
                j++;
            }else{
                return false;
            }
        }
        return true;
    }

    private static void Permutation(int[] A,int start,int n,ArrayList<int[]> result){
        if(start == n){
            return;
        }
        if(start == n-1){
            int[] B = A.clone();
            result.add(B);
            return;
        }
        for(int i=start;i<n;i++){
            swap(A,start,i) ;
            Permutation(A,start+1,n,result);
            swap(A,start,i);
        }
    }
    private static void swap(int[] A,int i,int j){
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}
