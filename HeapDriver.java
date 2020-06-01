
public class HeapDriver {

	public static void main(String[] args) {
		AdvCSHeap strHeap = new AdvCSHeap<>(10);
		strHeap.add(50, "50");
		strHeap.add(30, "30");
		strHeap.add(80, "80");
		strHeap.add(100, "100");
		strHeap.add(70, "70");
		strHeap.add(60, "60");
		System.out.println(strHeap);

		for (int i = 0; i < 6; i++) {
		strHeap.remove();
		System.out.println(strHeap);
		}
//		AdvCSHeap strHeap = new AdvCSHeap<>(10);
//		strHeap.add(10, "10");
//		strHeap.add(5, "5");
//		strHeap.add(7, "7");
//		strHeap.add(3, "3");
//		strHeap.add(2, "2");
//	
//		strHeap.add(12, "12");
//		strHeap.add(0, "0");
//		strHeap.add(100, "100");
//		strHeap.add(11, "11");
//	
//		System.out.println(strHeap.toString());
//		strHeap.remove();
//		System.out.println(strHeap.toString());
//		strHeap.remove();
//		System.out.println(strHeap.toString());
//		strHeap.remove();
//		System.out.println(strHeap.toString());
//		strHeap.remove();
//		System.out.println(strHeap.toString());
//		
//	
//	}
	}
}
