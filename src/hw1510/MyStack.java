package hw1510;

import java.util.ArrayList;
import java.io.*;

public class MyStack<E> implements Cloneable,Serializable{
	private ArrayList<E> list = new ArrayList<E>(); //create Arraylist
	
	public boolean isEmpty(){
		return list.isEmpty();
	}//stack isempty is same as arraylist isempty
	
	public int getSize(){
		return list.size();
	}//stack getsize is same as arraylist size
	
	public E peek(){
		return list.get(getSize()-1);
	}//stack peek is to take last element in arraylist
	
	public E pop(){
		E e = list.get(getSize()-1);
		list.remove(getSize()-1);
		return e;
	}//stack pop is to take last element in arraylist and then remove it
	
	public void push(E e){
		list.add(e);
	}//stack push is same as arraylist add
	
	public E get(int i){
		return list.get(i);
	}//this is for the test program to get the index element in arraylist
	
	public ArrayList<E> getList(){
		return list;
	}//this is for the test program to get the arraylist
	
	public Object clone(){
		try{
			return super.clone();
		}catch(CloneNotSupportedException ex){
			return null;
		}
	}//clone stack itself but not clone the list
	
	public Object shallowClone(){
		try{
			MyStack<E> s = (MyStack<E>) super.clone();
			s.list = (ArrayList<E>)this.list.clone();
			return s;
		}catch(CloneNotSupportedException ex){
			return null;
		}
	}//clone the stack and list but not clone the object in arraylist
	
	public MyStack<E> deepClone(){
		try{
			ByteArrayOutputStream baos = new ByteArrayOutputStream(); //create a bytearray outputstream
			ObjectOutputStream oos = new ObjectOutputStream(baos); //let the object stream to the bytearray outputstream above
			oos.writeObject(this); //write this object into stream
			
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray()); //create a bytearray inputstream
			ObjectInputStream ois = new ObjectInputStream(bais);  //let the object stream to the bytearray inputstream above
			return (MyStack<E>) ois.readObject(); //read the object from stream and return it
		}catch(Exception e){
			System.out.println("Object in stack cannot be seriealized.\nDo shallowclone.");
			return (MyStack<E>) this.shallowClone();
		}
	}//using serialize to clone all thing in stack
	
	@Override
	public String toString(){
		return "Stack"+list.toString();
	}//override the tostring method
}
