using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B2629 //양팔저울
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

        public B2629()
        {
            int N = int.Parse(sr.ReadLine());
            int[] weight = new int[N];
            
            int max = 0;
            int[] tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            for (int i = 0; i < N; i++) 
            {
                weight[i] = tokens[i];
                max += weight[i];
            }

            bool[] vis1 = new bool[max + 40001], vis2 = new bool[max + 40001];

            int M = int.Parse(sr.ReadLine());
            int[] marbles = new int[M];
            tokens = Array.ConvertAll(sr.ReadLine().Split(' '), int.Parse);
            for (int i = 0; i < M; i++) marbles[i] = tokens[i];

            vis1[0] = true;

            for(int i = 0; i < N; i++)
            {
                int w = weight[i];

                for(int j = max; j >= w; j--)
                {
                    if (vis1[j - w]) vis1[j] = true;
                }
            }

            for (int i = M - 1; i >= 0; i--)
            {
                for (int j = 1; j < max; j++)
                {
                    if (vis1[j] && vis1[j + marbles[i]])
                    {
                        vis2[marbles[i]] = true;
                        break;
                    }
                }
            }

            for(int i = 0; i < M; i++)
            {
                if(vis1[marbles[i]] || vis2[marbles[i]]) sw.Write("Y ");
                else sw.Write("N ");
            }
            
            Close_Stream();
        }

        public void Close_Stream()
        {
            sr.Close();
            sw.Close();
        }
    }
}