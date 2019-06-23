/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-03-18 15:07
 **/

public class OListDG {
    int vlen; // 顶点个数
    int elen; // 边个数
    VertexNode[] vertexNodeList; // 顶点数组
    EdgeNode edgeNode;

    /**
     * 构造函数
     * @param vexs
     * @param edges
     */
    public OListDG(String[] vexs, String[][] edges) {
        vlen = vexs.length;
        elen = edges.length;

        // 初始化顶点,建立顶点表
        vertexNodeList = new VertexNode[vlen];
        for (int i = 0; i < vlen; i++) {
            vertexNodeList[i] = new VertexNode();
            vertexNodeList[i].vertex = vexs[i];
            vertexNodeList[i].firstIn = null;
            vertexNodeList[i].firstOut = null;
        }

        // 初始化边，利用头插法建立十字链表
        for (int i = 0; i < elen; i++) {
            EdgeNode edgeNode_1 = new EdgeNode();
            EdgeNode edgeNode_2 = new EdgeNode();
            int vi = getPosition(edges[i][0], vexs);
            int vj = getPosition(edges[i][1], vexs);

            edgeNode_1.tailvex = vi;
            edgeNode_1.headvex = vj;
            edgeNode_1.taillini = vertexNodeList[vi].firstOut;
            vertexNodeList[vi].firstOut = edgeNode_1;

            edgeNode_2.tailvex = vi;
            edgeNode_2.headvex = vj;
            edgeNode_2.headlini = vertexNodeList[vj].firstIn;
            vertexNodeList[vj].firstIn = edgeNode_2;

        }
    }

    /**
     *  功能：顶点表结点结构
     *  参数：vertex --> 顶点域，存储顶点信息
     *       firstIn --> 入边表头指针，指向该顶点的入边表中第一个结点
     *       firstOut --> 出边表头指针，指向该顶点的出边表中第一个结点
     */
    private class VertexNode {
        String vertex;
        EdgeNode firstIn;
        EdgeNode firstOut;
    }

    /**
     *  功能：边表结点
     *  参数：tailvex --> 弧起点在顶点表的下标
     *        headvex --> 弧终点在顶点表的下标
     *        headlini --> 入边表指针域,指向终点相同的下一条边
     *        taillini --> 边表指针域，指向起点相同的下一条边
     */
    private class EdgeNode {
        int tailvex;
        int headvex;
        EdgeNode headlini;
        EdgeNode taillini;
    }

    /**
     *  功能：返回ch位置
     */
    private int getPosition(String ch, String[] vexs) {
        for (int i = 0; i < vlen; i++)
            if (vexs[i] == ch)
                return i;
        return -1;
    }

    /**
     *  功能：打印邻接表和逆邻接表
     */
    public void print() {
        System.out.printf("AdjList:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "-->");
            if (vertexNodeList[i].firstOut != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstOut;
                System.out.print(mEdgeNode.headvex);
                while (mEdgeNode.taillini != null) {
                    mEdgeNode = mEdgeNode.taillini;
                    System.out.print(mEdgeNode.headvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }

        System.out.print("----------\n");

        System.out.printf("InvAdjList:\n");
        for (int i = 0; i < vlen; i++) {
            System.out.print(vertexNodeList[i].vertex + "<--");
            if (vertexNodeList[i].firstIn != null) {
                EdgeNode mEdgeNode = new EdgeNode();
                mEdgeNode = vertexNodeList[i].firstIn;
                System.out.print(mEdgeNode.tailvex);
                while (mEdgeNode.headlini != null) {
                    mEdgeNode = mEdgeNode.headlini;
                    System.out.print(mEdgeNode.tailvex);
                }
                System.out.print("\n");
            } else {
                System.out.print("\n");
            }
        }
    }

    /**
     * 主函数
     */
    public static void main(String args[]) {
        // 顶点数组
        String[] vexs = {
                "Ai","B","C","D"
        };
        // 边数组
        String[][] edges = new String [][] {
                {
                        "Ai","B"
                }, {
                "Ai", "C"
        }, {
                "Ai","D"
        }, {
                "B","D"
        }, {
                "C","D"
        }
        };

        OListDG listUDG = new OListDG(vexs, edges);
        listUDG.print();
    }
}

