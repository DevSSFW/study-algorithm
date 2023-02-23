package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3020_1 { //���˹���(���׸�Ʈ Ʈ��)
	static int N, H;
	static int[] iTree = new int[1100000];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int firstIndex = 1; //���� ���� ���� ����� �ε���
		while(firstIndex < H) firstIndex *= 2;

		//�� ������ ���� �־��ش�.
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(i % 2 == 0) edit(1, 1, firstIndex, 1, num); //����, 1~num
			else edit(1, 1, firstIndex, H - num + 1, H); //������, H-num+1~H
		}
		
		int min = Integer.MAX_VALUE, count = 0;
		for(int i = 0; i < H; i++) {
			int temp = 0;
			int tempIndex = i + firstIndex;
			
			//�� ���� ����� ��� ���� ����� ���� ���Ѵ�.
			//�� ���� ���˹����� �μ� ��ֹ� ���̴�.
			while(tempIndex >= 1) {
				temp += iTree[tempIndex];
				tempIndex /= 2;
			}
			
			if(temp < min) {
				min = temp;
				count = 1;
			}
			else if(temp == min) count++;
		}
		
		System.out.println(min + " " + count);
	}
	
	//�˻��ϰ� �ִ� ������ Ȯ���ϰ� ���� ���� �ִٸ� + 1, ������ �Ѿ�� ��͸� ������.
	static void edit(int x, int l, int r, int search_l, int search_r) {
		if(r < search_l || l > search_r) return;
		if(l >= search_l && r <= search_r) {
			iTree[x]++;
			return;
		}
		
		edit(x * 2, l, (l + r) / 2, search_l, search_r);
		edit(x * 2 + 1, (l + r) / 2 + 1, r, search_l, search_r);
	}
}