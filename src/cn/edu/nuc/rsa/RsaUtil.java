package cn.edu.nuc.rsa;

import java.util.Random;



/**
 * 该程序简单实现了RSA加密算法
 * @author zzh
 *
 */
public class RsaUtil {
	
	private int bigPrimerP = 0;//大素数p
	private int bigPrimerQ = 0;//大素数q
	private int pmultiQN = 0;//两个大素数的乘积
	private int publicKey = 0;//公钥
	private int privateKey = 0;//密钥
	private int plainText = 0;//明文
	private int Ciphertext = 0;//密文
	
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
	

	//200以内小素数表
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
	/**产生随机大素数
	 * 该算法为先随机生成一个奇数，然后判断该奇数是否为素数，若是则返回，
	 * 否则重新生生一个奇数
	 * 
	 * @return 返回一个随机素数
	 */
	private int produceBigPrimer(){
		Random r = new Random();
		int pos = r.nextInt(primers.length);
		System.out.println("======" + primers[pos]);
		return primers[pos];
	}
		
	/**素性检测函数
	 * 该函数封装的是Miller—Rabin素性检测法
	 * 
	 * @param n 待检测的数
	 * @return 若是素数，返回真，否则返回假
	 */
	public boolean isPrimer(int n){
		if (MillerRabin.millerRabin(n)){
			return true;
		}	
		return false;
	}
		
	/**求解 n 的欧拉函数值φ(n)
	 * 因为  n 是两个素数的乘积，所以 n 的欧拉函数值为φ(n)=（p-1）*（q-1）
	 * @return  返回  n 的欧拉函数值φ(n)
	 */
	public int eulerN(){
		return (this.bigPrimerP-1) * (this.bigPrimerQ-1);
	}
	
	/**计算 e(公钥) 的值
	 * 即寻找满足下列条件的e值：
	 * 1<e<φ(n) 且 gcd(φ(n),e)=1
	 * 
	 * @return  返回e的值
	 */
	public int CaculatePublicKey(){
		Random r = new Random();
		int e = r.nextInt(eulerN());//产生0-φ(n)之间的随机数
		while (!((e>1) && (euclid(e, eulerN())==1))){
			e = r.nextInt(eulerN());
		}
		return e;
	}
	
	/**计算d(私钥)的值
	 * 因为d是e在φ(n)下的乘法逆元
	 * 所以此处调用扩展的欧几里得算法
	 * 求解d值
	 * 
	 * @return 返回d的值
	 */
	public int CaculatePrivateKey(){
		
		return extendEuclid(this.eulerN(), this.getPublicKey());//调用扩展的欧几里得算法
	}
	
	/**扩展的欧几里得算法
	 *当gcd（n, e）= 1时，
	 *返回e的乘法逆元
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
	/**欧几里得算法
	 * 求两个数的最大公约数
	 * 
	 * @param x	待检测的数
	 * @param y 待检测的数
	 * @return  返回两个数的最大公约数
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
	/**RSA加密过程
	 * 
	 * @param m 明文
	 * @return 返回密文
	 */
	public int encode(int m){
		return modexp(m, this.publicKey, this.pmultiQN);
	}
	
	/**RSA解密过程
	 * 
	 * @param c 密文
	 * @return 返回明文
	 */
	public int decode(int c){
		return modexp(c, this.privateKey, this.pmultiQN);
	}
	
	/**计算a的m次方  mod n的值
	 * 运用模运算的性质，快速计算指数算法
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
