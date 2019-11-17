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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        stack<int> s1, s2;
        
        ListNode* temp = l1;
        
        while(temp) {
            s1.push(temp->val);
            temp=temp->next;
        }
        
        temp = l2;
        
        while(temp) {
            s2.push(temp->val);
            temp=temp->next;
        }
        
        ListNode* head = NULL;
        
        int carry = 0;
        
        while(!s1.empty() && !s2.empty()) {
            int t1 = s1.top();
            int t2 = s2.top();
            
            s1.pop();
            s2.pop();
            
            ListNode* newNode = new ListNode((t1 + t2 + carry) % 10);
            newNode->next = head;
            
            head = newNode;
            
            carry = (t1 + t2 + carry) / 10;
        }
        
        while(!s1.empty()) {
            int t1 = s1.top();
            s1.pop();
            
            ListNode* newNode = new ListNode((t1 + carry) % 10);
            newNode->next = head;     
            
            head = newNode;
            
            carry = (t1 + carry) / 10;
        }

        while(!s2.empty()) {
            int t2 = s2.top();
            s2.pop();
            
            ListNode* newNode = new ListNode((t2 + carry) % 10);
            newNode->next = head;     
            
            head = newNode;
            
            carry = (t2 + carry) / 10;
        }
        
        if(carry) {
            ListNode* newNode = new ListNode(carry);
            newNode->next = head;     
            
            head = newNode;
        }
        
        return head;
    }
};
