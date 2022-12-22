using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B1520 //내리막 길
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        int N, M;
        int[,] map;
        bool[,] vis;
        int[,] clearNum;
        int[] dx = { 1, -1, 0, 0 }, dy = { 0, 0, 1, -1 };

        public B1520()
        {
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            N = tokens[0]; M = tokens[1];

            map = new int[N, M];
            vis = new bool[N, M];
            clearNum = new int[N, M];

            for(int i = 0; i < N; i++)
            {
                tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
                for (int j = 0; j < M; j++) map[i, j] = tokens[j];
            }

            solve(0, 0, map[0, 0]);

            sw.WriteLine(clearNum[0, 0]);
            Close_Stream();
        }

        public int solve(int col, int row, int height)
        {
            if (col == N - 1 && row == M - 1) return 1;
            if (vis[col, row]) return clearNum[col, row];
            vis[col, row] = true;

            for (int i = 0; i < 4; i++)
            {
                int c = col + dx[i];
                int r = row + dy[i];

                if (c < 0 || r < 0 || c >= N || r >= M || map[c, r] >= height) continue;

                clearNum[col, row] += solve(c, r, map[c, r]);
            }

            return clearNum[col, row];
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}