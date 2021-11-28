/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* mergeInBetween(ListNode* list1, int a, int b, ListNode* list2) {
        ListNode* tail = list2;
        while(tail -> next) {
            tail = tail -> next;
        }
        
        ListNode* prev = NULL;
        ListNode* curr = list1;
        
        int count = 0;
        while(curr) {
            if(count == a) {
                prev->next = list2;
            } else if(count == b+1) {
                tail->next = curr;
            }
            
            prev = curr;
            curr = curr->next;
            count++;
        }
        
        return list1;
    }
};
