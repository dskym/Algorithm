/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
typedef struct _NODE {
    int index;
    int val;
} NODE;

class Solution {
public:
    vector<int> nextLargerNodes(ListNode* head) {
        stack<NODE> s;

        int count = 0;
        
        ListNode* temp = head;
        
        while(temp) {
            count++;
            temp = temp->next;
        }
        
        vector<int> result(count, 0);
        int index = 0;
        
        temp = head;
                
        while(temp) {            
            while(!s.empty()) {
                NODE data = s.top();
                
                if(data.val < temp->val) {
                    result[data.index] = temp->val;
                    s.pop();
                } else
                    break;
            }             
            
            s.push({index, temp->val});
            
            index++;
            temp = temp->next;
        }
        
        return result;
    }
};
