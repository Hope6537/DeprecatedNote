package org.hope6537.greeting;

public class HDOJ1051 {

	/*
	 *  #include<iostream>
		#include<algorithm>
		using namespace std;
		struct wooden
		{
		    int length;
		    int weight;
		}a[5001];
		bool cmp(wooden b,wooden c)
		{
		    if(b.length==c.length)
		    return b.weight<c.weight;
		    return b.length<c.length;
		}
		int main()
		{
		    int t,i,j,n,p[5001],mark,k,temp,q;
		    cin>>t;
		    while(t--)
		    {
		        cin>>n;
		        for(i=1;i<=n;i++)
		        {
		            cin>>a[i].length;
		            cin>>a[i].weight;
		        }
		        sort(a,a+n+1,cmp);
		        mark=0;
		        memset(p,0,sizeof(p));
		        for(i=1;i<=n;i++)
		        {
		            if(p[i]!=1)
		            {k=0;
		            p[i]=1;
		            q=i;
		            for(j=i+1;j<=n;j++)
		            {
		                if(a[q].length<=a[j].length&&a[q].weight<=a[j].weight&&p[j]!=1)
		                {p[j]=1;
		                q=j;}
		            }
		            for(j=1;j<=n;j++)
		            {
		                if(p[j]==1)
		                k++;
		            }
		            mark++;
		            if(k==n)
		            break;}    
		        }
		        cout<<mark<<endl;
		    }
		}
	 */
}
