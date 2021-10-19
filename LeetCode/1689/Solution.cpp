class Solution
{
public:
  int minPartitions(string n)
  {
    char ret = '0';

    for (int i = 0; i < n.size(); ++i)
    {
      ret = ret < n[i] ? n[i] : ret;
    }

    return ret - '0';
  }
};
