package gitHubTest;
/**
 * LinkedList�ĵײ�ʵ��
 * @author Administrator
 *
 */
public class MyLinkedList<E> implements MyList<E> {
	//β�ڵ�
	private Node<E> last;
	//ͷ�ڵ�
	private Node<E> first;	
	//���鳤��
	private int size = 0;
	
	public MyLinkedList() {
		init();
	}
	//��ʼ��
	private void init() {
		first = new Node<E>(null,null,null);
		last = new Node(null,first,null);		
		first.next = last;		
		size = 0;
	}
	//�¼�һ���ڵ�
	private void add(Node<E> node,int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException("�±�Խ��");
		}
		node.pre = getNode(index-1);
		getNode(index-1).next = node;
		node.next = getNode(index);
		getNode(index).pre = node;
		size++;
	}
	public void add(E e){
		add(new Node<E>(e,null,null),size);
	}
	
	public void add(int index,E e){
		add(new Node<E>(e,null,null),index);
	}
	//��ȡ�ڵ�
	private Node<E> getNode(int index){
		Node<E> newNode;
		int current;
		if(index == -1) {
			return first;
		} else if (index == size ){
			return last;
		} else {
			current = 0;
			newNode = first.next;
			while (current < index) {
				newNode = newNode.next;
				current++;
			}
		}
		return newNode;
	}
	
	public E get(int index) {  
        return getNode(index).e;  
    }  
	//ɾ���ڵ�
	public void remove(int index){
		Node node = getNode(index);
		node.pre.next = node.next;
		node.next.pre=node.pre;
		size--;		
	}
	private static  class Node<E>{
		public E e;		
		Node<E> next;
		Node<E> pre;
		public Node (E e,Node<E> pre,Node<E> next) {
			this.pre = pre;
			this.next = next;
			this.e = e;
		}
		
	}
	public boolean isEmpty() {		
		return size == 0 ? true:false;
	}
	public int size(){
		return size;
	}
	public void addFirst(E e){
		add(new Node<E>(e,null,null),0);
	}
	public void addLast(E e){
		add(new Node<E>(e,null,null),size);
	}
	public void removeFirst(){
		remove(0);		
	}
	public void removeLast(){
		remove(size);
	}
}
