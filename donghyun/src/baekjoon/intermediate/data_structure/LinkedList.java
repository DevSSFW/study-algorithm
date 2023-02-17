package baekjoon.intermediate.data_structure;

/**
 * add, remove, contains
 */
public class LinkedList {
    int data;
    LinkedList next = null;

    public LinkedList(int data) {
        this.data = data;
    }

    public static LinkedList add(LinkedList header, LinkedList nodeToAdd, int pointer) {
        LinkedList n = header; //루트 노드는 헤더

        for (int i = 0; i < pointer - 1; i++) { //포인터(위치), 맨 끝 -1까지
            n = n.next; //추가된 노드 전까지 탐색, header 한칸씩 이동
        }
        nodeToAdd.next = n.next; //추가된 노드의 다음 위치 (종단점 밖) = 추가 노드를 대입
        n.next = nodeToAdd;
        return header;
    }

    public void append(int data) {
        LinkedList end = new LinkedList(data); //추가할 노드 객체 생성, LinkedList는 데이터 추가시 맨 뒤에 추가된다.
        LinkedList n = this; // 첫 번째 노드 선택, 루트 노드

        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public void delete(int data) {
        LinkedList n = this;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    public static boolean contains(LinkedList header, LinkedList check) {
        while (header.next != null) {
            if (header.next == check)
                return true;
            header = header.next;
        }
        return false;
    }

    public void retrieve() {
        LinkedList n = this;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print(n.data);
    }

    public static void main(String[] args) {
        LinkedList head = new LinkedList(1);
        head.append(2);
        head.append(3);
        head.retrieve();
        head.delete(2);
        System.out.println("");
        head.retrieve();
    }
}
