/*
*MillerRabin.java
*Miller-Rabin���ʼ�ⷨ�ж�һ�����Ƿ�Ϊ����
*/
package cn.edu.nuc.rsa;
import java.util.Random;
/*
 * Miller-Rabin���ʼ�ⷨ
 * ���㷨�������¶���
 * 1���Ѷ�����
 * 2������̽�ⶨ��
 * �㷨ԭ��������
 * 1���������һ��С��n������a,����a��n-1�η�ģnֵΪ1�����ɷѶ������֪nΪ����
 * ���㷨�������е��������Ϊ����ԭ��ֻ��һ����Ҫ�������ǳ����������������������������£�n����Ϊ������
 * Ȼ��������ԭ������и��ʱȽϵͣ��ر��Ƕ�һ����n���������жϺ�
 * ��֤������һ���ж����и��ʲ�����1/4.
 * 2����ԭ��1���жϹ����У������ڶ�n���������̽�ⶨ���������������ж���ǰ������n����������
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
	/*Miller-Rabin���Ը��ʼ�ⷨ
	 * ���ܣ���n����һ��Miller-Rabin�㷨��⣬a�ں������������
	 * ���룺�������������n��2
	 * ��������㷨����ֵΪfalse����n�϶������������������ֵΪtrue����n�п���������
	 */
	
	public static boolean millerRabin(int n)
	{
		if (n < 2)
		{
			//System.out.println("���������1��������");
			return false;
		}
		
		Random random = new Random();
		int a;
		for (int i = 0; i < NUM_TEST; i++)
		{
			//����С��n������2 ~ n-1
			a = random.nextInt(n-2) + 2;
			if (!witness(n, a))
			{
				return false;
			}
		}
		return true;
	}
	/*����boolean witness(int n, int a)
	 * ���ܣ���n����һ��Miller-Rabin�㷨����
	 * ���룺�������������n��2��a��С��n��������
	 * ��������㷨����ֵΪfalse����n�϶������������������ֵΪtrue����n�п���������
	 */
	public static boolean witness(int n, int a)
	{
		//��n-1��ʾΪ��������ʽ
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
