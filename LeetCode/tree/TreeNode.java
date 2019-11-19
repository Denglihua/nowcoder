import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Program:nowcoder
 * @description:树的数据结构
 * @Author:dlh
 * @Date:2019-07-01-12-37
 */
public class TreeNode {
//    private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    private static List<Node> nodeList = null;

    /**
     * 内部类：节点
     *
     * @author ocaicai@yeah.net @date: 2011-5-17
     *
     */


    public void createBinTree(int [] array) {
        nodeList = new LinkedList<Node>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }


    public void printTree(){

    }
}


