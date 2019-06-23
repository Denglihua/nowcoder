/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-06-01 19:01
 **/
public class topic_01 {
    public static void main(String[] args) {
        topic_01 tp=new topic_01();
        System.out.println(tp.getSY(20));
    }
    public int getSY(int x){
        int res=0;
        int i=1;
        while (x>-1){
            res=x;
            x=x-i;
            i++;
        }
        return res;
    }
}
