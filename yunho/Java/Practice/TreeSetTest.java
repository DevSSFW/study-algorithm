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
		
		for(Integer set : set1) System.out.println("트리셋 출력 : " + set);
		System.out.println();
		
		Iterator<Integer> itr = set1.iterator();
		while(itr.hasNext()) {
			System.out.println("iterator를 활용한 출력 : " + itr.next());
			itr.remove();	//itr에서 값을 가리키고 있어야 삭제 가능하다.
							//list에서 remove하면 값을 가리키고 있는 포인터는 그대로지만 값은 삭제되기 때문에
							//내가 원하지 않는 결과가 나올 수 있기 때문에 Iterator를 활용해 삭제하는 것이 가장 안전하다.
							//java 8부터는 Iterator를 활용하지 않고 removeIf를 사용해 안전하게 삭제할 수 있다.
		}
		System.out.println();
		
		//모든 값을 삭제해서 출력되지 않는다.
		for(Integer set : set1) System.out.println("트리셋 출력 : " + set); 
		
		set1 = new TreeSet<>(Set.of(1, 10, 21, 9, 11, 15));
		
		NavigableSet<Integer> set2 = set1.subSet(1, true, 10, false); //true면 값 포함, false면 값을 포함하지 않는다.
		TreeSet<Integer> set3 = (TreeSet<Integer>)set1.subSet(1, true, 10, true); //true면 값 포함, false면 값을 포함하지 않는다.
		
		set1.add(7);
		
		for(Integer set : set2) System.out.println("서브 트리셋1 출력 : " + set);
		System.out.println();
		for(Integer set : set3) System.out.println("서브 트리셋2 출력 : " + set);
		System.out.println();
		
		set2.add(5);
		for(Integer set : set1) System.out.println("서브 트리셋에 5 더한 후 트리셋 출력 : " + set); 
		System.out.println();
		for(Integer set : set3) System.out.println("서브 트리셋2 출력 : " + set);
		System.out.println();
	}
}