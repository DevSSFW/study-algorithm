using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B9084 //동전
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        //dp[0]은 1로 초기화, 초기값
        //j : 현재 확인하고 있는 금액, coins[i] : 선택한 동전
        //dp[j] += dp[j - coins[i]]만 해주면 된다.
        public B9084()
        {
            StringBuilder sb = new StringBuilder();

            int T = int.Parse(sr.ReadLine());
            
            while(T-- > 0)
            {
                int N = int.Parse(sr.ReadLine());
                int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
                int[] coins = new int[N];

                for(int i = 0; i < N; i++) coins[i] = tokens[i];
                
                int M = int.Parse(sr.ReadLine());
                int[] dp = new int[M + 1];
                dp[0] = 1;

                for(int i = 0; i < N; i++)
                {
                    for(int j = 1; j <= M; j++)
                    {
                        if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
                    }
                }

                sb.Append(dp[M] + "\n");
            }

            Console.WriteLine(sb);
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}
