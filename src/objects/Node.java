package objects;

import Desmosus.src.objects.*;

public class Node {

    Token value;
    Node left;
    Node right;

    Node(Token value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

}
