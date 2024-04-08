// your_ID_here
// your_email_address_here

// Response to Q1:
//
//

// Response to Q2:
//
//

import javax.swing.*;

// Response to Q3:
//
//
class Pusher implements Runnable {
    BoundedQueue q;
    String name;
    int iterations;
    Pusher(BoundedQueue q, String name, int iterations ) {
        this.q = q;
        this.name = name;
        this.iterations = iterations;
    }
    public void run() {
        int index = 1;
        while (index <= iterations)  {
            try {
                String indexStr = String.valueOf(index);
                this.q.push(indexStr + " " + this.name);
                index++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Popper implements Runnable {
    BoundedQueue q;
    int iterations;
    Popper(BoundedQueue q, int iterations) {
        this.q = q;
        this.iterations = iterations;
    }
    public void run() {
        int index = 1;
        while (index <= iterations) {
            try {
                this.q.pop();
                index++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class QueueUser {
    public static void main(String[] args) {
        BoundedQueue q = new BoundedQueue(2);
        Pusher p = new Pusher(q,"a", 8);
        Pusher r = new Pusher(q,"b", 8);
        Popper s = new Popper(q,16);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(s);
        t1.start();
        t2.start();
        t3.start();
    }
}
