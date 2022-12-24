using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B1106 //호텔
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B1106()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            int C = tokens[0], N = tokens[1];
            int[] price = new int[N], get = new int[N], dp = new int[C + 1];
            
            for(int i = 0; i < N; i++)
            {
                tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
                price[i] = tokens[0];
                get[i] = tokens[1];
            }

            Array.Fill(dp, 1000000);
            dp[0] = 0;

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j <= C; j++)
                {
                    if (j < get[i]) dp[j] = Math.Min(dp[j], price[i]);
                    else dp[j] = Math.Min(dp[j], dp[j - get[i]] + price[i]);
                }
            }

            sw.WriteLine(dp[C]);
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}
