package javaLanguage;

import java.util.TimeZone;

public class TimezoneTry {
    public static void main(String[] args) {
//        ZoneInfo
        TimeZone tz = TimeZone.getTimeZone("Europe/Vilnius");
        String[] tzones = TimeZone.getAvailableIDs(tz.getRawOffset());
        for (String s : tzones) {
            System.out.println(s);
        }
    }
}