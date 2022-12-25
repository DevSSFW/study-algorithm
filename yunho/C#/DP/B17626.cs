using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B17626 //Four Squares
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B17626()
        {
            int N = int.Parse(sr.ReadLine());
            int[] dp = new int[N + 1];
            Array.Fill(dp, int.MaxValue);

            dp[1] = 1;

            for(int i = 2; i <= N; i++)
            {
                int sqrt = (int)Math.Sqrt(i);
                
                for(int j = 1; j <= sqrt; j++)
                {
                    int p = j * j;

                    if (i - p == 0) dp[i] = 1;
                    else dp[i] = Math.Min(dp[i], dp[i - p] + 1);
                }
            }

            sw.WriteLine(dp[N]);
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}