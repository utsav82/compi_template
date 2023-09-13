#include <bits/stdc++.h>
using namespace std;

int main()
{
	
 string str = "tourist 3858 ksun48 3679 Benq 3658 Um_nik 3648 apiad 3638 Stonefeang 3630 ecnerwala 3613 mnbvmar 3555 newbiedmy 3516 semiexp 3481";
 string s;cin>>s;
 for(int i=0;i<str.size()-4;i++){
	if(s[0]==str[i] && s==str.substr(i,s.size())){
		cout<<str.substr(i+s.size()+1,4)<<endl;
		break;
	}
 }
        
        
        
	
}