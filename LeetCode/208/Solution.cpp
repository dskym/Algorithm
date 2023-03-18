class Trie {
public:
    char value;
    vector<Trie*> nodes;
    bool end;

    Trie() {
        value = '-';
        nodes = vector<Trie*>(26);
        end = false;
    }
    
    void insert(string word) {
        Trie* tries = this;
        for(char c : word) {
            int index = c - 'a';

            if(tries->nodes[index] == NULL) {
                Trie* trie = new Trie();
                trie->value = c;

                tries->nodes[index] = trie;
            }

            tries = tries->nodes[index];
        }
        tries->end = true;
    }
    
    bool search(string word) {
        Trie* tries = this;
        for(char c : word) {
            int index = c - 'a';

            if(tries->nodes[index] == NULL) {
                return false;
            }

            tries = tries->nodes[index];
        }
        return tries->end;
    }

    bool startsWith(string prefix) {
        Trie* tries = this;
        for(char c : prefix) {
            int index = c - 'a';

            if(tries->nodes[index] == NULL) {
                return false;
            }

            tries = tries->nodes[index];
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
