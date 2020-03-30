/**
 * @ Author:dlh
 * @ Date:2020/3/24--->14:46
 * @ Description:
 */
public class intToRoman {
    /**
     * int转罗马字符
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     字符          数值
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        String[] roman=new String[]{"","I","II","III","IV","V","VI","VII","VIII","IX",
                                    "","X","XX","XXX","XL","L","LX","LXX","LXXX","XC",
                                    "","C","CC","CCC","CD","D","DC","DCC","DCCC","CM",
                                    "","M","MM","MMM"};

        String ans="";
        int i=0;
        while (num>0){
            int temp=num%10;
            if(i==0){
                //个位
               ans=roman[temp].concat(ans);
            }
            if(i==1){
                //十位
                ans=roman[temp+10].concat(ans);
            }
            if(i==2){
                //百位
                ans=roman[temp+20].concat(ans);
            }
            if(i==3){
                //千位
                ans=roman[temp+30].concat(ans);
            }
            num=num/10;
            i++;
        }
        return ans;
    }
}
