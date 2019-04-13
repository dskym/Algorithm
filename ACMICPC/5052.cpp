#include <iostream>

using namespace std;

typedef struct _NODE {
    bool finished;
    struct _NODE* child[10];
} NODE;

NODE* createNode() {
    NODE* newNode = new NODE;

    newNode->finished = false;
    
    for(int i=0;i<10;++i)
        newNode->child[i] = NULL;

    return newNode;
}

void insertNode(NODE* root, const char* str) {
    if(*str == '\0') {
        root->finished = true;

        return;
    }

    if(root->child[*str-'0'] == NULL)
        root->child[*str-'0'] = createNode();

    insertNode(root->child[*str-'0'], str+1);    
}

bool findNode(NODE* root, const char* str) {
    if(*str == '\0')
        return true;

    if(root->finished)
        return false;

    return findNode(root->child[*str-'0'], str+1);
}

int main() {
    int t;

    cin >> t;

    for(int i=0;i<t;++i) {
        int n;
        char phone[10001][11];
        
        cin >> n;

        NODE* root = createNode();

        for(int j=0;j<n;++j) {
            cin >> phone[j];

            insertNode(root, phone[j]);
        }

        bool check = false;

        for(int j=0;j<n;++j) {
            check = findNode(root, phone[j]);

            if(!check) {
                cout << "NO" << endl;

                break;
            }
        }

        if(check)
            cout << "YES" << endl;
    }

    return 0;
}