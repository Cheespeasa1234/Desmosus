package src;

import src.objects.Token;
import src.operations.Tokenizer;

public class Main {
    public static void main(String[] args) {
        Token[] tokens = Tokenizer.tokenize("3.8+2 * 231");
        printArray(tokens);
    }

    public static void printArray(Object[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length-1] + "]");
    }
}
