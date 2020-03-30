/**
 * @ Author:dlh
 * @ Date:2020/3/26--->9:33
 * @ Description:
 */
public class multiply {
    public String multiply(String num1, String num2) {
        if(num1.equals("0")||num2.equals("0")){
            return "0";
        }
        int l1=num1.length()-1;
        int l2=num2.length()-1;
        int[] res=new int[num1.length()+num2.length()];
        for(int i=l1;i>=0;i--){
            int temp1=num1.charAt(i)-'0';
            for (int j=l2;j>=0;j--){
                int temp2=num2.charAt(j)-'0';
                int goo=res[i+j+1]+temp1*temp2;
                res[i+j+1]=goo%10;
                res[i+j]+=goo/10;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<res.length;i++){
            if(i==0&&res[i]==0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
