/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-06-01 19:32
 **/
public class topic_03 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val=val;
            left=right=null;
        }
    }
    public static TreeNode findNode(int nodeVal,TreeNode root){
        TreeNode target=null;
        if(root==null){
            return null;
        }
        if(root.val==nodeVal){
            return root;
        }
        target=findNode(nodeVal,root.left);
        if(target==null){
            target=findNode(nodeVal,root.right);
        }
        return target;
    }
    public static void main(String[] args) {

    }

}
