#include <iostream>
#include <vector>
#include <algorithm>
#include <set>

using namespace std;

struct Pair
{
    long long i, j;

    Pair(long long x, long long y) : i(x), j(y) {}

    bool operator<(const Pair &other) const
    {
        return i < other.i || (i == other.i && j < other.j);
    }
};

int main()
{
    int t;
    cin >> t;
    while (t--)
    {

        int n;
        cin >> n;

        vector<Pair> arr;
        for (int i = 0; i < n; i++)
        {
            long long x, y;
            cin >> x >> y;
            arr.push_back(Pair(x, 1e10));
            arr.push_back(Pair(y, x));
        }

        sort(arr.begin(), arr.end());

        set<long long> s;
        long long count = 0;
        for (const Pair &p : arr)
        {
            if (p.j == 1e10)
            {
                s.insert(p.i);
            }
            else
            {
                count += distance(s.begin(), s.lower_bound(p.j));
                s.erase(p.j);
            }
        }

        cout << count << endl;
    }
    return 0;
}
