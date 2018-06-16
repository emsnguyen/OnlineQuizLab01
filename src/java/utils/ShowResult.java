/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author lenovo
 */
public class ShowResult {
    public static float getResult(int mark, int total) {
        float result = (float) mark/total * 10;
        return result;
    }
    public static String getStringResult(float result) {
        if (result < 5) {
            return "Failed";
        } else {
            return "Passed";
        }
    }
}
