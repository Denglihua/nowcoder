import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program:nowcoder
 * @description:
 * @Author:dlh
 * @Date:2019-07-18 15:19
 */
public class test1 {
    public static void main(String[] args) {
        TreeNode node=new TreeNode();
        node.createBinTree(new int[]{3,9,20,15,7});
        node.levelOrderBottom(node);
    }
}
