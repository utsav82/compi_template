#include <iostream>
#include <vector>
#include <set>
#include <queue>
using namespace std;

void solve()
{
    int n;
    cin >> n;

    vector<vector<int>> adj(n + 1);
    for (int i = 2; i <= n; i++)
    {
        int x;
        cin >> x;
        adj[x].push_back(i);
        adj[i].push_back(x);
    }

    cout << n << endl;
}

int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        solve();
    }
    return 0;
}
