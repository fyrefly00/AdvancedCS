/**
 * Mr. Berniker
 * Sep 21, 2015
 * TestLL.java
 */

public class TestLL {

	public static void main(String[] args) {
		AdvCSLL<String> strLL = new AdvCSLL<>();
		
		System.out.println("Is initial list empty? : " + strLL.isEmpty());
		
		System.out.println("Ok, add words...\n");
		strLL.add("My");
		strLL.add("list");
		strLL.add("is");
		strLL.add("not");
		strLL.add("working!"); 
	//	System.out.println(strLL.removeFirst());
		strLL.remove("not");  
		System.out.println(strLL.removeFirst());
		System.out.println(strLL.removeFirst());
		System.out.println(strLL); 
		
		System.out.println("\nList contains 'list'? : " + strLL.contains("list"));
		System.out.println("List contains 'not'? : " + strLL.contains("not"));
		System.out.println("Is current list empty? : " + strLL.isEmpty());
		 
		System.out.println("\nOk, clear list...\n");
		strLL.clear();
		
		System.out.println("Is final list empty? : " + strLL.isEmpty());
		strLL.add("yay");
		System.out.println(strLL.remove("cheese"));
		strLL.clear();
		System.out.println(strLL.removeFirst());
	}

}