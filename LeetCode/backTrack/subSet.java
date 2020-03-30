import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/3/15--->15:53
 * @ Description:给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 回溯算法模板：
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class subSet {
    /**
     * 输入: nums = [1,2,3]
     * 输出:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     * @param nums
     * @return
     */
    int[] inputArray = null;
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums)
    {
        inputArray = nums;
        backtrack(0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int i, ArrayList<Integer> tmp)
    {
        if (inputArray.length == i)
        {
            res.add(new ArrayList<>(tmp));
        }
        else
        {
            tmp.add(inputArray[i]);
            backtrack(i + 1, tmp);
            tmp.remove(tmp.size() - 1);
            backtrack(i + 1, tmp);
        }
    }
}
