package src.objects;

public class Token {

    
    public String value;
    public TokenType type;
    public Token(String value, TokenType type) {
        this.value = value;
        this.type = type;
    }

    public double parseDouble() {
        // guard clauses
        if(this.type != TokenType.NUMBER)
            throw new IllegalAccessError("Cannot parse as a number, this is a " + type + ".");
        
        return Double.parseDouble(this.value);

    }

    public String toString() {
        return this.value;
    }

    public static char[] operators = "+-*/()".toCharArray();
    public static char[] digits = "1234567890.,".toCharArray();
    public static char[] whitespaces = " \n\t".toCharArray();

    public static boolean charIsDigit(char c) {
        for(char dg: digits)
            if(c == dg)
                return true;
        return false;
    }

    public static boolean charIsOperator(char c) {
        for(char op: operators)
            if(c == op)
                return true;
        return false;
    }

    public static boolean charIsWhitespace(char c) {
        for(char ws: whitespaces)
            if(c == ws)
                return true;
        return false;
    }


}
