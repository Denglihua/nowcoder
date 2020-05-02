
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: nowcoder
 * @description:
 * @author: denglihua
 * @create: 2019-06-17 19:04
 **/
public class helloworld {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("(lg\\([a-z]_[a-zA-Z0-9]\\))");
        Matcher matcher=pattern.matcher("lg(a_n)");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
