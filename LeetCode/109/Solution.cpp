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
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* solve(ListNode* head, int start, int end) {
        if(head == NULL || start > end) {
            return NULL;
        }

        if(start == end) {
            return new TreeNode(head->val);
        }

        int mid = (start+end)/2;
        ListNode* temp = head;
        for(int i=start;i<mid;++i) {
            temp = temp->next;
        }

        TreeNode* root = new TreeNode(temp->val);
        TreeNode* left = solve(head, start, mid-1);
        TreeNode* right = solve(temp->next, mid+1, end);

        root->left = left;
        root->right = right;

        return root;
    }
    TreeNode* sortedListToBST(ListNode* head) {
        int count = 0;
        ListNode* temp = head;
        while(temp != NULL) {
            temp = temp->next;
            count++;
        }

        return solve(head, 0, count-1);
    }
};
