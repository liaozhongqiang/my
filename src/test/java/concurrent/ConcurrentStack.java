package concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class ConcurrentStack<E> {
	
	AtomicReference<Node<E>> head=new AtomicReference<Node<E>>();
	
	public void push(E item){
		Node<E> oldValue;
		Node<E> newValue=new Node<E>(item);
		do{
			oldValue=head.get();
			newValue.next=oldValue;
		}while(!head.compareAndSet(oldValue, newValue));
	}
	
	public E pop(){
		Node<E> oldHead;
		Node<E> newHead;
		do{
			oldHead=head.get();
			if(oldHead==null){
				return null;
			}
			newHead=oldHead.next;
		}while(!head.compareAndSet(oldHead, newHead));
		return oldHead.item;
	}
	
	static class Node<E>{
		final E item;
		
		Node<E> next;
		
		public Node(E item){
			this.item=item;
		}
	}

}
