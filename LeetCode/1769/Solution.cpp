class Solution
{
public:
  vector<int> minOperations(string boxes)
  {
    vector<int> ret;
    int n = boxes.size();
    vector<int> left(n, 0);
    vector<int> right(n, 0);

    int count = 0;
    int totalCount = 0;

    for (int i = 0; i < n; ++i)
    {
      totalCount += count;

      left[i] = totalCount;

      if (boxes[i] == '1')
        count++;
    }

    count = 0;
    totalCount = 0;

    for (int i = n - 1; i >= 0; --i)
    {
      totalCount += count;

      right[i] = totalCount;

      if (boxes[i] == '1')
        count++;
    }

    for (int i = 0; i < n; ++i)
    {
      ret.push_back(left[i] + right[i]);
    }

    return ret;
  }
};