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
 * 登录界面：保存用户输入的账号和密码
 * @author 周宝辉
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
		idLabel = new JLabel("账号");
		passwordLabel = new JLabel("密码");
		idTextField = new JTextField(15);
		passwordTextField = new JPasswordField(15);
		load();
		idCheckBox = new JCheckBox("记住账号", bool1);
		passwordCheckBox = new JCheckBox("记住密码", bool2);
		cancelButton = new JButton("取消");
		okButton = new JButton("确定");
		login = new JButton("注册");
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
		this.setTitle("登录");
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
	 * 从文件中加载账号密码
	 */
	public void load() {
		//从文件中读取两个复选框的初始状态，读取存储的账号及密码
		//判断账号密码是否为空，不为空则以逗号为分隔符拆分字符，存储在字符数组中，若为空，字符数组赋值为空
		//判断复选框的值是否为true，若为true则 标志复选框当前状态的值为true，设置当前的输入框的值
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