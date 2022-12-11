using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B24444 //알고리즘 수업 - 너비 우선 탐색 1
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B24444()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            int N = tokens[0], M = tokens[1], R = tokens[2];
            N++;

            List<int>[] list = new List<int>[N];
            for (int i = 1; i < N; i++) list[i] = new List<int>();

            bool[] vis = new bool[N];
            int[] res = new int[N];

            for(int i = 0; i < M; i++)
            {
                tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);

                int n1 = tokens[0];
                int n2 = tokens[1];

                list[n1].Add(n2);
                list[n2].Add(n1);
            }

            for (int i = 1; i < N; i++) list[i].Sort();

            Queue<int> Q = new Queue<int>();
            int count = 1;
            Q.Enqueue(R);

            while(Q.Count > 0)
            {
                int node = Q.Dequeue();

                if (vis[node]) continue;
                
                vis[node] = true;
                res[node] = count++;

                foreach(int n in list[node])
                {
                    if (vis[n]) continue;

                    Q.Enqueue(n);
                }
            }

            for (int i = 1; i < N; i++) sw.WriteLine(res[i]);

            sr.Close();
            sw.Close();
        }
    }
}