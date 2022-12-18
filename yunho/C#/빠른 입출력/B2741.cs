using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B2741 //N 찍기
    {
        public B2741()
        {
            StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
            StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));

            int N = int.Parse(sr.ReadLine());

            for (int i = 1; i <= N; i++) sw.WriteLine(i);

            sr.Close();
            sw.Close();
        }
    }
}