package com.atm.gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.atm.actionlistener.TransferMessageButton;
import com.atm.actionlistener.TransferOkButton;
import com.atm.usermessage.UserMessage;

/**
 * ת�˽���
 * @author �ܱ���
 *
 */
public class Transfer extends JFrame{
	private UserMessage usermessage = null;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JLabel idLabel = null;
	private JLabel moneyLabel = null;
	private JLabel passwordLabel = null;
	private JPasswordField password = null;
	private JTextField idTextField = null;
	private JTextField moneyTextField = null;
	private JButton messageButton = null;
	private JButton okButton = null;
	private JPanel J1 = null;
	private JPanel J2 = null;
	private JPanel J3 = null;
	private JPanel J4 = null;
	private GridLayout g = null;
	
	public Transfer(UserMessage usermessgge) {
		this.usermessage = usermessgge;
		idLabel = new JLabel("�˻�");
		moneyLabel = new JLabel("���");
		passwordLabel = new JLabel("����");
		password = new JPasswordField(15);
		idTextField = new JTextField(15);
		moneyTextField = new JTextField(15);
		messageButton = new JButton("ת����֪");
		okButton = new JButton("ȷ            ��");
		J1 = new JPanel();
		J2 = new JPanel();
		J3 = new JPanel();
		J4 = new JPanel();
		g = new GridLayout(4,1);
		this.setLayout(g);
		J1.add(idLabel);
		J1.add(idTextField);
		J2.add(moneyLabel);
		J2.add(moneyTextField);
		J4.add(passwordLabel);
		J4.add(password);
		J3.add(messageButton);
		J3.add(okButton);
		this.add(J1);
		this.add(J2);
		this.add(J4);
		this.add(J3);
		this.setTitle("ת��");
		this.setLocation((width - 320) / 2, (height - 180) / 2);
		this.setSize(320, 180);
		this.setResizable(false);
		this.setVisible(true);
		messageButton.addActionListener(new TransferMessageButton());
		okButton.addActionListener(new TransferOkButton(this));
	}

	public UserMessage getUsermessage() {
		return usermessage;
	}

	public JTextField getIdTextField() {
		return idTextField;
	}

	public JTextField getMoneyTextField() {
		return moneyTextField;
	}

	public JPasswordField getPassword() {
		return password;
	}	
}