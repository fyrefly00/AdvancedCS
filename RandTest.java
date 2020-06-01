import java.math.*;
public class RandTest {

	public static void main(String[] args) {
		for(int i = 100; i > 0; i --) {
		int rand = (int)(Math.random() * 4) ;
		System.out.println(rand);
		}
	}

}
