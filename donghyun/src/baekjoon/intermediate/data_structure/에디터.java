package baekjoon.intermediate.data_structure;

import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * B_1406, 연결리스트
 */
public class 에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); //문자열 입력받기 abcd
        LinkedList<Character> list = new LinkedList<>();

        for (String s : str.split("")) {
            list.add(s.charAt(0)); // [a, b, c ,d]
        }

        int M = Integer.parseInt(br.readLine()); //명령 실행 행 개수

        ListIterator<Character> cursor = list.listIterator();

        while (cursor.hasNext()) {
            cursor.next();
        }

        while (M-- > 0) {
            String[] line = br.readLine().split(" ");

            if (line[0].equals("L")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                }
            } else if (line[0].equals("D")) {
                if (cursor.hasNext()) {
                    cursor.next();
                }
            } else if (line[0].equals("B")) {
                if (cursor.hasPrevious()) {
                    cursor.previous();
                    cursor.remove();
                }
            } else if (line[0].equals("P")) {
                cursor.add(line[1].charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : list) {
            sb.append(c);
        }
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}
