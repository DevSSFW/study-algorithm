using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B1697 //숨바꼭질
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B1697()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            int N = tokens[0], K = tokens[1];

            int[] dx = { 2, -1, 1 };
            Queue<int[]> Q = new Queue<int[]>();
            bool[] vis = new bool[100001];

            Q.Enqueue(new int[] { N, 0 });
            vis[N] = true;

            while(Q.Count > 0)
            {
                int[] node = Q.Dequeue();
                int x = node[0]; //현재 위치
                int time = node[1]; //시간

                if(x == K)
                {
                    sw.WriteLine(time);
                    break;
                }

                for(int i = 0; i < 3; i++)
                {
                    int nextX = 0;

                    if (i == 0) nextX = x * 2;
                    else nextX = x + dx[i];

                    if (nextX < 0 || nextX > 100000 || vis[nextX]) continue;

                    Q.Enqueue(new int[] { nextX, time + 1 });
                    vis[nextX] = true;
                }
            }

            sr.Close();
            sw.Close();
        }
    }
}