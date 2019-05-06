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
    ListNode* solve(ListNode* head) {
        if(head->next == NULL)
            return head;
        
        ListNode* temp = solve(head->next);
        
        ListNode* t = temp;
        
        while(t->next)
            t = t->next;
        
        t->next = head;
        head->next = NULL;
        
        return temp;
    }

    ListNode* reverseList(ListNode* head) {
        if(head)
            return solve(head);
        else
            return NULL;
    }
};
