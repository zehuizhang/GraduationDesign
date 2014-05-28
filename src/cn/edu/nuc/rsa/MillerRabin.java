/*
*MillerRabin.java
*Miller-Rabin概率检测法判断一个数是否为素数
*/
package cn.edu.nuc.rsa;
import java.util.Random;
/*
 * Miller-Rabin概率检测法
 * 该算法基于以下定理：
 * 1、费尔马定理
 * 2、二次探测定理
 * 算法原理描述：
 * 1、如果存在一个小于n的整数a,满足a的n-1次方模n值为1，则由费尔马定理可知n为素数
 * 该算法存在误判的情况，因为上述原理只是一个必要条件而非充分条件，即在满足上述条件情况下，n可能为合数。
 * 然而，上述原理的误判概率比较低，特别是对一个数n经过多轮判断后。
 * 经证明，经一轮判断误判概率不大于1/4.
 * 2、在原理1的判断过程中，若存在对n不满足二次探测定理的情况，则整个判断提前结束，n不是素数。
 *
 * */

public class MillerRabin 
{
	private static final int NUM_TEST =  5;
	public static void main(String[] args) 
	{
		System.out.println(millerRabin(101));
		//System.out.println(modexp(5, 2, 7));
	}
	//@SuppressWarnings("unused")
	/*private static int modexp(int a, int m, int n){
		int[] b = toBinaryIntArray(m); 
		int d = 1;

		for (int i = b.length - 1; i >= 0; i--)
		{
			d = (d * d) % n;
			if (1 == b[i])
			{
				d = (d * a) % n;
			}
		}
		return d;
	}*/
	/*Miller-Rabin素性概率检测法
	 * 功能：对n进行一轮Miller-Rabin算法检测，a在函数中随机生成
	 * 输入：待检验的正整数n≥2
	 * 输出：若算法返回值为false，则n肯定不是素数，如果返回值为true，则n有可能是素数
	 */
	
	public static boolean millerRabin(int n)
	{
		if (n < 2)
		{
			//System.out.println("请输入大于1的整数！");
			return false;
		}
		
		Random random = new Random();
		int a;
		for (int i = 0; i < NUM_TEST; i++)
		{
			//产生小于n的整数2 ~ n-1
			a = random.nextInt(n-2) + 2;
			if (!witness(n, a))
			{
				return false;
			}
		}
		return true;
	}
	/*函数boolean witness(int n, int a)
	 * 功能：对n进行一轮Miller-Rabin算法测试
	 * 输入：待检验的正整数n≥2，a是小于n的正整数
	 * 输出：若算法返回值为false，则n肯定不是素数，如果返回值为true，则n有可能是素数
	 */
	public static boolean witness(int n, int a)
	{
		//将n-1表示为二进制形式
		int[] b = IntegerToBinary.toBinaryArray(n-1);
		int d = 1;
		int x;
		for (int i = b.length-1; i >=0; i--)
		{
			x = d;
			d = (d * d) % n;
			if ((1 == d) && (x != 1) && (x != n - 1))
			{
				return false;
			}
			if (1 == b[i])
			{
				d = (d * a) % n;
			}
		}
		if (d != 1)
		{
			return false;
		}
		return true;
	}
}
