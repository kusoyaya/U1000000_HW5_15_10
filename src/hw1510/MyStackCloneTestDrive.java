package hw1510;

import java.io.Serializable;

public class MyStackCloneTestDrive {
	public static void main(String[] args){
		MyStack<Person> stack1 = new MyStack<Person>();
		stack1.push(new Person("A"));
		stack1.push(new Person("B"));
		stack1.push(new Person("C"));
		MyStack<Person> stack2 = (MyStack<Person>) (stack1.clone());
		MyStack<Person> stack3 = (MyStack<Person>) (stack1.shallowClone());
		MyStack<Person> stack4 = stack1.deepClone();
		stack1.get(2).setName("CC");
		stack1.push(new Person("D"));
		stack1.push(new Person("E"));
		stack1.push(new Person("F"));
		System.out.println(stack1.getSize());
		System.out.println(stack2.getSize());
		System.out.println(stack3.getSize());
		System.out.println(stack4.getSize());
		
		System.out.println(stack2.get(2).name);
		System.out.println(stack3.get(2).name);
		System.out.println(stack4.get(2).name);
	}
}


class Person implements Serializable{
	String name;
	
	Person(String name){
		this.name = name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}