class Solution {
public:
    Node* connect(Node* root) {
        queue<pair<Node*, int>> q;
        Node* before = NULL;
        int depth = 0;
        
        q.push({root, 0});
        
        while(!q.empty()) {
            auto t = q.front();
            q.pop();
            
            if(t.first == NULL)
                continue;
            
            if(depth != t.second) {
                before = NULL;
                depth++;
            }
            
            if(before != NULL) {
                (t.first)->next = before;
            }
           
            before = t.first;
            
            q.push({(t.first)->right, depth+1});
            q.push({(t.first)->left, depth+1});
        }
        return root;
    }
};
