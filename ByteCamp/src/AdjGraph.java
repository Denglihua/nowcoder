/**
* @program: nowcoder
* @description:
* @author: denglihua
* @create: 2019-06-01 20:15
**/

import java.util.ArrayList;

public class AdjGraph

{

    private ArrayList<Node> vertexList=new ArrayList<Node>();//保存顶点信息

    private int numOfEdges;

    public void addNode(String data)

    {

        vertexList.add(new Node(data));

    }

    public void addEdges(int i,int j,int weight)

    {

        MyVertex v=new MyVertex(vertexList.get(j));

        v.setWeight(weight);

        vertexList.get(i).getAdj().add(v);;

        numOfEdges++;

    }



    public static void main(String[] args)

    {

        AdjGraph G=new AdjGraph();

        G.addNode("a");

        G.addNode("b");

        G.addNode("c");

        G.addNode("d");



        G.addEdges(1,2,6);

        G.addEdges(0,2,4);

        G.addEdges(0,3,7);

        G.addEdges(3,2,9);



        System.out.println("边的数量："+G.numOfEdges);



        for(int i=0;i<G.numOfEdges;i++)

        {

            Node node=G.vertexList.get(i);

            for(MyVertex v:node.getAdj())

            {

                System.out.println(node.toString()+" "+v.getNode().toString()

                        +" "+v.getWeight());

            }



        }

    }

}

class Node //顶点信息

{

    private String data;

    public ArrayList<MyVertex> adj;

    Node(String data)

    {

        this.data=data;

        adj=new ArrayList<MyVertex>();

    }

    public ArrayList<MyVertex> getAdj()//获取顶点指向的邻接点

    {

        return adj;

    }

    public String getName()

    {

        return data;

    }

    public String toString()

    {

        return data;

    }



}

class MyVertex

{

    private Node node;

    private int weight;

    private int indegree;

    MyVertex(Node node)

    {

        this.node=node;

    }

    public void addadj(MyVertex v)//添加邻接点

    {

        node.adj.add(v);

    }



    public void setWeight(int weight)//	设置权值

    {

        this.weight=weight;

    }

    public int getWeight()

    {

        return this.weight;

    }

    public Node getNode()

    {

        return node;

    }

    public String toString()

    {

        return node.toString();

    }

}



