package ds;

public class BasicQueue<X> {
    private final X[] data;
    private int front;
    private int end;

    public BasicQueue() {
        this(1000);                 //this statament ile size olan değeri method ile atıyoruz
    }

    public BasicQueue(int size) {
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size];  //data adında bir dizi oluşturuyoruz bu dizinin size belli
    }

    public int size() {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    public void enQueue(X item) {
        //queue full
        if ((end + 1) % data.length == 1) {
            throw new IllegalStateException("The Queue is Full!");
        }
        //otherwise check to see if any items have been added to the Queue yet.
        else if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        }
        //otherwise add the item to the end of the queue
        else {
            end++;
            data[end] = item;
        }

    }

    public X deQueue() {
        X item = null;

        if (size() == 0) {
            throw new IllegalStateException("Can't dequeue because the queue is empty");
        } else if ((front == end)) {
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(X item) {
        boolean found = false;


        for (int i = 0; i < data.length; i++)
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        return found;
    }

    public X access(int position) {
    if (size()==0 || position>size()){
        throw  new IllegalStateException("No items in the queue");
    }
    int trueIndex=0;
    for (int i=front;i<end;i++){
        if (trueIndex==position){
            return data[i];
        }
        trueIndex++;
    }

    throw new IllegalArgumentException();
    }


}
