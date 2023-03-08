package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2243 { //��������
	static int depth = 0, firstIndex = 1;
	static int[] iTree = new int[2100000];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		while(firstIndex < 1000000) {
			firstIndex *= 2;
			depth++;
		}
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(A == 1) get(1, B, 0);
			else {
				int C = Integer.parseInt(st.nextToken());
				
				edit(B + firstIndex - 1, iTree[B + firstIndex - 1] + C);
			}
		}
		
		System.out.println(sb);
	}
	
	//���� ������ Ž���ؼ� ��� ���� �켱�������� ������ ������ ��� Ž��, �켱���Ǵ� ���� ��� ���� ����.
	//���� ��� ���� �켱������ ���ų� ũ�� ���� ��� Ž��, �켱������ �״��
	//����� ���̰� Ʈ���� ���̿� ������ x - firstIndex ���
	//�Ű� ������ �ʱ� ���� (1, b, 0)
	static void get(int x, int order, int d) {
		if(depth == d) {
			edit(x, iTree[x] - 1);
			sb.append(x - firstIndex + 1 + "\n");
			return;
		}
		
		if(iTree[x * 2] < order) get(x * 2 + 1, order - iTree[x * 2], d + 1);
		else get(x * 2, order, d + 1);
	}
	
	static void edit(int prev, int value) {
		iTree[prev] = value;
		prev /= 2;
		
		while(prev >= 1) {
			iTree[prev] = iTree[prev * 2] + iTree[prev * 2 + 1];
			prev /= 2;
		}
	}
}