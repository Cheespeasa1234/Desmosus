package src;

import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        // System.out.println(new Desmosus("-1+2").equals());
        int[] a = {1,3,4};
        int b = a[3];
    } 

    static boolean isOp(String token) {
        String ops = "+-*/";
        return ops.indexOf(token.charAt(0)) > -1;
    }

    static String[] fixNegatives(String[] tokens) {
        for(int i = 0; i < tokens.length; i++) {
            if(isOp(tokens[i])) {

                if(isOp(1+"")){}

            }
        }
        return tokens;
    }

    static String[] insert(String[] list, String token, int index) {
        // String[] aux = new String[] list.length
        return list;
    }
}
