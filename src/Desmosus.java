package src;

import java.util.ArrayList;
import java.util.List;

public class Desmosus {

    public static void main(String[] args) {
        Desmosus d = new Desmosus();
        ArrayList<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list = d.replace(2, 4, "N", list);
        d.printArray("LIST: ", list);

        d.run();
    }

    void run() {

        ArrayList<String> a = tokenize("3+2+3.3*231");
        double solution = solve(a);
        System.out.println("SOLVED: " + solution);

    }

    void printArray(String pre, List<String> a) {
        System.out.print(pre + "[ ");
        a.forEach((n) -> {
            System.out.print(n + ", ");
        });
        System.out.println("]");
    }

    double solve(ArrayList<String> tokens) {

        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals("@O*")) {
                double a = toDouble(tokens.get(i - 1));
                double b = toDouble(tokens.get(i + 1));
                double c = a * b;
                tokens = replace(i, i + 2, "@N" + c, tokens);
            } else if (token.equals("@O/")) {
                double a = toDouble(tokens.get(i - 1));
                double b = toDouble(tokens.get(i + 1));
                double c = a / b;
                tokens = replace(i, i + 2, "@N" + c, tokens);
            }
        }
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            if (token.equals("@O+")) {
                double a = toDouble(tokens.get(i - 1));
                double b = toDouble(tokens.get(i + 1));
                double c = a + b;
                tokens = replace(i, i + 2, "@N" + c, tokens);
            } else if (token.equals("@O-")) {
                double a = toDouble(tokens.get(i - 1));
                double b = toDouble(tokens.get(i + 1));
                double c = a - b;
                tokens = replace(i, i + 2, "@N" + c, tokens);
            }
        }    

        double r = toDouble(tokens.get(0));
        if(tokens.size() > 1) {
            r = solve(tokens);
        }
        return r;

    }

    ArrayList<String> tokenize(String equation) {

        ArrayList<String> tokens = new ArrayList<String>();
        String currentNumber = "@N";
        String validDigits = "1234567890.";

        for (int i = 0; i < equation.length(); i++) {
            if (validDigits.indexOf(equation.charAt(i)) > -1) {
                currentNumber += equation.charAt(i);
            } else {
                tokens.add(currentNumber);
                currentNumber = "@N";
                tokens.add("@O" + equation.charAt(i));
            }
        }

        if (!currentNumber.equals("")) {
            tokens.add(currentNumber);
        }

        return tokens;

    }

    String sanitizeString(String str) {
        return str.replaceAll(" ", "");
    }

    ArrayList<String> replace(int min, int max, String token, ArrayList<String> list) {
        for(int i = min; i < max; i++) {
            list.set(i, "");
        }
        for(int i = min; i < max; i++) {
            list.remove("");
        }
        ArrayList<String> aux = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++) {
            aux.add(list.get(i));
            if(i == min - 1)
                aux.add(token);
        }
        return aux;
    }

    double toDouble(String token) {
        return Double.parseDouble(token.substring(2));
    }

}