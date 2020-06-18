
/**
 * @ Author:dlh
 * @ Date:2020/4/13--->21:01
 * @ Description:203323
 */
public class Main {
    public static void main(String[] args) {
        Main main=new Main();
        main.Insert('g');
        System.out.println(main.FirstAppearingOnce());
        main.Insert('o');
        System.out.println(main.FirstAppearingOnce());
        main.Insert('o');
        System.out.println(main.FirstAppearingOnce());

        main.Insert('g');
        System.out.println(main.FirstAppearingOnce());

        main.Insert('l');

        System.out.println(main.FirstAppearingOnce());
        main.Insert('e');
        System.out.println(main.FirstAppearingOnce());

    }
    int[] chars=new int[26];
    StringBuilder sb=new StringBuilder();
    public void Insert(char ch)
    {
        chars[ch-'a']++;
        sb=sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(int i=0;i<sb.length();i++){
            if(chars[sb.charAt(i)-'a']==1){
                return sb.charAt(i);
            }
        }
        return '#';
    }

}
