using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B2662 //기업투자
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        int N, M;
        int[,] company;
        int[] dp, count;
        List<int[]>[] invest; //int[] 0 : 기업, 1 : 투자 가치

        public B2662()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            N = tokens[0]; M = tokens[1];
            company = new int[M + 1, N + 1];
            dp = new int[N + 1];
            count = new int[M + 1];

            invest = new List<int[]>[N + 1];
            for (int i = 0; i <= N; i++) invest[i] = new List<int[]>(); 

            for(int i = 1; i <= N; i++)
            {
                string[] str = sr.ReadLine().Split(' ');
                
                for (int j = 1; j <= M; j++) company[j, i] = int.Parse(str[j]);
            }

            for (int i = 1; i <= N; i++)
            {
                dp[i] = company[1, i];
                invest[i].Add(new int[] { 1, i });
            }

            for (int i = 2; i <= M; i++) solve(i);

            sw.WriteLine(dp[N]);
            foreach (int[] c in invest[N]) count[c[0]] += c[1];
            for (int i = 1; i <= M; i++) sw.Write(count[i] + " ");
            Close_Stream();
        }

        public void solve(int m)
        {
            for (int i = N; i > 1; i--)
            {
                for (int j = i, k = i - j; k < i; j--, k++)
                {
                    if (dp[i] < company[m, j] + dp[k])
                    {
                        //dp[i] 회사들 초기화
                        invest[i] = new List<int[]>();
                        invest[i].Add(new int[] { m, j });
                        foreach (int[] c in invest[k]) invest[i].Add(new int[] { c[0], c[1] });

                        dp[i] = company[m, j] + dp[k];
                    }
                }
            }
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}