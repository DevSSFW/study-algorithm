using System;
using System.Collections.Generic;
using System.Text;
using System.IO;

namespace BaekJoon.src
{
    class B11729 //하노이탑 이동 순서
    {
        StreamReader sr = new StreamReader(new BufferedStream(Console.OpenStandardInput()));
        StreamWriter sw = new StreamWriter(new BufferedStream(Console.OpenStandardOutput()));
        StringBuilder sb = new StringBuilder();
        int count = 0; //옮긴 횟수

        public B11729()
        {
            int K = int.Parse(sr.ReadLine());

            Hanoi(K, 1, 2, 3);

            sw.WriteLine(count + "\n" + sb);

            sr.Close();
            sw.Close();
        }

        //가장 큰 원판을 제외한 원판들을 2로 옮긴 후,
        //가장 큰 원판을 3으로 옮기고,
        //나머지 원판들을 3으로 옮긴다.
        public void Hanoi(int k, int one, int two, int three)
        {
            if(k == 1)
            {
                //가장 작은 원판을 one에서 three로 옮긴다. 
                sb.Append(one + " " + three + "\n");
                count++;
                return;
            }

            //가장 큰 원판 위에 있는 원판들을 one에서 two로 옮긴다.
            Hanoi(k - 1, one, three, two);
            
            //가장 큰 원판을 one에서 three으로 옮긴다.
            sb.Append(one + " " + three + "\n");
            count++;
            
            //two에 있는 나머지 원판들을 three에 있는 가장 큰 원판 위로 옮긴다.
            Hanoi(k - 1, two, one, three);
        }
    }
}