package day21_1_27;

//题目描述请实现接口:
//unsigned int AddCandidate (char* pCandidateName);功能:设置候选人姓名
//输入: char* pCandidateName候选人姓名输出:无
//返回:输入值非法返回0，已经添加过返回0，添加成功返回1
//Void Vote(char* pCandidateName);
//功能:投票
//输入: char* pCandidateName候选人姓名输出:无
//返回:无
//unsigned int GetVoteResult (char* pCandidateName);
//功能:获取候选人的票数。如果传入为空指针，返回无效的票数，同时说明本次投票活动结束，释放资源
//输入: char* pCandidateName候选人姓名。当输入一个空指针时，返回无效的票数
//输出:无
//返回:该候选人获取的票数
//void Clear()
//Ⅱ功能:清除投票结果，释放所有资源l/输入:
//输出:无Ⅱ返回
import java.util.*;
public class TestDemo0127_2{
    public  static void result(String n1 ,String[] st,String n2,String[] str){
        int n = st.length;
        int m = str.length;
        int Invalid = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            int num = 0;
            for (int j =0; j < m; j++){
                if (st[i].equals(str[j])){
                    num ++;
                }
            }
            sum += num;
            System.out.println(st[i] + " " +":" + " " + num);
        }
        if (sum < m){
            Invalid = m - sum;
            System.out.println("Invalid"+" " +":" +" " + Invalid);
        }else {
            System.out.println("Invalid"+" " +":" +" " + 0);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.nextLine();    //人数
            String str2 = sc.nextLine();    //人名
            String str3 = sc.nextLine();    //投票人数
            String str4 = sc.nextLine();    //投票的具体给谁
            String[] arr1 = str2.split(" ");
            String[] arr2 = str4.split(" ");
            result(str1,arr1,str3,arr2);
        }
    }
}
