package ru.javastudy.hibernate.validater;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {

    private static final String regexp = "\\d{1,2}";
    private static Pattern pattern;
    private static Matcher matcher;

    public PasswordValidator() {
        pattern = Pattern.compile(regexp);
    }

    public static boolean validate(String passs) {
        System.out.println("fdf");
        System.out.println(pattern.matcher(passs).matches());
        return pattern.matcher(passs).matches();
       //return matcher.matches();
    }


}
