import java.util.ArrayList;
import java.util.List;

/**
 * @Program:nowcoder
 * @description:生成杨辉三角
 * @Author:dlh
 * @Date:2019-09-06 10:36
 */
public class GenerateRectangle {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res=new ArrayList<>();
        int[][] arrays=new int[numRows][numRows];
        for(int i=0;i<numRows;i++){
            for(int j=0;j<numRows;j++){
                if(j==0||j==i){
                    arrays[i][j]=1;
                }
            }
        }
        for(int i=1;i<numRows;i++){
            for(int j=1;j<numRows;j++){
                arrays[i][j]=arrays[i-1][j-1]+arrays[i-1][j];
            }
        }
        for(int i=0;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            for(int j=0;j<numRows;j++){
                if(arrays[i][j]!=0){
                    temp.add(arrays[i][j]);
                }
            }
            res.add(temp);
        }
        return res;
    }

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 你可以优化你的算法到 O(k) 空间复杂度吗？
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        int[][] arrays=new int[rowIndex+1][rowIndex+1];
        for(int i=0;i<rowIndex+1;i++){
            for(int j=0;j<rowIndex+1;j++){
                if(j==0||j==i){
                    arrays[i][j]=1;
                }
            }
        }
        for(int i=1;i<rowIndex+1;i++){
            for(int j=1;j<rowIndex+1;j++){
                arrays[i][j]=arrays[i-1][j-1]+arrays[i-1][j];
            }
        }
        for(int i=rowIndex,j=0;j<rowIndex+1;j++){
            res.add(arrays[i][j]);
        }
        return res;
    }
}
