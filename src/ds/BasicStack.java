package ds;

public class BasicStack<X> {
    private X[] data;
    private int stackPointer;
    public BasicStack() {

        data = (X[]) new Object[1000];
        stackPointer=0;
    }


    public void push(X newItem) {
    data[stackPointer++]=newItem;
    }

    public X pop() {
    return data[--stackPointer];
    }

    public boolean contains(X item){
        boolean found=false;
        for (int i=0; i<stackPointer;i++){
            if (data[i].equals(item)){
                found=true;
            }
        }
        return found;
    }
    public X access(X item){
        while(stackPointer>0){
            X tmpitem=pop();
            if (item.equals(tmpitem)){
                return tmpitem;
            }
        }
        throw new IllegalArgumentException("Could not find item on the  stack : "+item);
    }

    public int size(){
        return stackPointer;
    }

}

