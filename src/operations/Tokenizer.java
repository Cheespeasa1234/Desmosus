package Desmosus.src.operations;
import java.util.ArrayList;

import Desmosus.src.objects.Token;
import Desmosus.src.objects.TokenType;

public class Tokenizer {

    public static Token[] tokenize(String input) {
        ArrayList<Token> tokens = new ArrayList<Token>();
        String formingNumber = "";

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Token.charIsDigit(c)) {
                formingNumber += c;
            } else if(Token.charIsOperator(c)) {
                if(!formingNumber.equals(""))
                    tokens.add(new Token(formingNumber, TokenType.NUMBER));
                tokens.add(new Token(c+"", TokenType.OPERATOR));
                formingNumber = "";
            } else if(Token.charIsWhitespace(c)) {
                if(!formingNumber.equals(""))
                tokens.add(new Token(formingNumber, TokenType.NUMBER));
                formingNumber = "";
            } else { // is a variable
                if(!formingNumber.equals(""))
                    tokens.add(new Token(formingNumber, TokenType.NUMBER));
                tokens.add(new Token(c+"", TokenType.VARIABLE));
                formingNumber = "";
            }
        }

        if(!formingNumber.equals(""))
            tokens.add(new Token(formingNumber, TokenType.NUMBER));

        Token[] arr = new Token[tokens.size()];
        for(int i = 0; i < tokens.size(); i++) 
            arr[i] = tokens.get(i);
        
        return arr;
    }

}
