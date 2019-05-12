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
    void solve(Node* root, vector<int> &result) {
        if(root == NULL)
            return;
        
        result.push_back(root->val);
        
        for(Node* node : root->children)
            solve(node, result);
    }
    
    vector<int> preorder(Node* root) {
        vector<int> result;

        solve(root, result);
        
        return result;
    }
};
