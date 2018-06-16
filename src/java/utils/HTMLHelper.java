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
public class HTMLHelper {
    public static String generateHyperlink(int value, String displayText) {
        String hyperLink = "<a href=\"managequiz?pageIndex="+value+"\">"+displayText+"</a>";
        return hyperLink;
    }
    public static String paging(int totalPage, int pageGap, int currentPage) {
        String result = "";
        if (currentPage > pageGap) {
            result += generateHyperlink(1, "First");
        }
        for (int i = Math.max(currentPage-pageGap, 1); i < currentPage; i++) {
            result += generateHyperlink(i, "" + i);
        }
        result += "<a class=\"currentPage\">"+currentPage+"</a>";
        for (int i = currentPage+1; i < Math.min(currentPage+pageGap, totalPage); i++) {
            result += generateHyperlink(i, "" + i);
        }
        if (currentPage + pageGap < totalPage) {
            result += generateHyperlink(totalPage, "Last");
        }
        return result;
    }
}
