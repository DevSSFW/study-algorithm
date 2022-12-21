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
                int[] dp = new int[10001]; //입력될 수 있는 최대 값을 크기로 지정

                for (int i = 0; i < N; i++)
                {
                    dp[coins[i]]++; //동전이 최대 10000이기 때문에 오버플로우가 일어나지 않는다.
                    for(int j = coins[i]; j <= M; j++) dp[j] += dp[j - coins[i]];
                    
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