class BrowserHistory {
public:
    stack<string> backwardStack;
    stack<string> forwardStack;
    string cur;
    BrowserHistory(string homepage) {
        cur = homepage;
    }
    
    void visit(string url) {
        backwardStack.push(cur);
        while(!forwardStack.empty())
            forwardStack.pop();
        cur = url;
    }
    
    string back(int steps) {
        for(int i=0;i<steps;++i) {
            if(backwardStack.empty())
                break;
            forwardStack.push(cur);
            cur = backwardStack.top();
            backwardStack.pop();
        }        
        return cur;
    }
    
    string forward(int steps) {
        for(int i=0;i<steps;++i) {
            if(forwardStack.empty())
                break;
            backwardStack.push(cur);
            cur = forwardStack.top();
            forwardStack.pop();
        }        
        return cur;
    }
};
