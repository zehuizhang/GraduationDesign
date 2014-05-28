package cn.edu.nuc.rsa;

/**
 * ����ʵ���˽�һ������ת��Ϊ��������ʽ�Ĺ���
 * ����Miller-Rabin���Լ���㷨��Rsa�����㷨
 * �ж�Ҫ�õ��˹��ܣ����Ե�������һ����
 * @author zzh
 *
 */
public class IntegerToBinary {

	/**��һ������ת��Ϊ��������ʽ��������������ÿһλ
	 * 
	 * @param n ��ת������
	 * @return ���n�����Ƶ�����
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
	
	/**��һ��������������ʽ��λ��
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
