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
    ListNode *detectCycle(ListNode *head) {
        ListNode* temp = head;
        while(temp != NULL && temp->val <= 100000) {
            if(temp->next != NULL && temp->next->val > 500000) {
                return temp->next;
            }
            temp->val += 1000000;
            temp = temp->next;
        }
        return temp == NULL ? NULL : temp;
    }
};
