package com.atm.gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.*;
import com.atm.actionlistener.CancelButton;
import com.atm.actionlistener.IdCheckBox;
import com.atm.actionlistener.Login;
import com.atm.actionlistener.PasswordCheckBox;
import com.atm.actionlistener.RegisterokButton;
import com.atm.file.ATMFile;

/**
 * ��¼���棺�����û�������˺ź�����
 * @author �ܱ���
 */
public class Register extends JFrame {
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JLabel idLabel = null;
	private JLabel passwordLabel = null;
	private JTextField idTextField = null;
	private JPasswordField passwordTextField = null;
	private JCheckBox idCheckBox = null;
	private JCheckBox passwordCheckBox = null;
	private JButton cancelButton = null;
	private JButton okButton = null;
	private JButton login = null;
	private JPanel J1 = null;
	private JPanel J2 = null;
	private JPanel J3 = null;
	private JPanel J4 = null;
	private GridLayout g = null;
	private boolean bool1 = false;
	private boolean bool2 = false;

	public Register() {
		idLabel = new JLabel("�˺�");
		passwordLabel = new JLabel("����");
		idTextField = new JTextField(15);
		passwordTextField = new JPasswordField(15);
		load();
		idCheckBox = new JCheckBox("��ס�˺�", bool1);
		passwordCheckBox = new JCheckBox("��ס����", bool2);
		cancelButton = new JButton("ȡ��");
		okButton = new JButton("ȷ��");
		login = new JButton("ע��");
		J1 = new JPanel();
		J2 = new JPanel();
		J3 = new JPanel();
		J4 = new JPanel();
		g = new GridLayout(4, 1);
		J1.add(idLabel);
		J1.add(idTextField);
		J2.add(passwordLabel);
		J2.add(passwordTextField);
		J3.add(idCheckBox);
		J3.add(passwordCheckBox);
		J4.add(cancelButton);
		J4.add(okButton);
		J4.add(login);
		this.setLayout(g);
		this.add(J1);
		this.add(J2);
		this.add(J3);
		this.add(J4);
		this.setTitle("��¼");
		this.setLocation((width - 400) / 2, (height - 230) / 2);
		this.setSize(350, 210);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		cancelButton.addActionListener(new CancelButton());
		okButton.addActionListener(new RegisterokButton(this));
		login.addActionListener(new Login());
		idCheckBox.addItemListener(new IdCheckBox());
		passwordCheckBox.addItemListener(new PasswordCheckBox());
	}

	public JTextField getIdTextField() {
		return idTextField;
	}

	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}

	/**
	 * ���ļ��м����˺�����
	 */
	public void load() {
		//���ļ��ж�ȡ������ѡ��ĳ�ʼ״̬����ȡ�洢���˺ż�����
		//�ж��˺������Ƿ�Ϊ�գ���Ϊ�����Զ���Ϊ�ָ�������ַ����洢���ַ������У���Ϊ�գ��ַ����鸳ֵΪ��
		//�жϸ�ѡ���ֵ�Ƿ�Ϊtrue����Ϊtrue�� ��־��ѡ��ǰ״̬��ֵΪtrue�����õ�ǰ��������ֵ
		String str1 = ATMFile.read("src/bool1.txt");
		String str2 = ATMFile.read("src/bool2.txt");
		String str3 = ATMFile.read("src/info.txt");
		String[] split;
		if(str3 == null) {
			split = null;
		}else {
			split = str3.split(",");			
		}
		if (str1.trim().equals("true")) {
			bool1 = true;
			if(split != null) {
				idTextField.setText(split[0]);			
			}
		}
		if (str2.trim().equals("true")) {
			bool2 = true;
			if(split != null) {
				passwordTextField.setText(split[1].trim());				
			}
		}
	}
}