/**
 * @ Author:dlh
 * @ Date:2020/6/3--->15:42
 * @ Description:请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * 未解决
 */
public class Numberic {
    public static boolean isNumeric(char[] str) {
        if(str.length==0){
            return false;
        }
        int n=str.length;
        //首位不能是<'.','e'> 最后一位不能是<'.','+','-','e'>
        if(str[0]=='.'||str[0]=='e'||str[n-1]=='.'||str[n-1]=='e'||str[n-1]=='+'||str[n-1]=='-'){
            return false;
        }
        boolean e=false;
        boolean point=false;
        boolean plusOrminus=false;
        for(int i=1;i<n-1;i++){
            if(str[i]>='0'&&str[i]<='9'){
                continue;
            }else if(str[i]=='e'&& e==false){
                if((str[i-1]>='0'&&str[i-1]<='9')&&((str[i+1]>='0'&&str[i+1]<='9')||(str[i+1]=='-')||(str[i+1]=='+'))){
                    e=true;
                    continue;
                }else{
                    return false;
                }
            }else if(str[i]=='.'&& point==false){
                if((str[i-1]>='0'&&str[i-1]<='9')&&(str[i+1]>='0'&&str[i+1]<='9')||(str[i-1]=='-')||(str[i-1]=='+')){
                    point=true;
                    continue;
                }else{
                    return false;
                }
            }else if(str[i]=='+'||str[i]=='-'){
                if(str[i-1]=='e'&& plusOrminus==false){
                    plusOrminus=true;
                    continue;
                }else{
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric(new char[]{'1','.','2', '3','e','+', '5'}));
    }
}
