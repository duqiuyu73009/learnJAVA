package Test0508;

public class TestDemo0508_3 {
    public int minWater (int[] height) {
        // write code here
        int n = height.length;
        int[][] min = new int[n][n];
        for (int i = 0; i < height.length ; i++){
            for (int j = 0; j < height.length; j++){
                if (height[i] > height[j]){
                    if (i > j){
                        min[i][j] = (i-j)*height[j];
                    }else if (i < j){
                        min[i][j] = (j-i)*height[j];
                    }
                }
                if (height[j] > height[i]){
                    if (i < j){
                        min[j][i] = (j-i)*height[i];
                    }else if (i > j){
                        min[j][i] = (i-j)*height[i];
                    }
                }
            }
        }
        int minsize = min[0][0];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                minsize = minsize <= min[i][j] ? minsize : min[i][j];
            }
        }
        return minsize;
    }
}
