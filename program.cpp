#include <bits/stdc++.h>
using namespace std;

vector<int> a, b;
vector<int> dp;
int n;

int solve(int mask)
{
	if (dp[mask] != -1)
		return dp[mask];
	bool f = false;
	for (int j = 0; j < n; ++j)
	{
		for (int k = j + 1; k < n; ++k)
		{
			if ((mask & (1 << j)) && (mask & (1 << k)))
			{
				if ((a[j] == a[k] || b[j] == b[k]) && solve(mask ^ (1 << j) ^ (1 << k)) == 0)
				{
					f = true;
				}
			}
		}
	}
	return dp[mask] = f;
}

int main()
{
	cin >> n;
	a.resize(n);
	b.resize(n);
	for (int i = 0; i < n; ++i)
		cin >> a[i] >> b[i];
	dp.resize(1 << n, -1);
	dp[0] = 0;
	cout << (solve((1 << n) - 1) ? "Takahashi" : "Aoki") << endl;
	return 0;
}
