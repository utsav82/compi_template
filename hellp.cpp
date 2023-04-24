
#include <bits/stdc++.h>
using namespace std;
#define ll long long
#define int long long
signed main()
{
    int t;
    cin >> t;
    while (t--)
    {

        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++)
        {
            cin >> a[i];
        }
        if (n & 1)
        {
            cout << "YES" << endl;
            continue;
        }
        int sum = 0;
        for (int i = n - 1; i >= 0; i -= 2)
        {
            sum += (a[i] - a[i - 1]);
        }
        if (sum < 0)
        {
            cout << "NO" << endl;
            continue;
        }
        cout << "YES" << endl;
    }
}