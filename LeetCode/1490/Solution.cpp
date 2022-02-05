class Solution {
public:
    Node* cloneTree(Node* root) {
        if(root == NULL)
            return root;
        
        if(root->children.size() == 0) {
            return new Node(root->val);
        }

        vector<Node*> newChildren;
        for(Node* children : root->children) {
            newChildren.push_back(cloneTree(children));
        }
        return new Node(root->val, newChildren);
    }
};

