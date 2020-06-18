import java.util.*;

/**
 * @program: nowcoder
 * @description: 字母大小写全排列
 * @author: denglihua
 * @create: 2019-06-18 12:32
 **/
public class letterCasePermutation {
    List<String> list=new ArrayList<>();
    private void backTrack(String combination,String next_letter){
        if(next_letter.length()==0){
            list.add(combination);
        }else {
            int temp=letterCase(next_letter.charAt(0));
            if(!(temp==0)){
                String letter=next_letter.substring(0,1);
                if(temp==1){
                    backTrack(combination+letter,next_letter.substring(1));
                    backTrack(combination+letter.toLowerCase(),next_letter.substring(1));
                }else {
                    backTrack(combination+letter,next_letter.substring(1));
                    backTrack(combination+letter.toUpperCase(),next_letter.substring(1));
                }

            }else {
                String letter=next_letter.substring(0,1);
                backTrack(combination+letter,next_letter.substring(1));
            }
        }
    }
    private int letterCase(char str){
        if(Character.isUpperCase(str)){
            return 1;
        }else if(Character.isLowerCase(str)){
            return -1;
        }else {
            return 0;
        }
    }

    /**
     * 字母大小写的全排列
     * @param S
     * @return
     */
    public List<String> letterCasePermutation(String S) {
        backTrack("",S);
        return list;
    }

    /**
     * 小写字母的全排列
     * @param str
     * @return
     */
    ArrayList<String> res=new ArrayList<>();
    char[] c;
    public ArrayList<String> Permutation(String str) {
        c=str.toCharArray();
        dfs(0);
        Collections.sort(res);
        return res;
    }

    public void dfs(int index){
        if(index==c.length-1){
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set=new HashSet();
        for(int i=index;i<c.length;i++){
            //剪枝
            if(set.contains(c[i]))
                continue;
            set.add(c[i]);
            swap(i,index);
            dfs(index+1);
            swap(i,index);
        }
    }
    private void swap(int x,int y){
        char temp=c[x];
        c[x]=c[y];
        c[y]=temp;
    }
    public static void main(String[] args) {
        letterCasePermutation lcp=new letterCasePermutation();
        System.out.println(lcp.Permutation("abb"));
        int[] a=new int[10];
    }
}
