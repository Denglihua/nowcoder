/**
 * @ Author:dlh
 * @ Date:2020/4/21--->10:47
 * @ Description:平衡二叉树
 */
public class AvlTreeNode {
    AvlTreeNode parent;//当前节点的父节点
    AvlTreeNode left;//左孩子
    AvlTreeNode right;//右孩子
    int depth;//深度
    int banlence;//平衡因子
    int val;//节点值

    /**
     * 50 ,45 ,44
     * @param p
     */
    private void right_rotate(AvlTreeNode p){
        //一次旋转参与节点：祖父、父亲、右儿子
        AvlTreeNode pParent=p.parent;
        AvlTreeNode pLeftSon=p.left;
        AvlTreeNode pRightGranddSon=pLeftSon.right;
        //左孩子变成p节点的父节点
        pLeftSon.parent=p.parent;
        if(pParent!=null){
            if(p==pParent.left){
                pParent.left=pLeftSon;
            }else if(p==pParent.right){
                pParent.right=pLeftSon;
            }
        }
        pLeftSon.right=p;
        p.parent=pLeftSon;
    }

    /**
     * 平衡因子
     * @param p
     * @return
     */
    public int calcBalence(AvlTreeNode p){
        int left_depth;
        int right_depth;
        if(p.left!=null){
            left_depth=p.left.depth;
        }else {
            left_depth=0;
        }
        if(p.right!=null){
            right_depth=p.right.depth;
        }else {
            right_depth=0;
        }
        return left_depth-right_depth;
    }

    public int calcDepth(AvlTreeNode p){
        if(p==null){
            return 0;
        }
        return Math.max(calcDepth(p.left),calcBalence(p.right));
    }
}
