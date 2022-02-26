class Solution {
public:
    ListNode* mergeNodes(ListNode* head) {
        ListNode* ret = new ListNode();
        
        int tempVal = 0;
        ListNode* temp = head;
        ListNode* r = ret;
        while(true) {
            temp = temp->next;

            if(temp == NULL)
                break;

            tempVal += temp->val;

            if(temp->val == 0) {
                r->next = new ListNode(tempVal);
                r = r->next;
                tempVal = 0;
            }
        }
        
        return ret->next;
    }
};
