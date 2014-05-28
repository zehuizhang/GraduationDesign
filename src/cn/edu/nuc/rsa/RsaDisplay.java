package cn.edu.nuc.rsa;

import java.awt.Color;

import javax.swing.*;

public class RsaDisplay extends JFrame{
	
	JSplitPane splitPane = new JSplitPane();
	JPanel leftPanel = new JPanel();
	JPanel rightPanel = new JPanel();
	
	//left part
	private static final String KEYLABEL = "公钥私钥";
	private static final String BIG_PRIMER_P = "大素数P";
	private static final String BIG_PRIMER_Q = "大素数Q";
	private static final String PUBLIC_KEY = "公开钥E";
	private static final String PUBLIC_KEY_PAIR = "公开密钥";
	private static final String PRIVATE_KEY_PAIR = "秘密密钥";
	private static final String GENERATE_KEY = "点击生成密钥";
	private static final String RANDOM_GENERATE = "随机产生以上数";
	//right
	private static final String ENCRYPTION = "加密解密";
	private static final String PLAINT_TEXT = "明文";
	private static final String CIPHER_TEXT = "密文";
	private static final String ENCODE = "加密";
	private static final String DECODE = "解密";
	//left part 
	JLabel keyLabel = new JLabel(KEYLABEL, JLabel.CENTER);
	JLabel encryptionLabel = new JLabel(ENCRYPTION, JLabel.CENTER);
	JLabel bigPrimerPLabel = new JLabel(BIG_PRIMER_P);
	JLabel bigPrimerQLabel = new JLabel(BIG_PRIMER_Q);
	JLabel publicKeyLabel = new JLabel(PUBLIC_KEY);
	JLabel publicKeyPairLabel = new JLabel(PUBLIC_KEY_PAIR);
	JLabel privateKeyPairLabel = new JLabel(PRIVATE_KEY_PAIR);
	//right
	JLabel plaintTextLabel = new JLabel(PLAINT_TEXT);
	JLabel plaintTextLabelCopy = new JLabel(PLAINT_TEXT);
	JLabel cipherTextLabel = new JLabel(CIPHER_TEXT);
	//left part
	JTextField bigPrimerPText = new JTextField(15);
	JTextField bigPrimerQText = new JTextField(15);
	JTextField publicKeyText = new JTextField(15);
	JTextField publicKeyPair = new JTextField();
	JTextField privateKeyPair = new JTextField();
	//right
	JTextArea plaintTextArea = new JTextArea();
	JTextArea plaintTextAreaCopy = new JTextArea();
	JTextArea cipherTextArea = new JTextArea();
	//left part
	JButton generateKey = new JButton(GENERATE_KEY);
	JButton randomGenerateButton = new JButton(RANDOM_GENERATE);
	//right part
	JButton encodeButton = new JButton(ENCODE);
	JButton decodeButton = new JButton(DECODE);
	public RsaDisplay() {
		this.add(splitPane);
		splitPane.setLeftComponent(leftPanel);
		splitPane.setRightComponent(rightPanel);
		splitPane.setDividerSize(1);
		splitPane.setDividerLocation(400);
		
		
		//left part
		leftPanel.setLayout(null);
		//leftPanel.setBackground(Color.gray);
		leftPanel.add(keyLabel);
		leftPanel.add(bigPrimerPLabel);
		leftPanel.add(bigPrimerPText);
		leftPanel.add(bigPrimerQLabel);
		leftPanel.add(bigPrimerQText);
		leftPanel.add(publicKeyLabel);
		leftPanel.add(publicKeyText);
		leftPanel.add(randomGenerateButton);
		leftPanel.add(publicKeyPairLabel);
		leftPanel.add(publicKeyPair);
		leftPanel.add(privateKeyPairLabel);
		leftPanel.add(privateKeyPair);
		leftPanel.add(generateKey);
		keyLabel.setBounds(160, 25, 80, 25);
		bigPrimerPLabel.setBounds(85, 70, 80, 25);
		bigPrimerPText.setBounds(185, 70, 140, 25);
		bigPrimerQLabel.setBounds(85, 120, 80, 25);
		bigPrimerQText.setBounds(185, 120, 140, 25);
		publicKeyLabel.setBounds(85, 170, 80, 25);
		publicKeyText.setBounds(185, 170, 140, 25);
		randomGenerateButton.setBounds(130, 230, 140, 25);
		publicKeyPairLabel.setBounds(85, 330, 80, 25);
		publicKeyPair.setBounds(185, 330, 140, 25);
		privateKeyPairLabel.setBounds(85, 370, 80, 25);
		privateKeyPair.setBounds(185, 370, 140, 25);
		generateKey.setBounds(130, 440, 140, 25);
		
		//right part
		rightPanel.setLayout(null);
		rightPanel.add(encryptionLabel);
		rightPanel.add(plaintTextLabel);
		rightPanel.add(plaintTextLabelCopy);
		rightPanel.add(plaintTextArea);
		rightPanel.add(plaintTextAreaCopy);
		rightPanel.add(cipherTextLabel);
		rightPanel.add(cipherTextArea);
		rightPanel.add(encodeButton);
		rightPanel.add(decodeButton);
		encryptionLabel.setBounds(160, 25, 80, 25);
		plaintTextLabel.setBounds(80, 70, 80, 25);
		plaintTextArea.setBounds(160, 70, 160, 80);
		encodeButton.setBounds(260, 170, 60, 25);
		cipherTextLabel.setBounds(80, 235, 80, 25);
		cipherTextArea.setBounds(160, 235, 160, 80);
		decodeButton.setBounds(260, 335, 60, 25);
		plaintTextLabelCopy.setBounds(80, 390, 80, 25);
		plaintTextAreaCopy.setBounds(160, 390, 160, 80);
		
		
		this.setTitle("RSA加密算法");
		this.setSize(800, 600);
		this.setLocation(300, 80);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		RsaDisplay rsaDisplay = new RsaDisplay();
	}
}
