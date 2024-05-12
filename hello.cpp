#include<bits/stdc++.h>
using namespace std;
#define  F                 first
#define  S                 second
#define  pb                push_back
#define  ll                long long
#define  ld                long double
#define  INF               LLONG_MAX
#define  MINF              LLONG_MIN
#define  int               long long
#define  pll               pair<ll,ll>
#define  vi                vector<int>
#define  eb                emplace_back
#define  SORT(v)           sort(all(v))
#define  REVERSE(v)        reverse(all(v))
#define  difinbits(a,b)    setbits(a^b);
#define  trailzero(x)      __builtin_ctzll(x)
#define  accuracy(x)       setprecision(x)
#define  pt(x)             cout<<(x)<<endl
#define  ptw(x)            cout<<(x)<<" "
#define  no                cout<<"no"<<endl
#define  No                cout<<"No"<<endl
#define  NO                cout<<"NO"<<endl
#define  yes               cout<<"yes"<<endl
#define  YES               cout<<"YES"<<endl
#define  Yes               cout<<"Yes"<<endl
#define  all(v)            v.begin(),v.end()
#define  FIND(m,v)         m.find(v)!=m.end()
#define  vvi               vector<vector<int>>
#define  MAXI(a)           *max_element(all(a))
#define  MINI(a)           *min_element(all(a))
#define  L(i,a,b)          for(ll i=a;i<=b;i++)
#define  R(i,b,a)          for(ll i=b;i>=a;i--)
#define  bs(a,x)           binary_search(all(a),x)
#define  read(a)           for(auto &it:a) cin>>it;
#define  setbits(x)        __builtin_popcountll(x)
#define  RSORT(v)          sort(v.rbegin(),v.rend())
#define  ub(a,x)           upper_bound(all(a),x)-a.begin()
#define  lb(a,x)           lower_bound(all(a),x)-a.begin()
#define  mkuniq(a)         a.erase(unique(all(a)),a.end())
#define  to_upper(s)       transform(all(s),s.begin(),::toupper);
#define  to_lower(s)       transform(all(s),s.begin(),::tolower);
#define  readm(a)          for(auto &it:a)for(auto &j:it) cin>>j;
#define  printm(m)         for(auto i:m) cout<<i.first<<" "<<i.second<<endl;
#define  printmtx(v)       for(auto i:v){for(auto j:i) cout<<j<<" ";cout<<"\n";}
#define  CODE_BY_KARAN     ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
#define  leftrotate(v,k)   rotate(v.begin(), v.begin()+k, v.end());
#define  rightrotate(v,k)  rotate(v.begin(), v.begin()+v.size()-k, v.end())
 
 
class Data_structure {
public:
	multiset<int> first, second;
	int size1 = 0;
 
	void _insert(int x) {
		first.insert(x);
		if (first.size() > size1) {
			int ele = *first.rbegin();
			first.erase(first.find(ele));
			second.insert(ele);
		}
	}
 
	void _delete(int x) {
		auto it = second.find(x);
		if (it == second.end()) {
			// second me present nhi hai
			first.erase(first.find(x));
			int ele = *second.begin();
			second.erase(second.find(ele));
			first.insert(ele);
 
		} else {
			// second me present hai
			second.erase(second.find(*it));
		}
	}
 
	int find_median() {
		return *first.rbegin();
	}
 
	void set_size(int x) {
		this->size1 = x;
	}
};
 
void solve()
{
	int n, k; cin >> n >> k;
 
	vector<int> a(n);
	read(a);
 
	int first_max_size = (k + 1) / 2;
 
	Data_structure ds;
	ds.set_size(first_max_size);
 
	for (int i = 0; i < k; i++)  ds._insert(a[i]);
	cout << ds.find_median() << " ";
 
	for (int i = k; i < n; i++) {
		ds._insert(a[i]);
		ds._delete(a[i - k]);
		cout << ds.find_median() << " ";
	}
 
	cout << "\n";
 
}
signed main()
{
	CODE_BY_KARAN;
	solve();
	return 0;
}