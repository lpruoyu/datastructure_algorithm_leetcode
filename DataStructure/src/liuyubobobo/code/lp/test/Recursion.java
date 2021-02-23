package liuyubobobo.code.lp.test;

public class Recursion {

	/*
	 * 学习递归
	 */

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(sum(arr));
	}

	// 计算arr数组元素之间的和
	private static int sum(int[] arr) {
		if (null == arr) {
			throw new IllegalArgumentException("arr is null! You are really a dog.");
		}
		return sum(arr, 0);
	}

	private static int sum(int[] arr, int index) {
		if (index == arr.length) {
			return 0;
		}
		return arr[index] + sum(arr, index + 1);
	}

}
