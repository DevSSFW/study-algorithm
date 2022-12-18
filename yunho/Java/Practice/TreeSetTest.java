package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		TreeSet<Integer> set1 = new TreeSet<>();
		for(int i = 0; i < 5; i++) {
			int n = Integer.parseInt(br.readLine());
			
			set1.add(n);
		}
		
		for(Integer set : set1) System.out.println("Ʈ���� ��� : " + set);
		System.out.println();
		
		Iterator<Integer> itr = set1.iterator();
		while(itr.hasNext()) {
			System.out.println("iterator�� Ȱ���� ��� : " + itr.next());
			itr.remove();	//itr���� ���� ����Ű�� �־�� ���� �����ϴ�.
							//list���� remove�ϸ� ���� ����Ű�� �ִ� �����ʹ� �״������ ���� �����Ǳ� ������
							//���� ������ �ʴ� ����� ���� �� �ֱ� ������ Iterator�� Ȱ���� �����ϴ� ���� ���� �����ϴ�.
							//java 8���ʹ� Iterator�� Ȱ������ �ʰ� removeIf�� ����� �����ϰ� ������ �� �ִ�.
		}
		System.out.println();
		
		//��� ���� �����ؼ� ��µ��� �ʴ´�.
		for(Integer set : set1) System.out.println("Ʈ���� ��� : " + set); 
		
		set1 = new TreeSet<>(Set.of(1, 10, 21, 9, 11, 15));
		
		NavigableSet<Integer> set2 = set1.subSet(1, true, 10, false); //true�� �� ����, false�� ���� �������� �ʴ´�.
		TreeSet<Integer> set3 = (TreeSet<Integer>)set1.subSet(1, true, 10, true); //true�� �� ����, false�� ���� �������� �ʴ´�.
		
		set1.add(7);
		
		for(Integer set : set2) System.out.println("���� Ʈ����1 ��� : " + set);
		System.out.println();
		for(Integer set : set3) System.out.println("���� Ʈ����2 ��� : " + set);
		System.out.println();
		
		set2.add(5);
		for(Integer set : set1) System.out.println("���� Ʈ���¿� 5 ���� �� Ʈ���� ��� : " + set); 
		System.out.println();
		for(Integer set : set3) System.out.println("���� Ʈ����2 ��� : " + set);
		System.out.println();
	}
}