using System;
using System.Collections.Generic;
using System.Text;

namespace BaekJoon
{
    class B10773
    {
        static void Main(string[] args)
        {
            int K = int.Parse(Console.ReadLine()); //반복 횟수
            StringBuilder sb = new StringBuilder();
            
            int sum = 0; //합
            Stack<int> S = new Stack<int>();
            
            for(int i = 0; i < K; i++)
            {
                int num = int.Parse(Console.ReadLine());

                if (num == 0) S.Pop();
                else S.Push(num);
            }

            while (S.Count > 0) sum += S.Pop();

            sb.Append(sum);
            Console.WriteLine(sb);
        }
    }
}
