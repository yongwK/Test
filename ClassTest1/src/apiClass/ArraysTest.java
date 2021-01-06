package apiClass;

import java.util.Arrays;
import java.util.Collections;

public class ArraysTest {

	public ArraysTest() {
	// 				  0    1  2   3  4   5   6   7   8   9   10
		int[] data = {58, 62, 4, 95, 31, 75, 15, 27, 45, 79, 12};
		//배열객체의 데이터를 크기순으로 정렬
		//Arrays.sort(data);  // 오름차순으로 정렬
		Arrays.sort(data, 1, 5); // index 1~ 5앞까지만 정렬 (일부분만정렬)
		System.out.println("정렬후 =" + Arrays.toString(data));
		
		int data2[] = Arrays.copyOfRange(data, 1, 5); // index 1 ~ 5앞까지 복사
		System.out.println("copyofRange -->" + Arrays.toString(data2));
		
		int data3[] = Arrays.copyOf(data, 5); // 갯수만큼 복사한다.
		System.out.println("copyof---->" + Arrays.toString(data3));
		
		//arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		int data4[] = new int[20];
		System.arraycopy(data, 5, data4, 3, 6);  // data배열의 index 5인 위치의 값부터 data4의 index3의 위치에 6개를 복사
		System.out.println("arrayscopy---->" + Arrays.toString(data4));
	}

	public static void main(String[] args) {
		new ArraysTest();

	}

}
