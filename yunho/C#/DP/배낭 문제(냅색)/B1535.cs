using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B1535 //안녕
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B1535()
        {
            int N = int.Parse(sr.ReadLine());
            int[] L = new int[N], J = new int[N], dp = new int[101];

            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            for (int i = 0; i < N; i++) L[i] = tokens[i];
            tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            for (int i = 0; i < N; i++) J[i] = tokens[i];

            for(int i = 0; i < N; i++)
            {
                if (L[i] >= 100) continue;

                for(int j = 100; j > L[i]; j--)
                {
                    if (j - L[i] > 0) dp[j] = Math.Max(dp[j], dp[j - L[i]] + J[i]);
                }
            }

            sw.WriteLine(dp[100]);
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}
