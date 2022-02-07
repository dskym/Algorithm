class Cashier {
public:
    int count;
    int base;
    int d;
    map<int, int> m;
    Cashier(int n, int discount, vector<int>& products, vector<int>& prices) {
        count = 0;
        base = n;
        d = discount;
        for(int i=0;i<products.size();++i) {
            m.insert({products[i], prices[i]});
        }
    }
    
    double getBill(vector<int> product, vector<int> amount) {
        count++;
        double total = 0.0;
        for(int i=0;i<product.size();++i) {
            total += m[product[i]] * amount[i];
        }
        return count % base == 0 ? total * ((100 - d) / 100.0) : total;
    }
};
