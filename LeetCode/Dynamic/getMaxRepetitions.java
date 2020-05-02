/**
 * @ Author:dlh
 * @ Date:2020/4/19--->2:15
 * @ Description:
 */
public class getMaxRepetitions {
    public  static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        s1=splice(s1,n1);
        s2=splice(s2,n2);
        int count=0;
        String temp=s2;
        while (match(s1,s2)){
            count++;
            s2=splice(temp,count+1);
        }
        return count;
    }
    public static boolean match(String s2,String s1){
        int i=0,j=0;
        for(;i<s1.length()&&j<s2.length();){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        if(i==s1.length()){
            return true;
        }else {
            return false;
        }
    }
    public static String splice(String s,int n){
        String temp=s;
        while (n>1){
            s=s.concat(temp);
            n--;
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("aaa",3,"aa",1));
    }
}
