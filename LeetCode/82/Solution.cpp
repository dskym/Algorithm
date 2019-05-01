
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* node = new ListNode(0);
        node->next = head;
        
        ListNode* temp = node;
        
        while(temp) {
            ListNode* curr = temp;
            bool flag = false;
            
            while(curr->next != NULL && curr->next->next != NULL && curr->next->val == curr->next->next->val) {
                curr->next = curr->next->next;
                flag = true;
            }
            
            if(flag)
                temp->next = curr->next->next;
            else
                temp = temp->next;
        }
        
        return node->next;
    }
};
