/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.regex.Pattern;

public class InputValidator {

    public static String isValidString(String str, int min, int max, String fieldName) {
        if (str == null || str.length() == 0) {
            return fieldName + " must not be empty";
        }
        if (str.length() < min || str.length() > max) {
            return fieldName + " must be between " + min + " and " + max + " characters";
        }
        if (str.startsWith(" ") || str.startsWith("[^a-zA-Z_]+")) {
            return fieldName + " must start with a character or _ only"; 
        }
        return "";
    }

    public static String isValidPassword(String password) {
        String checkString = isValidString(password, 8, 30, "Password");
        if (!checkString.equals("")) {
            return checkString;
        }
        Pattern upper = Pattern.compile("[A-Z]");
        if (!upper.matcher(password).find()) {
            return "Password must contain at least an uppercase letter";
        }
        Pattern lower = Pattern.compile("[a-z]");
        if (!lower.matcher(password).find()){
            return "Password must contain at least a lowercase letter";
        }
        Pattern digits = Pattern.compile("[0-9]");
        if (!digits.matcher(password).find()) {
            return "Password must contain at least a number";
        }
        Pattern specialChars = Pattern.compile("[#@$%!_]");
        if (!specialChars.matcher(password).find()) {
            return "Password must contain at least a special character";
        }
        return "";
    }
    public static String isValidEmail(String email) {
        String checkString = isValidString(email, 8, 30, "Email");
        if (!checkString.equals("")) {
            return checkString;
        }
        if (!email.contains("@")) {
            return "Email must contain at least an @";
        }
        if (email.indexOf("@") != email.lastIndexOf("@")) {
            return "Email must not contain two or more @s";
        }
        Pattern p = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if (!p.matcher(email).find()) {
            return "Email is not in standard format";
        }
        return "";
        
    }
}
