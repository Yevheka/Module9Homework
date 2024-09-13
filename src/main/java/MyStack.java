import java.util.Arrays;

public class MyStack<T> {
    private Object[] stack;
    private int size = 0;

    public MyStack(int initialLength){
        this.stack = new Object[initialLength];
    }

    public MyStack(){

    }

    private void grow(){
        stack = Arrays.copyOf(stack, size + 1);
    }

    public void add(T value){
        if(size == stack.length){
            grow();
        }
        stack[size] = value;
        size++;
    }

    public void remove(int index) {
        size--;
        for(int i = index; i < size; i++){
            stack[i] = stack[i + 1];
        }
        stack[size] = null;
    }

    public void clear() {
        for(int i = 0; i < size ; i++){
            stack[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object peek(){
        if(size > 0) {
            return stack[size - 1];
        } else {
            return null;
        }

    }

    public Object pop() {
        if(size > 0) {
            Object temp = stack[size-1];
            stack[size-1] = null;
            size--;
            return temp;
        } else {
            return null;
        }
    }
}
