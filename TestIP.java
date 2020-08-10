package day_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 *链接：https://www.nowcoder.com/questionTerminal/66ca0e28f90c42a196afd78cc9c496ea
 * 来源：牛客网
 *
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成一个长整数。举例：一个ip地址为10.0.3.193每段数字             相对应的二进制数10                   000010100                    000000003                    00000011193                  11000001组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验
 *
 *
 *
 *
 *
 * 输入描述:
 * 输入 1 输入IP地址2 输入10进制型的IP地址
 *
 *
 * 输出描述:
 * 输出1 输出转换成10进制的IP地址2 输出转换后的IP地址
 */
public class Test2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String ip = sc.nextLine();  //输入IP地址字符串
            String ip10 = sc.nextLine(); //输入10进制表示的IP地址字符串
            System.out.println(convertIp10(ip));//IP地址转10进制字符串
            System.out.println(convertIp(ip10));//10进制IP地址转IP地址
        }
    }

    private static long convertIp10(String ip){
        String[] ips = ip.split("\\.");//使用.分割
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<ips.length;i++){
            sb.append(binaryString(ips[i]));//10进制数转二进制字符串
        }
        return Long.parseLong(sb.toString(),2);
    }

    private static String binaryString(String s){//十进制转换为8位二进制
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(s);
        int k = 1<<7;
        for(int i=0;i<8;i++){
            int flag = (num & k)==0 ? 0 : 1;
            sb.append(flag);
            num=num<<1;
        }
        return sb.toString();
    }

    private static String convertIp(String ip10){
        StringBuffer sb = new StringBuffer();
        String ip2 = Long.toBinaryString(Long.parseLong(ip10));//长整型转二进制字符串（JDK Long的 静态方法）
        String as = "";
        if(ip2.length()<32){//不足32位前面补0
            for(int i=0;i<32-ip2.length();i++){
                as +="0";
            }
        }
        ip2 = as+ip2; //IP地址每一段进行拼接
        String[] ips = new String[4];
        ips[0] = ip2.substring(0,8);
        ips[1] = ip2.substring(8,16);
        ips[2] = ip2.substring(16,24);
        ips[3] = ip2.substring(24);
        for(int i=0;i<4;i++){
            sb.append(Integer.parseInt(ips[i],2));
            if(i!=3){
                sb.append(".");
            }
        }
        return sb.toString();
    }






    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = null;
        String line2 = null;
        while ((line1 = br.readLine()) != null && (line2 = br.readLine()) != null) {
            String[] IP1 = line1.split("\\.");
            long IP2 = Long.parseLong(line2);
            System.out.println(Long.parseLong(IP1[0]) << 24 | Long.parseLong(IP1[1]) <<
                    16 | Long.parseLong(IP1[2]) << 8 | Long.parseLong(IP1[3]));
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf((IP2 >> 24) & 255)).append(".")
                    .append(String.valueOf((IP2 >> 16) & 255)).append(".")
                    .append(String.valueOf((IP2 >> 8) & 255)).append(".")
                    .append(String.valueOf(IP2 & 255));
            System.out.println(sb.toString());
        }
    }
}
