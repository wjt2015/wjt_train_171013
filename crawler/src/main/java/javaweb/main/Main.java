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
 * @author jintao.wang  Date: 17-11-10 Time: 上午10:52
 */
@Slf4j
public class Main {
    public static void main(String[] args){
        regex_test();
    }

    private static void parseHtml(){
        String url = "www.baidu.com";
        Connection connection = Jsoup.connect(url);

    }

    private static void cluster(){
    }

    private static void regex(String patternStr,String string){
/*        String patternStr = "A{3,}?";
        String string = "ACBDiowAAAAAaAAAAA";*/
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(string);
        boolean b = false;
        int istart = 0,iend = 0;
        while ((b=matcher.find())){
            istart = matcher.start();
            iend = matcher.end();
            String groupStr = matcher.group();
            System.out.println("istart=" + istart + ";iend = " + iend + ";group=" + groupStr);
            log.info("log;istart=" + istart + ";iend = " + iend + ";group=" + groupStr);
            istart = iend + 1;
        }

    }

    private static void regex_test(){
        String[] regexStrArr = {"A{3,}","A{3,}?"};
        String string = "ACBDiowAAAAAaAAAAA";
        int index = 0;
        log.info("log4j;void regex_test()");
        for (index = 0;index < regexStrArr.length;index++){
            regex(regexStrArr[index],string);

        }
    }

}
    