class Solution {
public:
    int pairSum(ListNode* head) {
        int size = 0;
        ListNode* temp = head;
        while(temp) {
            size++;
            temp = temp->next;
        }

        vector<int> ret(size/2, 0);
        temp = head;
        int index=0;
        while(temp) {
            if(index < size / 2)
                ret[index] += temp->val;
            else
                ret[size-index-1] += temp->val;
            temp=temp->next;
            index++;
        }
        
        int r = 0;
        for(int t : ret) {
            if(r < t)
                r = t;
        }
        return r;
    }
};
