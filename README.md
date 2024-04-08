1. Programming Problem 3
   Bounded Queue
   Implement a queue of bounded length.
   In the given file called BoundedQueue.java, implement a queue class called 
2. BoundedQueue, where each instance is a queue that can hold a bounded number of 
3. String values.
   The main data structure of your class should be an instance of ArrayList<String>.
   The class should have push and pop methods which are synchronized. 
4. (These two methods should behave in a first-in first-out fashion; when the pop 
5. method is able to dequeue a string, it should dequeue the oldest string in the queue.)
   Behaviour of the classes, and methods
   The methods should behave as follows:
   The constructor of this class should receive an int which specifies the maximum 
6. number of Strings that the queue can hold.
   The push method should first check if there are already the maximum number of 
7. elements in the queue; if so, the method should call wait() until the number of 
8. elements is strictly less than the maximum number. After that, it should push the 
9. argument of the method into the queue; print out "Pushed: " followed by the string 
10. that was just pushed, a slash, and the queue size; call notifyAll(); and then 
11. return.
   The pop method should first check if there is at least one element in the queue; 
8. if not, the method should call wait() until this holds. After that, it should pop a string from the queue; print out "Popped: " followed by the popped string, a slash, and the queue size; call notifyAll(); and then return.
   Further details
   In the given file called QueueUser.java, implement 3 classes:
   A class Pusher which implements Runnable. The constructor of this class should 
2. receive an instance of BoundedQueue, a name, and a number iterations. The run() 
3. method of this class should call push on the given instance of BoundedQueue the 
4. specified number of times, with a loop having an index variable whose value varies 
5. from 1 to the number iterations; the argument passed to push should be a String 
6. which consists of the value of the index variable plus the name.
   A class Popper which implements Runnable. The constructor of this class should 
7. receive an instance of BoundedQueue and a number iterations. The run() method of 
8. this class should call pop on the given instance of BoundedQueue the specified 
9. number of times.
   A public class QueueUser with a main method that does the following. First, it 
10. creates a single instance of BoundedQueue, passing the value 2 to the constructor 
11. of BoundedQueue. Then, it creates two instances of the class Pusher, passing the 
12. constructor the instance of BoundedQueue, the names a and b, and the value 8 as 
13. the number of iterations. After this, it creates one instance of the class Popper, 
14. passing the constructor the instance of BoundedQueue, and the value 16 as the
15. number of iterations. Finally, it creates 3 threads based on these 3 instances 
16. of Pusher and Popper, and starts these threads. (See the sample output below. 
17. You are of course free to experiment with different values and different numbers
18. of threads, but please submit a
2. main method that behaves as described.)