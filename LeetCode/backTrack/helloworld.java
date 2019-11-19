import javafx.beans.binding.StringExpression;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.lang3.StringEscapeUtils;

import java.security.PublicKey;
import java.util.*;
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
        Pattern pattern=Pattern.compile("([a-zA-Z]?\\([0-9a-zA-Z],[0-9a-zA-Z]\\))");
        Matcher matcher=pattern.matcher("A(3,2)");
        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
