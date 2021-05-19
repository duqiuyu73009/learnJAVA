package Test0513;

//题目描述
//请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，
// 向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
// 例如 \begin{bmatrix} a & b & c &e \\ s & f & c & s \\ a & d & e& e\\ \end{bmatrix}\quad
//  矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
//  因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
//
//示例1
//输入
//复制
//[[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
//返回值
//复制
//true
public class TestDemo0519 {
    public boolean hasPath (char[][] matrix, String word) {
        int rows = matrix.length;
        if (rows == 0) return false;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];//标识每个方格是否在路径里面，防止路径进入重复的方格里
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath (matrix,i,j,visited,word,0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasPath (char[][] matrix,int row,int col,boolean[][] visited,String word,int loc) {
        if (loc == word.length()) {
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row < 0 || row == rows || col < 0 || col == cols) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }
        if (matrix[row][col] == word.charAt(loc)){
            visited[row][col] = true;
            if (hasPath (matrix,row-1,col,visited,word,loc+1) || hasPath (matrix,row+1,col,visited,word,loc+1)
                    || hasPath (matrix,row,col-1,visited,word,loc+1) || hasPath (matrix,row,col+1,visited,word,loc+1)){
                return true;
            }
            visited[row][col] = false;
        }
        return false;
    }
}
