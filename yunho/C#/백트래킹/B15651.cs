using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B15651 //N과 M (3)
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        int[] res;

        public B15651()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            int N = tokens[0], M = tokens[1];
            
            res = new int[M];

            BackTracking(N, M, 0);

            Close_Stream();
        }

        public void BackTracking(int n, int m, int count)
        {
            if (m == count)
            {
                for (int i = 0; i < m; i++) sw.Write(res[i] + " ");
                sw.WriteLine();
                return;
            }

            for(int i = 1; i <= n; i++)
            {
                res[count] = i;
                BackTracking(n, m, count + 1);
            }
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}
