package hw1510;

import java.io.Serializable;

public class MyStackCloneTestDrive {
	public static void main(String[] args){
		System.out.println("本程式將說明 Shallow Copy 以及 Deep Copy 的差別。");
		
		MyStack<Person> originalStack = new MyStack<Person>();
		originalStack.push(new Person("John"));
		originalStack.push(new Person("Peter"));
		originalStack.push(new Person("Tom"));
		System.out.println("先將三個不同名字的 Person 物件推入 original stack 當中。\n");
		
		MyStack<Person> stack1 = (MyStack<Person>) originalStack.clone();
		MyStack<Person> stack2 = (MyStack<Person>) originalStack.shallowClone();
		MyStack<Person> stack3 = originalStack.deepClone();
		System.out.println("建立三個 stack 分別是:\nstack1:只複製 stack 本身，list 沒有複製到\nstack2:複製 stack 以及 list\nstack3:連同 list 裡面的物件也複製\n");
		
		originalStack.push(new Person("Jane"));
		originalStack.push(new Person("Mary"));
		originalStack.push(new Person("Amy"));
		System.out.println("再推入三個不同名字的 Person 物件到 original stack 當中。");
		System.out.printf("目前 original stack 裡面的 list 共有 %d 個Person。\nstack1 裡面的 list 有 %d 個 Person。\nstack2 裡面的 list 有 %d 個 Person\nstack3 裡面的list 有 %d 個 Person。\n",originalStack.getSize(),stack1.getSize(),stack2.getSize(),stack3.getSize());
		System.out.println("由此可知 stack1 裡的 list 仍然和 original stack 裡面的相同，並沒有 deep copy 到。\n");
		
		originalStack.get(0).setName("Hilson");
		System.out.println("再把 John 的名字改成 Hilson。");
		System.out.println("目前 original stack 裡頭第一個 Person 的名字是"+originalStack.get(0).getName());
		System.out.println("stack1 裡頭第一個 Person 的名字是 "+stack1.get(0).getName());
		System.out.println("stack2 裡頭第一個 Person 的名字是 "+stack2.get(0).getName());
		System.out.println("stack3 裡頭第一個 Person 的名字是 "+stack3.get(0).getName());
		System.out.println("由此可知 stack1 和 stack2 裡頭第一個 Person 仍然和 original stack 的相同，並沒有 deep copy 到。\n");
		
		System.out.println("以下將利用 toString 方法列出各個 stack 裡面元素以便確認。");
		System.out.println("original stack 是: "+originalStack.toString());
		System.out.println("stack1 是: "+stack1.toString());
		System.out.println("stack2 是: "+stack2.toString());
		System.out.println("stack3 是: "+stack3.toString());
		
		System.out.println("\n以下是利用 == operator 來確認是否 deep copy");
		if(originalStack.getList()==stack1.getList()){
			System.out.println("stack1 裡面的 list 和 orignal stack 相同");
		}else{
			System.out.println("stack1 裡面的 list 和 orignal stack 不同");
		}
		if(originalStack.getList()==stack2.getList()){
			System.out.println("stack2 裡面的 list 和 orignal stack 相同");
		}else{
			System.out.println("stack2 裡面的 list 和 orignal stack 不同");
		}
		if(originalStack.getList()==stack3.getList()){
			System.out.println("stack3 裡面的 list 和 orignal stack 相同");
		}else{
			System.out.println("stack3 裡面的 list 和 orignal stack 不同");
		}
		
		if(originalStack.get(1)==stack1.get(1)){
			System.out.println("stack1 裡面的 Person 和 orignal stack 相同");
		}else{
			System.out.println("stack1 裡面的 Person 和 orignal stack 不同");
		}
		if(originalStack.get(1)==stack2.get(1)){
			System.out.println("stack2 裡面的 Person 和 orignal stack 相同");
		}else{
			System.out.println("stack2 裡面的 Person 和 orignal stack 不同");
		}
		if(originalStack.get(1)==stack3.get(1)){
			System.out.println("stack3 裡面的 Person 和 orignal stack 相同");
		}else{
			System.out.println("stack3 裡面的 Person 和 orignal stack 不同");
		}
	}
}


