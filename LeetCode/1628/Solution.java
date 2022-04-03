/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
    public String val;
    public Node left;
    public Node right;
};

class OperNode extends Node {
    public int evaluate() {
        if("+".equals(val)) {
            return left.evaluate() + right.evaluate();
        } else if("-".equals(val)) {
            return left.evaluate() - right.evaluate();
        } else if("*".equals(val)) {
            return left.evaluate() * right.evaluate();
        } else if("/".equals(val)) {
            return left.evaluate() / right.evaluate();
        } else {
            return 0;
        }
    }
};

class NumNode extends Node {
    public int evaluate() {
        return Integer.parseInt(val);
    }
};

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Node buildTree(String[] postfix) {
        Stack<Node> stack = new Stack<>();
        for(String s : postfix) {
            if("+".equals(s) || "-".equals(s) || "*".equals(s) || "/".equals(s)) {
                Node right = stack.pop();
                Node left = stack.pop();

                Node node = new OperNode();
                node.left = left;
                node.right = right;
                node.val = s;
                stack.push(node);
            } else {
                Node node = new NumNode();
                node.val = s;
                stack.push(node);
            }
        }         
        return stack.peek();
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
