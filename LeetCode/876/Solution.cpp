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
    ListNode* middleNode(ListNode* head) {
        int size = 0;
        
        ListNode* temp = head;
        
        while(temp) {
            size++;
            temp = temp->next;
        }
        
        int count = 0;
        
        while(true) {
            if(size / 2 == count)
                return head;

            head = head->next;
            count++;
        }
    }
};
