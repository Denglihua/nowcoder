import java.util.*;

/**
 * @Program:nowcoder
 * @description:树的数据结构
 * @Author:dlh
 * @Date:2019-07-01-12-37
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int x){
        val=x;
    }
    //递归方式获得二叉树的最大深度
    public int maxDepth(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public void createBinTree(int [] array){
        List<TreeNode> ls=new LinkedList<TreeNode>();
        for(int index=0;index<array.length;index++){
            ls.add(new TreeNode(array[index]));
        }
        for(int parentIndex=0;parentIndex<array.length/2-1;parentIndex++){
            //左孩子
            ls.get(parentIndex).left=ls.get(parentIndex*2+1);
            //右孩子
            ls.get(parentIndex).right=ls.get(parentIndex*2+2);
            //处理最后一个父节点，最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
            int lastParentIndex=array.length/2-1;
            //左孩子
            ls.get(lastParentIndex).left=ls.get(lastParentIndex*2+1);
            //数组为奇数最后一个节点才有右孩子
            if(array.length%2==1){
                ls.get(lastParentIndex).right=ls.get(lastParentIndex*2+2);
            }
        }
    }
    public  void print(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
        }
        if(root.left!=null){
            print(root.left);
        }
        if(root.right!=null){
            print(root.right);
        }
    }
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        return (root1!=null&&root2!=null)&&(dfs(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2));
    }
    boolean dfs(TreeNode root1,TreeNode root2){
        if(root2==null){ return true;}
        if(root1==null||root1.val!=root2.val){ return false;}
        return dfs(root1.right,root2.right)&&dfs(root1.left,root2.left);
    }

    /**
     * 根据二叉树的前序遍历和中序遍历重建二叉树
     * 找到{1}在中序遍历中的位置
     * 左子树：pre{2,4,7} in{4,7,2} 右子树：pre{3,5,6,8},in{5,3,8,6}
     * @param pre{1,2,4,7,3,5,6,8}
     * @param in{4,7,2,1,5,3,8,6}
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||in.length==0){
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(pre[0]==in[i]){
                //copyOfRange左闭右开
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return  root;
    }

    /**
     * 输入二叉树的后序遍历，判断改二叉树是不是二叉搜索树。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        return BST(sequence,0,sequence.length-1);
    }
    public static boolean BST(int[] seq,int start,int end){
        if(start>=end){
            return true;
        }
        int split=start;
        int root=seq[end];
        for(;seq[split]<root&&split<end;split++);
        for(int i=split;i<end;i++){
            if(seq[i]<root){
                return false;
            }
        }
        return BST(seq,start,split-1)&&BST(seq,split,end-1);
    }

    /**
     * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * @param root
     * @param target
     * @return
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)return result;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            result.add(new ArrayList<Integer>(list));
//因为在每一次的递归中，我们使用的是相同的result引用，所以其实左右子树递归得到的结果我们不需要关心，
//可以简写为FindPath(root.left, target)；FindPath(root.right, target)；
//但是为了大家能够看清楚递归的真相，此处我还是把递归的形式给大家展现了出来。
        FindPath(root.left, target);
        FindPath(root.right, target);
        //作用：回退一步
        list.remove(list.size()-1);
        return result;
    }

    /**
     * 1-n所有不同的二叉搜索树
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }else{
            return generate(1,n);
        }
    }
    public LinkedList<TreeNode> generate(int start,int end){
        LinkedList<TreeNode> trees=new LinkedList<>();
        if(start>end){
            trees.add(null);
            return trees;
        }
        for(int i=start;i<=end;i++){
            LinkedList<TreeNode> left_trees=generate(start,i-1);
            LinkedList<TreeNode> right_trees=generate(i+1,end);

            for(TreeNode l:left_trees){
                for(TreeNode r:right_trees){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    /**
     * 判断二叉树是不是平衡二叉树
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if(root.left==null&&root.right==null){
            return true;
        }
        if(Math.abs(getDepth(root.left)-getDepth(root.right))>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
    }

    /**
     * 二叉树的深度
     * @param p
     * @return
     */
    public int getDepth(TreeNode p){
        if(p==null){
            return 0;
        }
        return Math.max(getDepth(p.right),getDepth(p.left))+1;
    }

    /**
     * 二叉树的右视图
     * @param root
     * @return
     */

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode front=queue.poll();
            res.add(front.val);
            if(front.left!=null){
                queue.offer(root.left);
            }
            if(front.right!=null){
                queue.offer(root.right);
            }
        }
        return res;
    }
}


