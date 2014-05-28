package cn.edu.nuc.rsa;

import java.util.Random;



/**
 * �ó����ʵ����RSA�����㷨
 * @author zzh
 *
 */
public class RsaUtil {
	
	private int bigPrimerP = 0;//������p
	private int bigPrimerQ = 0;//������q
	private int pmultiQN = 0;//�����������ĳ˻�
	private int publicKey = 0;//��Կ
	private int privateKey = 0;//��Կ
	private int plainText = 0;//����
	private int Ciphertext = 0;//����
	
	public int getBigPrimerP() {
		return bigPrimerP;
	}
	public void setBigPrimerP(int bigPrimerP) {
		this.bigPrimerP = bigPrimerP;
	}
	public int getBigPrimerQ() {
		return bigPrimerQ;
	}
	public void setBigPrimerQ(int bigPrimerQ) {
		this.bigPrimerQ = bigPrimerQ;
	}
	public int getPmultiQN() {
		return pmultiQN;
	}
	public void setPmultiQN(int pmultiQN) {
		this.pmultiQN = pmultiQN;
	}
	public int getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(int publicKey) {
		this.publicKey = publicKey;
	}
	public int getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(int privateKey) {
		this.privateKey = privateKey;
	}
	public int getPlainText() {
		return plainText;
	}
	public void setPlainText(int plainText) {
		this.plainText = plainText;
	}
	public int getCiphertext() {
		return Ciphertext;
	}
	public void setCiphertext(int ciphertext) {
		Ciphertext = ciphertext;
	}
	

	//200����С������
	int[] primers = new int[]{
			2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
			31, 37, 41, 43, 47, 53, 59, 61, 67, 
			71, 73, 79 ,83 ,89 ,97 ,101 ,103, 107,
			109, 113, 127, 131, 137, 139, 149, 151,
			157, 163, 167, 173, 179, 181, 191, 193, 197,199 
	};
	
	
	public void init(){

		this.setBigPrimerP(this.produceBigPrimer());
		this.setBigPrimerQ(this.produceBigPrimer());
		this.setPmultiQN(this.getBigPrimerP() * this.getBigPrimerQ());
		this.setPublicKey(this.CaculatePublicKey());
		this.setPrivateKey(this.CaculatePrivateKey());
		/*System.out.println("p=========" + this.getBigPrimerP());
		System.out.println("q=========" + this.getBigPrimerQ());*/
	}
	/**�������������
	 * ���㷨Ϊ���������һ��������Ȼ���жϸ������Ƿ�Ϊ�����������򷵻أ�
	 * ������������һ������
	 * 
	 * @return ����һ���������
	 */
	private int produceBigPrimer(){
		Random r = new Random();
		int pos = r.nextInt(primers.length);
		System.out.println("======" + primers[pos]);
		return primers[pos];
	}
		
	/**���Լ�⺯��
	 * �ú�����װ����Miller��Rabin���Լ�ⷨ
	 * 
	 * @param n ��������
	 * @return ���������������棬���򷵻ؼ�
	 */
	public boolean isPrimer(int n){
		if (MillerRabin.millerRabin(n)){
			return true;
		}	
		return false;
	}
		
	/**��� n ��ŷ������ֵ��(n)
	 * ��Ϊ  n �����������ĳ˻������� n ��ŷ������ֵΪ��(n)=��p-1��*��q-1��
	 * @return  ����  n ��ŷ������ֵ��(n)
	 */
	public int eulerN(){
		return (this.bigPrimerP-1) * (this.bigPrimerQ-1);
	}
	
	/**���� e(��Կ) ��ֵ
	 * ��Ѱ����������������eֵ��
	 * 1<e<��(n) �� gcd(��(n),e)=1
	 * 
	 * @return  ����e��ֵ
	 */
	public int CaculatePublicKey(){
		Random r = new Random();
		int e = r.nextInt(eulerN());//����0-��(n)֮��������
		while (!((e>1) && (euclid(e, eulerN())==1))){
			e = r.nextInt(eulerN());
		}
		return e;
	}
	
	/**����d(˽Կ)��ֵ
	 * ��Ϊd��e�ڦ�(n)�µĳ˷���Ԫ
	 * ���Դ˴�������չ��ŷ������㷨
	 * ���dֵ
	 * 
	 * @return ����d��ֵ
	 */
	public int CaculatePrivateKey(){
		
		return extendEuclid(this.eulerN(), this.getPublicKey());//������չ��ŷ������㷨
	}
	
	/**��չ��ŷ������㷨
	 *��gcd��n, e��= 1ʱ��
	 *����e�ĳ˷���Ԫ
	 * @param n
	 * @param e
	 * @return
	 */
	private int extendEuclid(int n, int e){
		int x1 = 1;	int x2 = 0;	int x3 = n;
		int y1 = 0;	int y2 = 1;	int y3 = e;
		int t1 = 0;	int t2 = 0;	int t3 = 0;
		int q = 0;
		while (true)
		{
			if (1 == y3){
				return (y2+n) % n;
			}
			
			q = x3 / y3;
			t1 = x1 - q*y1;
			t2 = x2 - q*y2;
			t3 = x3 - q*y3;
			x1 = y1;
			x2 = y2;
			x3 = y3;
			y1 = t1;
			y2 = t2;
			y3 = t3;
		}
	}
	/**ŷ������㷨
	 * �������������Լ��
	 * 
	 * @param x	��������
	 * @param y ��������
	 * @return  ���������������Լ��
	 */
	private  int euclid(int x, int y) {
		int temp = 0;
		int a = x;
		int b = y;
		while(true)
		{
			if (0 == b){
				return a;
			}
			if (1 == b){
				return b;
			}
			
			temp = a % b;
			a = b;
			b = temp;
		}
	}
	/**RSA���ܹ���
	 * 
	 * @param m ����
	 * @return ��������
	 */
	public int encode(int m){
		return modexp(m, this.publicKey, this.pmultiQN);
	}
	
	/**RSA���ܹ���
	 * 
	 * @param c ����
	 * @return ��������
	 */
	public int decode(int c){
		return modexp(c, this.privateKey, this.pmultiQN);
	}
	
	/**����a��m�η�  mod n��ֵ
	 * ����ģ��������ʣ����ټ���ָ���㷨
	 * @param a
	 * @param m
	 * @param n
	 * @return
	 */
	private  int modexp(int a, int m, int n){
		int[] b = IntegerToBinary.toBinaryArray(m); 
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
	}
	
}
