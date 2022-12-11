using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B7569 //토마토
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B7569()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            int M = tokens[0], N = tokens[1], H = tokens[2]; //M : 열, N : 행, H : 층

            int[,,] map = new int[H, N, M];

            int[] dx = { 0, 0, 1, -1, 0, 0 };
            int[] dy = { 1, -1, 0, 0, 0, 0 };
            int[] dz = { 0, 0, 0, 0, 1, -1 };

            //1을 입력 받으면 큐에 넣는다.
            //int[]의 길이는 4
            //0 : floor, 1 : col, 2 : row, 3 : count 
            Queue<int[]> Q = new Queue<int[]>();

            //상자를 H번 입력
            for(int i = 0; i < H; i++)
            {
                //상자 입력, 1 : 익은 토마토, 0 : 안익은 토마토, -1 : 빈 칸
                for(int j = 0; j < N; j++)
                {
                    tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);

                    for (int k = 0; k < M; k++)
                    {
                        map[i, j, k] = tokens[k];

                        if (tokens[k] == 1) Q.Enqueue(new int[] { i, j, k, 0 });
                    }
                }
            }

            int res = 0;

            while(Q.Count > 0)
            {
                int[] node = Q.Dequeue();
                int floor = node[0], col = node[1], row = node[2], count = node[3];

                for(int i = 0; i < 6; i++)
                {
                    int f = floor + dy[i];
                    int c = col + dz[i];
                    int r = row + dx[i];

                    if (f < 0 || f >= H || c < 0 || c >= N || r < 0 || r >= M || map[f, c, r] != 0) continue;

                    Q.Enqueue(new int[] { f, c, r, count + 1 });
                    map[f, c, r] = 1;
                    res = count + 1;
                }
            }

            for(int i = 0; i < H; i++)
            {
                for(int j = 0; j < N; j++)
                {
                    for(int k = 0; k < M; k++)
                    {
                        if(map[i, j, k] == 0)
                        {
                            sw.WriteLine(-1);
                            Close_Stream();
                            return;
                        }
                    }
                }
            }

            sw.WriteLine(res);
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}
