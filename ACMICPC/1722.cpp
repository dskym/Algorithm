#include <iostream>
#include <vector>

using namespace std;

int main() {
	int n;

	cin >> n;

	int type;

	cin >> type;

	if(type == 1) {
		long long int order;

		cin >> order;

		long long int fact[21];
		int nums[21];
		bool valid[21];
		vector<int> result;

		long long int val = 1;

		for(int i=1;i<=n;++i) {
			val *= i;
			fact[i] = val;
		}

		for(int i=0;i<n;++i) {
			nums[i] = i+1;
			valid[i] = false;
		}

		bool reverse = false;

		for(int i=n-1;i>=0;--i) {
			long long int temp = order / fact[i];
			order %= fact[i];

			if(order != 0) {
				for(int j=0;j<n;++j) {
					if(valid[j] == true)
						continue;
					
					if(temp == 0) {
						result.push_back(nums[j]);
						valid[j] = true;
					}

					temp--;
				}
			} else {
				for(int j=0;j<n;++j) {
					if(valid[j] == true)
						continue;
					
					if(temp == 1) {
						result.push_back(nums[j]);
						valid[j] = true;
					}

					temp--;
				}
			}

			if(order == 0) {
				reverse = true;
				break;
			} else if(order == 1)
				break;
		}

		if(reverse == false) {
			for(int i=0;i<n;++i) {
				if(valid[i] == false) {
					result.push_back(nums[i]);
				}
			}
		} else {
			for(int i=n-1;i>=0;--i) {
				if(valid[i] == false) {
					result.push_back(nums[i]);
				}
			}
		}
		
		for(int i=0;i<n;++i) {
			cout << result[i] << " ";
		}

		cout << endl;
	} else {
		int p[21];

		for(int i=0;i<n;++i)
			cin >> p[i];

		long long int fact[21];

		long long int val = 1;

		for(int i=1;i<=n;++i) {
			val *= i;
			fact[i] = val;
		}

		bool valid[21];

		for(int i=0;i<n;++i)
			valid[i] = false;
	
		long long int result = 1;

		for(int i=0;i<n;++i) {
			int count = 0;

			for(int j=0;j<i;++j) {
				if(p[i] > p[j])
					count++;
			}

			result += (p[i]-count-1) * fact[n-1-i];
		}

		cout << result << endl;
	}

	return 0;
}