/**
 * @Program:nowcoder
 * @description:报数
 * @Author:dlh
 * @Date:2019-09-06 11:00
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay cas=new CountAndSay();
        System.out.println(cas.countAndSay(1));
    }
    public String countAndSay(int n){
        String pre_person="1";
        for(int i=0;i<n;i++){
            String next_person="";
            String num="1";
            int count=0;
            for(int j=0;j<pre_person.length();j++){
                if(num.equals(pre_person.indexOf(j))){
                    count++;
                }else {
                    next_person.concat(String.valueOf(count));
                    next_person.concat(pre_person.valueOf(j));
                    count=1;
                }
                next_person.concat(String.valueOf(count));
                next_person.concat(String.valueOf(count));

            }
            pre_person=next_person;
        }
        return pre_person;
    }

}
