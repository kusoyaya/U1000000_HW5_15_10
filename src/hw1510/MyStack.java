package hw1510;

import java.util.ArrayList;

public class MyStack<E> implements Cloneable{
	private ArrayList<E> list = new ArrayList<E>();
	
	public boolean isEmpty(){
		return list.isEmpty();
	}
	
	public int getSize(){
		return list.size();
	}
	
	public E peek(){
		return list.get(getSize()-1);
	}
	
	public E pop(){
		E e = list.get(getSize()-1);
		list.remove(getSize()-1);
		return e;
	}
	
	public void push(E e){
		list.add(e);
	}
	
	public ArrayList<E> clone(){
		ArrayList<E> cloneList = new ArrayList<E>();
		for(E e:list){
			cloneList.add((E)e.clone());
		}
		return cloneList;
	}
	
	@Override
	public String toString(){
		return "Stack"+list.toString();
	}
}
