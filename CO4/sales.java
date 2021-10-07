package javaprg;

import java.util.ArrayList;
import java.util.List;

public class sales {

	public static void main(String[] args) {
		List<Integer> sharedList = new ArrayList<Integer>();
		Thread t1 = new Thread(new Thread( new Producer(sharedList)));
		Thread t2 = new Thread(new Thread( new Consumer(sharedList)));
		t1.start();
		t2.start();
	}
	
}
class Producer implements Runnable
{
	List<Integer> sharedList = null;
	final int MAX_SIZE=5;
	private int i = 0;
	

	public Producer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}
	@Override
	public void run() {
		while(true) {
			try
			{
			produce(i++);
			}catch(InterruptedException exception) {
				
			}
		}
		
	}
	public void produce(int i) throws InterruptedException {
		synchronized (sharedList) {
			while(sharedList.size() == MAX_SIZE) {
				System.out.println("SharedList is full !! Waiting for consumer to consume....");
				sharedList.wait();
			}
		}
		synchronized (sharedList) {
			System.out.println("producer produced the element"+i);
			sharedList.add(i);
			Thread.sleep(100);
			sharedList.notify(); 
		}
		
	}
}
class Consumer implements Runnable
{
	List<Integer> sharedList = null;
	

	public Consumer(List<Integer> sharedList) {
		super();
		this.sharedList = sharedList;
	}
	@Override
	public void run() {
		while(true) {
			try
			{
			consume();
			}catch(InterruptedException exception) {
				
			}
		}
		
	}
	public void consume() throws InterruptedException {
		synchronized (sharedList) {
			while(sharedList.isEmpty()) {
				System.out.println("SharedList is Empty !! Waiting for producer to produce the object....");
				sharedList.wait();
			}
		}
		synchronized (sharedList) {
			Thread.sleep(1000);
			System.out.println("consumed the Element"+sharedList.remove(0));
			sharedList.notify(); 
		}
		
	}
}
