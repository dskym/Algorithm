#include <iostream>

using namespace std;

typedef struct _NODE {
    bool finished;
    int childNum;
    struct _NODE* child[26];
} NODE;

NODE* createNode() {
    NODE* newNode = new NODE;

    newNode->finished = false;
    newNode->childNum = 0;

    for(int i=0;i<26;++i)
        newNode->child[i] = NULL;

    return newNode;
}

void insertNode(NODE* root, const char* str) {
    if(*str == '\0') {
        root->finished = true;

        return;
    }

    if(root->child[*str - 'a'] == NULL) {
        NODE* temp = createNode();
        root->child[*str - 'a'] = temp;
        root->childNum++;
    }

    insertNode(root->child[*str - 'a'], str+1);
}

int countNode(NODE* root, const char* str) {
    if(root->finished && *str == '\0')
        return 0;

    int count = 0;

    if(root->childNum > 1 || root->finished)
        count++;

    count += countNode(root->child[*str - 'a'], str+1);

    return count;
}

void deleteNode(NODE* root) {
    if(root == NULL)
        return;

    for(int i=0;i<26;++i) {
        if(root->child[i] != NULL) {
            deleteNode(root->child[i]);
        }
    }

    delete root;
}

int main() {
    int n;

    while(scanf("%d", &n) != EOF) {
        char s[100001][82];

        NODE* root = createNode();
        root->finished = true;

        for(int i=0;i<n;++i) {
            cin >> s[i];

            insertNode(root, s[i]);
        }

        double result = 0.0;

        for(int i=0;i<n;++i) {
                result += countNode(root, s[i]);
        }

        printf("%.2lf\n", result / n);

        deleteNode(root);
    }

    return 0;
}