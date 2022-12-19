using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B12865 //평범한 배낭 (냅색 문제)
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        int N, K;
        int[] dp, W, V;

        public B12865()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            N = tokens[0];
            K = tokens[1];

            dp = new int[K + 1];
            W = new int[N];
            V = new int[N];

            for(int i = 0; i < N; i++)
            {
                tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
                int w = tokens[0], v = tokens[1];

                W[i] = w;
                V[i] = v;
            }

            for(int i = 0; i < N; i++)
            {
                for(int j = K; j >= W[i]; j--)
                {
                    dp[j] = Math.Max(dp[j], dp[j - W[i]] + V[i]);
                }
            }

            sw.WriteLine(dp[K]);
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}
