/**
 * Copyright (c) 2017 Qunar.com. All Rights Reserved.
 */
package javaweb.main;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jintao.wang Date: 17-11-10 Time: 上午10:52
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        regex_test();
    }

    private static void parseHtml() {
        String url = "www.baidu.com";
        Connection connection = Jsoup.connect(url);

    }

    private static void cluster() {
    }

    private static void regex(String patternStr, String string) {
        /*
         * String patternStr = "A{3,}?"; String string = "ACBDiowAAAAAaAAAAA";
         */
        System.out.println("patternStr=" + patternStr);
        System.out.println("string=" + string);
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(string);
        int groupCount = matcher.groupCount();
        System.out.println("before;regex;groupCount=" + groupCount);
        boolean b = false;
        int istart = 0, iend = 0;
        while ((b = matcher.find())) {
            istart = matcher.start();
            iend = matcher.end();
            String groupStr = matcher.group();
            System.out.println("istart=" + istart + ";iend = " + iend + ";group=" + groupStr);
            log.info("log;istart=" + istart + ";iend = " + iend + ";group=" + groupStr);
            istart = iend + 1;
        }
        groupCount = matcher.groupCount();
        System.out.println("after;regex;groupCount=" + groupCount);

    }

    private static void regex_group(String patternStr, String string) {
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(string);
        int grouptId = 1, groupCount = 0;
        while (matcher.find()) {
            groupCount = matcher.groupCount();
            for (grouptId = 0; grouptId <= groupCount; grouptId++) {
                String groupStr = matcher.group(grouptId);
                System.out.println("grouptId=" + grouptId + ";groupStr=" + groupStr);
            }

        }

    }

    private static void regex_test() {
        String[] regexStrArr = { "A{3,}", "A{3,}?" };
        String string = "ACBDiowAAAAAaAAAA";
        String[] strArr = null;
        String patternStr = null;
        int index = 0;
        log.info("log4j;void regex_test()");
        for (index = 0; index < regexStrArr.length; index++) {
            regex(regexStrArr[index], string);

        }
        /**/
        System.out.println("---------");
        string = "This is a text!!";
        patternStr = "This\\s+is\\s+a\\s+text";
        regex(patternStr, string);

        /**/
        System.out.println("++++++++");
        patternStr = "\\d+(\\.\\d+)?";
        strArr = new String[] { "23442502", "036", "-535.45", "9.009410" };
        for (index = 0; index < strArr.length; index++) {
            regex(patternStr, strArr[index]);
        }
        /* 捕获组 */
        System.out.println("按指定模式在字符串查找 ");
        string = "This order was placed for QT3000! OK?-54.645";
        patternStr = "((\\D*)(\\d+))(\\D*)";
        regex_group(patternStr, string);

    }

}
