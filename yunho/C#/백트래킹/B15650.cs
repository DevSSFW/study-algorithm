using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B15650 //N과 M (2)
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        bool[] vis;
        int[] res;

        public B15650()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);

            int N = tokens[0], M = tokens[1];

            res = new int[M];
            vis = new bool[N + 1];

            BackTracking(N, M, 0, 1);
            Close_Stream();
        }

        public void BackTracking(int n, int m, int count, int start)
        {
            if(m == count)
            {
                for (int i = 0; i < m; i++) sw.Write(res[i] + " ");
                sw.WriteLine();
                return;
            }

            for(int i = start; i <= n; i++)
            {
                if (!vis[i])
                {
                    vis[i] = true;
                    res[count] = i;
                    BackTracking(n, m, count + 1, res[count]);
                    vis[i] = false;
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