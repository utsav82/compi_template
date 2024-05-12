#include <iostream>
#include <vector>
#include <unordered_map>
#include <ext/pb_ds/assoc_container.hpp>
#include <ext/pb_ds/tree_policy.hpp>

using namespace __gnu_pbds;
using namespace std;

typedef tree<int, null_type, less_equal<int>, rb_tree_tag, tree_order_statistics_node_update> pbds; // find_by_order, order_of_key

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    int n;
    cin >> n;
    vector<long long> v(n);
    for (auto &ele : v)
        cin >> ele;

    pbds A;
    long long ans = 0;
    for (int i = 0; i < n; i++)
    {
        ans += A.order_of_key(v[i]) * v[i];
        A.insert(v[i]);
    }

    pbds B;
    for (int i = n - 1; i >= 0; i--)
    {
        ans -= B.order_of_key(-v[i]) * v[i];
        B.insert(-v[i]);
    }

    cout << ans;
    return 0;
}
