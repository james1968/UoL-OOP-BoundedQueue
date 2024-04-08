import java.io.*;
import java.util.*;

public class BoundedQueue {
    private final int maxsize;
    private ArrayList<String> queue;

    BoundedQueue(int maxsize)
    {
        this.maxsize = maxsize;
        this.queue = new ArrayList<String>();
    }

    synchronized void push( String s ) throws InterruptedException {
        if (this.queue.size() == this.maxsize) {
            wait();
        } else {
            this.queue.add(s);
            System.out.println("Pushed: " + s + " / " + this.queue.size());
            notifyAll();
        }
    }

    synchronized String pop() throws InterruptedException {
        if (this.queue.size() > 0) {
                String last = this.queue.get(queue.size() - 1);
                this.queue.remove(queue.size() - 1);
                System.out.println("Popped: " + last + " / " + this.queue.size());
                notifyAll();
            } else {
                wait();
            }
        //System.out.println();
        return null;
    }
}
