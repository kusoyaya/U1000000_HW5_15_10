package hw1510;

import java.util.ArrayList;
import java.io.*;

public class MyStack<E> implements Cloneable,Serializable{
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
	
	public E get(int i){
		return list.get(i);
	}
	
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException ex){
			return null;
		}
	}
	
	public Object shallowClone(){
		try{
			MyStack<E> s = (MyStack<E>) super.clone();
			s.list = (ArrayList<E>)this.list.clone();
			return s;
		}catch(CloneNotSupportedException ex){
			return null;
		}
	}
	
	public MyStack<E> deepClone(){
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
			ObjectInputStream ois = new ObjectInputStream(bais);
			return (MyStack<E>) ois.readObject();
		}catch(Exception e){
			System.out.println("Object in stack cannot be seriealized.\nDo shallowclone.");
			return (MyStack<E>) this.shallowClone();
		}
	}
	
	@Override
	public String toString(){
		return "Stack"+list.toString();
	}
}
