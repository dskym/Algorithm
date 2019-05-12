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
                
        for(Node* node : root->children)
            solve(node, result);

        result.push_back(root->val);
    }
    
    vector<int> postorder(Node* root) {
        vector<int> result;

        solve(root, result);
        
        return result;
    }
};
