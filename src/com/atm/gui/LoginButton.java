package com.atm.gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.atm.actionlistener.LoginOkButton;

/**
 * ע�����
 * @author �ܱ���
 *
 */
public class LoginButton extends JFrame {
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JLabel nameLabel = null;
	private JLabel sexLabel = null;
	private JLabel phoneLabel = null;
	private JLabel homeLabel = null;
	private JLabel passwordLabel = null;
	private JTextField nameTextField = null;
	private JComboBox<String> sexComboBox = null;
	private JTextField phoneTextField = null;
	private JTextField homeTextField = null;
	private JPasswordField passwordTextField = null;
	private JButton okButton = null;
	private JPanel J1 = null;
	private JPanel J2 = null;
	private JPanel J3 = null;
	private JPanel J4 = null;
	private JPanel J5 = null;
	private JPanel J6 = null;
	private GridLayout g = null;

	public LoginButton() {
		nameLabel = new JLabel("����");
		sexLabel = new JLabel("�Ա�");
		phoneLabel = new JLabel("�绰");
		homeLabel = new JLabel("סַ");
		passwordLabel = new JLabel("����");
		nameTextField = new JTextField(15);
		sexComboBox = new JComboBox<>();
		phoneTextField = new JTextField(15);
		homeTextField = new JTextField(15);
		passwordTextField = new JPasswordField(15);
		sexComboBox.addItem("��");
		sexComboBox.addItem("Ů");
		sexComboBox.addItem("ռλ��ռλ��������ѡ��");
		okButton = new JButton("ȷ��");
		J1 = new JPanel();
		J2 = new JPanel();
		J3 = new JPanel();
		J4 = new JPanel();
		J5 = new JPanel();
		J6 = new JPanel();
		g = new GridLayout(6, 1);
		this.setLayout(g);
		J1.add(nameLabel);
		J1.add(nameTextField);
		J2.add(sexLabel);
		J2.add(sexComboBox);
		J3.add(phoneLabel);
		J3.add(phoneTextField);
		J4.add(homeLabel);
		J4.add(homeTextField);
		J5.add(passwordLabel);
		J5.add(passwordTextField);
		J6.add(okButton);
		this.add(J1);
		this.add(J2);
		this.add(J3);
		this.add(J4);
		this.add(J5);
		this.add(J6);
		this.setTitle("��ӭע��");
		this.setLocation((width - 400) / 2, (height - 300) / 2);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setVisible(true);
		okButton.addActionListener(new LoginOkButton(this));
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JComboBox<String> getSexComboBox() {
		return sexComboBox;
	}

	public JTextField getPhoneTextField() {
		return phoneTextField;
	}

	public JTextField getHomeTextField() {
		return homeTextField;
	}

	public JPasswordField getPasswordTextField() {
		return passwordTextField;
	}
}