import java.util.Arrays;

/**
 * @ Author:dlh
 * @ Date:2020/3/27--->8:07
 * @ Description:
 */
public class hasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        if(deck.length<2){
            return false;
        }
        int count=1;
        for(int i=1;i<deck.length-1;i++){
            if(deck[i]==deck[i-1]){
                count++;
            }else {
                break;
            }
        }
        for(int i=0;i<deck.length;i+=count){
            for(int j=i;j<count+i&&j<deck.length;j++){
                if(deck[i]==deck[j]){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
