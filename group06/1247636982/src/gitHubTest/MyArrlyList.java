package gitHubTest;
/**
 * ArrlyList的底层实现
 * @author Administrator
 *
 */
public class MyArrlyList<E> implements MyList<E> {

	//数组大小
	private int size;
	//当前
	private int current ;
	//
	private int point;
	//数组中的值
	private Object[] elementData = null;
	//默认数组大小
	private static final int DEFAULT_SIZE=10;
	//构造函数
	public MyArrlyList(int size) {
		if(size < 0) {
			 throw new IndexOutOfBoundsException();
		} else {
			this.elementData = new Object[size];
			this.current = 0;
			point = size;
		}
	}
	//构造函数
	public MyArrlyList() {
		this(DEFAULT_SIZE);
	}
	//当前集合大小
	public int size(){
		return this.current;
	}
	//判断集合是否为空的
	public boolean isEmpty() {
		if(this.current>0) {
			return true;
		}
		return false;
	}
	//加数据
	public void add(E e){
		judgeSize();
		this.elementData[current] = e;
		this.current++;		
	}
	//加数据
	public void add(int index, E e){
		rangeCheckForAdd(index);		
		for(int i=0 ; i<elementData.length;i++) {
			if(i >= index && i+2 < elementData.length) {
				elementData[i] = e;
				elementData[i+1] = elementData[i+2];
			}			
		}		
		current++;
	}
	//获取索引下的数据
	public E get(int index){
		rangeCheckForAdd(index);
		return (E)this.elementData[index];
	}
	
	//删除某个索引下的数据
	public void remove(int index) {
		rangeCheckForAdd(index);
		for(int i=0;i<elementData.length;i++) {
			if(i==index) {
				elementData[i] = elementData[i+1];
			}
		}
		current--;		
	}

	private void judgeSize() {  
		    Object[] newarr = new Object[elementData.length + DEFAULT_SIZE];  
	        System.arraycopy(elementData, 0, newarr, 0, elementData.length); 
	        this.elementData = newarr;
	}  
	
	//检查加的数组是否越界
	private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
	
	private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

}
