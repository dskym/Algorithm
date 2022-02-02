class Solution {
public:
    void solve(ImmutableListNode* temp) {
        if(temp == NULL)
            return;
        
        solve(temp->getNext());
        temp->printValue();
    }
    void printLinkedListInReverse(ImmutableListNode* head) {
        solve(head);
    }
};
