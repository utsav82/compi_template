
N = int(input())
A = list(map(int,input().split()))
dp = [-1]*N
N=N-1
if (1 + A[1] < N):
    print(-1)
dp[N] = A[N]
for i in range(N-1, 0, -1):
    dp[i] = A[i]
    for j in range(i+1, min(N+1, i + A[i] + 1)):
        dp[i] = min(dp[i], dp[j] | A[i])
print(dp[1])