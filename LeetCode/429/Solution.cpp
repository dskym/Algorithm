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
    vector<int> result[1001];
    
    void solve(Node* node, int depth) {
        if(node == NULL)
            return;
        
        result[depth].push_back(node->val);
        
        for(Node* c : node->children)
            solve(c, depth+1);
    }
    
    vector<vector<int>> levelOrder(Node* root) {
        solve(root, 0);
        
        vector<vector<int>> r;
        
        for(int i=0;i<1001;++i)
            if(result[i].size())
                r.push_back(result[i]);
        
        return r;
    }
};
