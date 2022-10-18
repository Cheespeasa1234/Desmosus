package src;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        String fixed = "-1+2";

    } 

    static String[] tokenize(String eq) {
        String curnum = "";
        ArrayList<String> tokens = new ArrayList<String>();
        for(int i = 0; i < eq.length(); i++) {
            if(isNum(eq.charAt(i))) {
                curnum+=eq.charAt(i);
            } else {
                tokens.add(curnum);
                curnum = "";
                tokens.add(eq.charAt(i));
            }
        }
    }

    static boolean isNum(char token) {
        return "1234567890.".indexOf(token) > -1;
    }

    static boolean isNone(String[] tokens, int index) {
        return index < 0 || index > tokens.length;
    }
    static boolean isOp(String[] tokens, int index) {
        String ops = "+-*/";
        return ops.indexOf(tokens[index].charAt(0)) > -1;
    }

    static String[] fixNegatives(String[] tokens) {
        for(int i = 0; i < tokens.length; i++) {
            if(tokens[i] == " ") {
                i++;
            } else if(isOp(tokens, i) && (isNone(tokens, i-1) || isOp(tokens, i-1))) {
                tokens = insert(tokens, "0", 0);
            }
        }
        return tokens;
    }

    static String[] insert(String[] list, String token, int index) {
        String[] aux = new String[list.length];
        for(int i = 0; i < aux.length; i++) {
            if(i == index) {
                aux[i] = token;
                i++;
            } else
                aux[i] =  list[i];
        }
        return aux;
    }
}
