package Test0320;

//题目描述
//开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
//处理:
//1、记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配)只记录一条，错误计数增加;
//2、超过16个字符的文件名称，只记录文件的最后有效16个字符;
//3、输入的文件可能带路径，记录文件名称不能带路径。

//输入描述:
//一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
//输出描述:
//将所有的记录统计并将结果输出，格式:文件名代码行数数目，一个空格隔开，如:

//E:\V1R2\product\fpgadrive.c   1325
//fpgadrive.c 1325 1

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestDemo0320_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] srcSum = new String[8];
        Map<String,Integer> map = new HashMap<>();
        for (int j = 0; j < srcSum.length; j++){
            srcSum[j] = scanner.nextLine();
        }

        for (int i = 0; i < srcSum.length; i++){
            if (srcSum[i].length() != 0) {
                String[] srcSplit = srcSum[i].split("\\s+");
                String[] srcFiles = srcSplit[0].split("\\\\");
                String srcFile = srcFiles[srcFiles.length-1];//获取到了文件名
                String[] file = srcFile.split("\\.");
                if (file[0].length() > 16){
                    int n = file[0].length() - 16;
                    srcFile = file[0].substring(n-1,file[0].length()-1)+"."+file[1];
                }
                srcFile = srcFile+" "+ srcSplit[1];
                if ( (!map.isEmpty()) && map.get(srcFile) != null){
                    //如果在map中找到了
                    map.put(srcFile,map.get(srcFile)+1);
                }else{
                    //没找到
                    map.put(srcFile,1);
                }
            }
        }

        for (Map.Entry<String,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey()+" "+ entry.getValue());
        }
    }
}
