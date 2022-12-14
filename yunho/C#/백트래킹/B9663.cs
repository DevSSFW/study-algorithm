using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B9663 //N-Queen
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        bool[,] vis;
        int res = 0;

        //0 : 하, 1 : 우, 2 : 좌, 3 : 하/우, 4 : 하/좌
        int[] dx = { 1, 0, 0, 1, 1};
        int[] dy = { 0, 1, -1, 1, -1};

        public B9663()
        {
            int N = int.Parse(sr.ReadLine());

            vis = new bool[N, N];

            for(int i = 0; i < N; i++) BackTracking(N, 0, i);
            sw.WriteLine(res);

            Close_Stream();
        }

        public void BackTracking(int n, int col, int row)
        {
            if(col == n - 1)
            {
                res++;
                return;
            }

            List<int[]> attack = new List<int[]>();

            //퀸 공격범위 설정
            for (int i = 1; i <= n; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    int c = dx[j] * i + col;
                    int r = dy[j] * i + row;

                    //이미 공격 가능한 칸은 넘긴다.
                    if (c < 0 || c >= n || r < 0 || r >= n || vis[c, r]) continue;

                    //지금 배치할 퀸이 공격 가능한 칸을 설정한다.
                    attack.Add(new int[] { c, r });
                    vis[c, r] = true;
                }
            }

            for (int i = 0; i < n; i++)
            {
                //퀸 위치
                if (!vis[col + 1, i]) BackTracking(n, col + 1, i);
            }

            //퀸 공격범위 해제
            foreach (int[] map in attack) vis[map[0], map[1]] = false;
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}