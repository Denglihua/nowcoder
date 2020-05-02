package meituan;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ Author:dlh
 * @ Date:2020/4/18--->23:49
 * @ Description:
 */
public class systemLRU {
    public static Stack<Integer> keyStack=new Stack<>();
    public static HashMap<Integer,Integer> list=new HashMap<>();
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int N=cin.nextInt();
        while (cin.hasNext()){
            String getOrPush=cin.next();
            if(getOrPush.equals("get")){
                int key=cin.nextInt();
                get(key);
            }else if(getOrPush.equals("put")){
                int key=cin.nextInt();
                int value=cin.nextInt();
                push(key,value,N);
            }else {
                break ;
            }
        }
        int temp[]=new int[keyStack.size()];
        int len=keyStack.size();
        for(int i=0;i<len;i++){
            temp[i]=keyStack.pop();
        }
        for(int i=temp.length-1;i>=0;i--){
            System.out.println(temp[i]+" "+list.get(temp[i]));
        }
    }
    public static int  get(int key){
        if(keyStack.contains(key)){
            Stack<Integer> temp=new Stack<>();
            while (!keyStack.isEmpty()){
                if(keyStack.peek()!=key){
                    temp.push(keyStack.pop());
                }else {
                    keyStack.pop();
                    break;
                }
            }
            while (!temp.isEmpty()){
                keyStack.push(temp.pop());
            }
            keyStack.push(key);
            return list.get(key);
        }else {
            return -1;
        }
    }
    public static void push(int key,int value,int N){
            //key不存在keyStack中
            //1-->keyStack没有达到缓存容量,直接存入
            if(keyStack.size()<N){
                keyStack.push(key);
                list.put(key,value);
            }else {
                //2-->keyStack达到缓存容量,删除栈底元素，将key存入
                Stack<Integer> temp=new Stack<>();
                while (!keyStack.isEmpty()){
                    temp.push(keyStack.pop());
                }
                temp.pop();
                while (!temp.isEmpty()){
                    keyStack.push(temp.pop());
                }
                keyStack.push(key);
                list.put(key,value);
            }
    }
}
