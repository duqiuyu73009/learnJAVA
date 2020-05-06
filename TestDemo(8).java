import com.sun.deploy.security.ruleset.DRSResult;

import java.util.ArrayList;
import java.util.List;

//杨辉三角
public class TestDemo {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> resut = new ArrayList<>();
        if (numRows <= 0){
            return resut;
        }
        //处理第一行的情况
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        resut.add(firstLine);
        if (numRows == 1){
            return resut;
        }
        //处理第二行，就固定只有两个1
        ArrayList<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        resut.add(secondLine);
        if (numRows == 2){
            return resut;
        }
        //处理后面的行了
        //第i行相关规律
        //1.第一列和最后一列都是1；
        //2.第i行有i列
        //3.i，j = （i- 1，j-1）+（i-1，j）
        for (int row = 3; row <= numRows ; row++){
            //需要构造第row行的内容，构造第row行内容，依赖了row-1行
            List<Integer> prevLine = resut.get(row - 1 -1);//row从1开始算的，下标是从0开始算的
            List<Integer> curLine = new ArrayList<>();
            //当前行的第一列是1
            curLine.add(1);
            //col 列
            for (int col = 2; col <= row-1; col++){
                int tmp1 = prevLine.get(col -1 -1);//先算col-1列，再取下标
                int tmp2 = prevLine.get(col - 1);
                curLine.add(tmp1 +tmp2);
            }
            //最后一列也是1
            curLine.add(1);
            resut.add(curLine);
        }
        return resut;
    }
}
