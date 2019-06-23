import java.util.Scanner;

/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-06-01 19:01
 **/
public class test {
    public static void main(String[] args) {
        test ma=new test();
        Scanner cin=new Scanner(System.in);
        String inputStr1=cin.nextLine();
        String inputStr2=cin.nextLine();
        String s2[]=inputStr2.split(" ");
        if(ma.isValid(inputStr1,s2)){
            System.out.println("True");
        }else {
            System.out.println("False");
        }
    }

    public boolean isValid(String s1,String[] s2){
        for(int i=0;i<s2.length;i++){
            if(s1.contains(s2[i])){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
