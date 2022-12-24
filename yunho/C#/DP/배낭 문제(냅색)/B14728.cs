using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B14728 //벼락치기
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B14728()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            int N = tokens[0], T = tokens[1];
            int[] K = new int[N], S = new int[N], dp = new int[T + 1];

            for (int i = 0; i < N; i++)
            {
                tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);

                K[i] = tokens[0];
                S[i] = tokens[1];
            }

            for (int i = 0; i < N; i++)
            {
                for (int j = T; j >= K[i]; j--) dp[j] = Math.Max(dp[j], dp[j - K[i]] + S[i]);
            }

            sw.WriteLine(dp[T]);
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}
