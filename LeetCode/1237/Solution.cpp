/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 * public:
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     int f(int x, int y);
 * };
 */

class Solution {
public:
    vector<vector<int>> findSolution(CustomFunction& customfunction, int z) {
        vector<vector<int>> result;
        for(int x=1;x<=1000;++x) {
            int l = 1, r = 1000;
            while(l <= r) {
                int mid = (l + r) / 2;

                int temp = customfunction.f(x, mid);
                if(temp == z) {
                    result.push_back({x, mid});
                    break;
                }
                else if(temp < z)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return result;
    }
};
