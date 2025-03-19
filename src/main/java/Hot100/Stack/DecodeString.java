package Hot100.Stack;

import java.util.Collections;
import java.util.LinkedList;

public class DecodeString {
    int cur;
    public String decodeString(String s) {
        int n = s.length();
        cur = 0;
        LinkedList<String> stack = new LinkedList<>();
        while (cur < n) {
            if (Character.isDigit(s.charAt(cur))) {
                stack.add(getDigits(s));
            }else if (Character.isLetter(s.charAt(cur)) || s.charAt(cur) == '['){
                stack.add(String.valueOf(s.charAt(cur)));
                cur ++;
            }else {
                cur ++;
                LinkedList<String> tmpLinkedList = new LinkedList<>();
                while (!stack.isEmpty() && !stack.peekLast().equals("[")) {
                    tmpLinkedList.add(stack.removeLast());
                }
                Collections.reverse(tmpLinkedList);
                String tmpString = getString(tmpLinkedList);
                stack.removeLast();
                int times = Integer.parseInt(stack.removeLast());
                StringBuilder sb = new StringBuilder();
                while (times -- > 0) {
                    sb.append(tmpString);
                }
                stack.add(sb.toString());
            }
        }
        return getString(stack);
    }

    public String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(cur))) {
            sb.append(s.charAt(cur));
            cur ++;
        }
        return sb.toString();
    }

    public String getString(LinkedList<String> v){
        StringBuilder sb = new StringBuilder();
        for (String s : v) {
            sb.append(s);
        }
        return sb.toString();
    }
}
