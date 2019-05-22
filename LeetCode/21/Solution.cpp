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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* temp = new ListNode(0);
        
        ListNode* result = temp;

        while(l1 != NULL && l2 != NULL) {
            if(l1->val > l2->val) {
                result->next = new ListNode(l2->val);
                l2 = l2->next;
            } else {
                result->next = new ListNode(l1->val);
                l1 = l1->next;
            }   
            
            result = result->next;
        }
        
        while(l1 != NULL) {
                result->next = new ListNode(l1->val);
                result = result->next;
                l1 = l1->next;
        }

        while(l2 != NULL) {
                result->next = new ListNode(l2->val);
                result = result->next;
                l2 = l2->next;
        }
        
        return temp->next;
    }
};
