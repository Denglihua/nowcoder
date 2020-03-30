import java.util.ArrayList;
import java.util.List;

/**
 * @ Author:dlh
 * @ Date:2020/3/28--->10:12
 * @ Description:
 */
public class minimumLengthEncoding {
    public int minimumLengthEncoding(String[] words) {
        String s="";
        List<String> wordsList=new ArrayList<>();
        for(int i=0;i<words.length;i++){
            wordsList.add(words[i]);
        }
        int i=0;
        while (i<wordsList.size()){
            for(int j=i+1;j<wordsList.size();j++){
                if(wordsList.get(i).contains(wordsList.get(j))&&wordsList.get(i).charAt(wordsList.get(i).length()-1)==
                        wordsList.get(j).charAt(wordsList.get(j).length()-1)&&!(i==j)){
                    wordsList.remove(j);
                    i--;
                    break;
                }
                else if(wordsList.get(j).contains(wordsList.get(i))&&wordsList.get(i).charAt(wordsList.get(i).length()-1)==
                        wordsList.get(j).charAt(wordsList.get(j).length()-1)&&!(i==j)){
                    wordsList.remove(i);
                    i--;
                    break;
                }
                else {
                    continue;
                }
            }
            i++;
        }

        for(int k=0;k<wordsList.size();k++){
            s=s.concat(wordsList.get(k)+"#");
        }
        return s.length();
    }
}
