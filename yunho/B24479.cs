using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B24479 //알고리즘 수업 - 깊이 우선 탐색 1
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        List<int>[] list;
        bool[] vis; //방문 확인
        int[] res; //결과
        int count = 1; //방문 순서

        public B24479()
        {
            String[] tokens = sr.ReadLine().Split(' ');
            int N = int.Parse(tokens[0]), M = int.Parse(tokens[1]), R = int.Parse(tokens[2]);
            N++;

            list = new List<int>[N];
            for (int i = 1; i < N; i++) list[i] = new List<int>();

            vis = new bool[N];
            res = new int[N];

            for(int i = 0; i < M; i++)
            {
                tokens = sr.ReadLine().Split(' ');

                int n1 = int.Parse(tokens[0]);
                int n2 = int.Parse(tokens[1]);

                list[n1].Add(n2);
                list[n2].Add(n1);
            }

            for (int i = 1; i < N; i++) list[i].Sort();

            DFS(R);

            for (int i = 1; i < N; i++) sw.WriteLine(res[i]);

            sr.Close();
            sw.Close();
        }
        
        //깊이 우선 탐색
        public void DFS(int node)
        {
            if (vis[node]) return;
            vis[node] = true;
            res[node] = count++;

            foreach(int n in list[node])
            {
                if (vis[n]) continue;

                DFS(n);
            }
        }
    }
}