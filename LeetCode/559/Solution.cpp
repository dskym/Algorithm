/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
public:
    int solve(Node* root) {
        if(root == NULL)
            return 1;
        
        int result = 1;
        
        for(Node* node : root->children) {
            result = max(result, solve(node) + 1);
        }
        
        return result;
    }
    
    int maxDepth(Node* root) {
        if(root)
            return solve(root);
        else
            return 0;
    }
};
