import java.util.Random;

/**
 * @program: nowcoder
 * @description: 随机生成一个字符串，判断是不是回文数
 * @author: dlh
 * @create: 2019-01-04 15:15
 **/
public class NumberOfTracts {
    public static void main(String[] args) {
        NumberOfTracts not=new NumberOfTracts();
        String aa=not.CreatRandomString(10);
        String ss="aba";
        System.out.println(aa);
        System.out.println(not.isTracts(ss));
        System.out.println(not.isTracts(aa));

    }
    //随机生成一个长度为length的字符串
    public static String CreatRandomString(int length)
    {
        String str="abcdefghijilmnopqrstuvwxyzABCDEFGHIJiLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++)
        {
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    //判断一个字符串是不是回文数
    public boolean isTracts(String str)
    {
        int low=0;
        int high=str.length()-1;
        while (low<high)
        {
            if(str.charAt(low)!=str.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
