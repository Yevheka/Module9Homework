import java.util.Arrays;

public class  MyArrayList<T> {
    private Object[] arrayList;
    private int size = 0;

    public MyArrayList(int initialLength){
        this.arrayList = new Object[initialLength];
    }

    public MyArrayList(){
    }

    private void grow(){
        arrayList = Arrays.copyOf(arrayList, size + 1);
    }

    public void add(T value){
        if(size == arrayList.length){
            grow();
        }
        arrayList[size] = value;
        size++;
    }

    public void remove(int index){
        size--;
        for(int i = index; i < size; i++){
            arrayList[i] = arrayList[i + 1];
        }
        arrayList[size] = null;
    }

    public void clear(){
        for(int i = 0; i < size ; i++){
            arrayList[i] = null;
        }
        size = 0;
    }

    public int size(){
    return size;
    }

    public Object get(int index){
       return arrayList[index];
    }


}
