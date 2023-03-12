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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode* ret = new ListNode();
        ListNode* temp = ret;
        while(true) {
            bool flag = true;
            int val = 100000;
            int index = 0;
            for(int i=0;i<lists.size();++i) {
                if(lists[i] == NULL) {
                    continue;
                }
                if(val > lists[i]->val) {
                    val = lists[i]->val;
                    index = i;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
            temp->next = new ListNode(lists[index]->val);
            temp = temp->next;
            lists[index] = lists[index]->next;
        }
        return ret->next;
    }
};
