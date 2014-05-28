package cn.edu.nuc.rsa;

/**
 * 该类实现了将一个整数转换为二进制形式的功能
 * 由于Miller-Rabin塑性检测算法和Rsa加密算法
 * 中都要用到此功能，所以单独定义一个类
 * @author zzh
 *
 */
public class IntegerToBinary {

	/**讲一个整数转换为二进制形式，用整型数组存放每一位
	 * 
	 * @param n 待转换的数
	 * @return 存放n二进制的数组
	 */
	public static int[] toBinaryArray(int n)
	{
		int k = binaryDigits(n);
		int[] b = new int[k];
			
		int i = 0;
		int bit;
		while (n != 0)
		{
			bit = n % 2;
			b[i++] = bit;
			n /= 2;	
		}
		return b;
	}
	
	/**求一个整数二进制形式的位数
	 * 
	 * @param n
	 * @return
	 */
	private  static int binaryDigits(int n)
	{
		int k = 0;
		while (n != 0)
		{
			k++;
			n = n >> 1;
		}
		return k;
	}
}
