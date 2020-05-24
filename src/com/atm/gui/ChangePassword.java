package com.atm.gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.atm.actionlistener.ChangePasswordOkButton;
import com.atm.usermessage.UserMessage;

/**
 * 修改密码界面
 * @author 周宝辉
 *
 */
public class ChangePassword extends JFrame{
	private UserMessage usermessage = null;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JLabel usedPasswordLabel = null;
	private JLabel newPassword1Label = null;
	private JLabel newPassword2Label = null;
	private JPasswordField usedPasswordTextField = null;
	private JPasswordField newPasswordTextField1 = null;
	private JPasswordField newPasswordTextField2 = null;
	private JButton okButton = null;
	private JPanel J1 = null;
	private JPanel J2 = null;
	private JPanel J3 = null;
	private GridLayout g = null;
	
	public ChangePassword(UserMessage usermessage) {
		this.usermessage = usermessage;
		usedPasswordLabel = new JLabel("请输入旧密码        ");
		newPassword1Label = new JLabel("请输入新密码        ");
		newPassword2Label = new JLabel("请再次输入新密码");
		usedPasswordTextField = new JPasswordField(15);
		newPasswordTextField1 = new JPasswordField(15);
		newPasswordTextField2 = new JPasswordField(15);
		okButton = new JButton("确定");
		J1 = new JPanel();
		J2 = new JPanel();
		J3 = new JPanel();
		g =new GridLayout(4,1);
		this.setLayout(g);
		J1.add(usedPasswordLabel);
		J1.add(usedPasswordTextField);
		J2.add(newPassword1Label);
		J2.add(newPasswordTextField1);
		J3.add(newPassword2Label);
		J3.add(newPasswordTextField2);
		this.add(J1);
		this.add(J2);
		this.add(J3);
		this.add(okButton);
		this.setTitle("修改密码");
		this.setLocation((width - 330) / 2, (height - 240) / 2);
		this.setSize(330, 240);
		this.setResizable(false);
		this.setVisible(true);
		okButton.addActionListener(new ChangePasswordOkButton(this));
	}

	public UserMessage getUsermessage() {
		return usermessage;
	}

	public JPasswordField getUsedPasswordTextField() {
		return usedPasswordTextField;
	}

	public JPasswordField getNewPasswordTextField1() {
		return newPasswordTextField1;
	}

	public JPasswordField getNewPasswordTextField2() {
		return newPasswordTextField2;
	}
}