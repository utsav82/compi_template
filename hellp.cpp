#include <bits/stdc++.h>
using namespace std;

int main()
{
	int t;
	cin >> t;
	while (t--)
	{
		int n;
		int m;
		cin >> n >> m;
		int a[n];
		for (int i = 0; i < n; i++)
		{
			cin >> a[i];
		}
		multiset<int> ele,diff;
		ele.insert(0);
		ele.insert(m);
		diff.insert(m);
		for(int i=0;i<n;i++){
			ele.insert(a[i]);
			auto it = ele.find(a[i]);
			auto next = it;
			auto prev = it;
			next++;
			prev--;
			if(it!=ele.end() && it!=ele.begin()){
				diff.erase(diff.find(*next-*prev));
				diff.insert(*next-*it);
				diff.insert(*it-*prev);
			}
			cout<<*diff.rbegin()<<" ";
		}
		cout<<endl;

	}
}