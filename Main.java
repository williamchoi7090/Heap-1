public class Main{
  private int[] heap;
  private int size;
  private int max;
  private static final int front = 1;
  public Main(int max){
    this.max = max;
    this.size = 0;
    heap = new int[this.max + 1];
    heap[0] = Integer.MAX_VALUE;
  }
  private int parent(int a){
    return a/ 2;
  }
  private int left(int a){
    return (2 * a);
  }
  private int right(int a){
    return (2 * a) + 1;
  }
  private boolean isLeaf(int a){
    if (a >= (size/ 2) && a <= size){
      return true;
    }
    return false;
  }
  private void swap(int b,int c){
    int tmp;
    tmp = heap[b];
    heap[b] = heap[c];
    heap[c] = tmp;
  }
  private void max1(int a){
    if (!isLeaf(a)){
      if ( heap[a]< heap[left(a)] || heap[a]< heap[right(a)]){
        if (heap[left(a)]> heap[right(a)]){
          swap(a, left(a));
          max1(left(a));
        }
        else{
          swap(a, right(a));
          max1(right(a));
        }
      }
    }
  }
  public void insert(int element){
    heap[++size] = element;
    int current = size;
    while(heap[current] > heap[parent(current)]){
      swap(current,parent(current));
      current = parent(current);
    }  
  }
  public void print(){
    for (int i = 1; i <= size / 2; i++ ){
      System.out.print(" The parent is: " + heap[i] + " The left is:: " + heap[2*i] + " The right is::" + heap[2 * i + 1]);
      System.out.println();
    }
  } 
  public int size(){
    return size;
  } 
  public boolean isEMpty(){
    if(size==0){
      return true;
    }
    return false;
  }
  public void max2(){
    for (int a = (size / 2); a >= 1; a--){
      max1(a);
    }
  }
  public int remove(){
    int popped = heap[front];
    heap[front] = heap[size--];
    max1(front);
    return popped;
  }
  public static void main(String...arg){
    System.out.println("The maximum heap is: ");
    Main max2 = new Main(15);
    max2.insert(2);
    max2.insert(5);
    max2.insert(10);
    max2.insert(15);
    max2.insert(20);
    max2.insert(25);
    max2.insert(50);
    max2.insert(52);
    max2.insert(55);
    max2.max2();
    max2.print();
    System.out.println("The maximum value is: " + max2.remove());
    System.out.println("The size of the list is: "+max2.size());
  }
}