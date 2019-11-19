import java.util.ArrayList;
import java.util.List;

/**
 * @Program:nowcoder
 * @description:给定一个二叉树，返回它的中序 遍历。
 * @Author:dlh
 * @Date:2019-07-01-12-36
 */
public class inorderTraversal {
    public List<Integer> inorderTraversal(Node root) {
        List<Integer> list=new ArrayList<>();
        if(root!=null){
            if(root.left!=null){
                inorderTraversal(root.left);
            }
            list.add(root.val);
            if(root.right!=null){
                inorderTraversal(root.right);
            }

        }
        return list;
    }

    public static void main(String[] args) {
        int a[]=new int[]{1,2,3,3,4,1,4,12,5};
        TreeNode tn=new TreeNode();
        tn.createBinTree(a);
        inorderTraversal it=new inorderTraversal();

    }
}
