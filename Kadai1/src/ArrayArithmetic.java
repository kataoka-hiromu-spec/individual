public class ArrayArithmetic {

	public static double getSum(double[] array) {
		if (array.length == 0) {
			return 0.0;
		}
		double ret = 0.0;
		for (double value: array) {
			ret += value;
		}
		return ret;
	}

	public static double getProduct(double[] array) {
		if (array.length == 0) {
			return 0.0;
		}
		double ret = 1.0;
		for (double value: array) {
			ret *= value;
		}
		return ret;
	}

	public static double[] incArray(double[] array) {
		double[] ret = new double[array.length];
		for (int i = 0; i < array.length; i++) {
			ret[i] = array[i] + 1;
		}
		return ret;
	}

	public static void main(String[] args) {
		//double[] array1 = {1.012, -2.599, 3.421};
        //double[] array1 = {5.0};
        double[] array1 = {2.0, 0.0, 5.0};
        //double[] array1 = {1.012, -2.599, 3.421};
        //double[] array1 = {1.012, -2.599, 3.421};
		System.out.printf("array1: ");
		for (double value: array1) {
			System.out.printf("%1.3f ", value);
		} //array1 表示
		System.out.printf("\n");
		System.out.printf("array1 sum: %1.3f\n", getSum(array1)); //array1 総和
		System.out.printf("array1 product: %1.3f\n", getProduct(array1)); //array1 積

		double[] array2 = incArray(array1);
		System.out.printf("array2: ");
		for (double value: array2) {
			System.out.printf("%1.3f ", value);
		} //array2 表示
		System.out.printf("\n");
		System.out.printf("array2 sum: %1.3f\n", getSum(array2)); //array2 総和
		System.out.printf("array2 product: %1.3f\n", getProduct(array2)); //array2 積
	}
}
