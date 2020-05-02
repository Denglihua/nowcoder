/**
 * @ Author:dlh
 * @ Date:2020/3/26--->10:34
 * @ Description:
 */
public class addBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb=new StringBuilder("");
        int i=a.length()-1;
        int j=b.length()-1;int carry=0;
        while (i>=0||j>=0){
            int n1=i>=0?a.charAt(i)-'0':0;
            int n2=j>=0?b.charAt(j)-'0':0;
            int sum=n1+n2+carry;
            carry=sum/2;
            sb.append(sum%2);
            i--;j--;
        }
        if(carry==1){
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addBinary ab=new addBinary();
        System.out.println(ab.addBinary("11","1"));
    }
}
