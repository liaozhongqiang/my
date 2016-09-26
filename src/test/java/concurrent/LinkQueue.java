package concurrent;

import java.util.concurrent.atomic.AtomicReference;

public class LinkQueue<E> {
	
	static class Node<E>{
		AtomicReference<E> item;
		AtomicReference<Node<E>> next;
		Node(E item,Node<E> next){
			this.item=new AtomicReference<E>(item);;
			this.next=new AtomicReference<LinkQueue.Node<E>>(next);
		}
		public E getItem() {
			return item.get();
		}
		public Node<E> getNext() {
			return next.get();
		}
		
		
	}
	
	AtomicReference<Node<E>> head=new AtomicReference<LinkQueue.Node<E>>(new Node<E>(null,null));
	
	AtomicReference<Node<E>> tail=head;
	
	public boolean push(E item){
		Node<E> nextNode=new Node<E>(item,null);
		while(true){
			Node<E> curtail=tail.get();
			Node<E> residue=curtail.getNext();
			if(curtail==tail.get()){
				if(residue==null){
					if(curtail.next.compareAndSet(null, nextNode)){
						tail.compareAndSet(curtail, nextNode);
						return true;
					}
				}else{
					tail.compareAndSet(curtail, residue);
				}
			}
		}
	}
	
	//移动head节点
	public E pop(){
		Node<E> h=head.get();
		Node<E> p=h;
		while(true){
			E item=p.getItem();
			//若不为空则尝试将其CAS为空
			if(item!=null&&p.item.compareAndSet(item,null)){
				//修改头节点
				Node<E> q=p.getNext();
				head.compareAndSet(p, q==null?p:q);
			}
			
			//为空，或将头节点CAS空失败
			
		}
	}
	
	public static void main(String[] args) {
		LinkQueue<Integer> queue=new LinkQueue<Integer>();
		queue.push(1);
		System.out.println(queue.head.get().item);
	}

}
