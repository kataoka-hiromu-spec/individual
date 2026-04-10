public class ArrayArithmeticEX {

	public static int getSum(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int ret = 0;
		for (int  value: array) {
			ret += value;
		}
		return ret;
	}

	public static int getNonZeroProduct(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int ret = 1;
		for (int value: array) {
			if(value != 0) ret *= value;
		}
		return ret;
	}

	public static int[] getNegations(int[] array) {
		int[] ret = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			ret[i] = -1 * array[i];
		}
		return ret;
	}

	public static void main(String[] args) {
		//int[] array = {1, -2, 3};
        int[] array = {5};
        //int[] array = {2, 0, 5};
		System.out.printf("array: ");
		for (int value: array) {
			System.out.printf("%d ", value);
		} //array 表示
		System.out.printf("\n");
		System.out.printf("array sum: %d\n", getSum(array)); //array 総和
		System.out.printf("array product: %d\n", getNonZeroProduct(array)); //array 積
		System.out.printf("opposite array: ");
		for (int value: getNegations(array)) {
			System.out.printf("%d ", value);
		} //array 表示
		System.out.printf("\n");
	}
}
