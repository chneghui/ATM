package com.atm.gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.atm.actionlistener.WithdrawMoneyOkButton;
import com.atm.usermessage.UserMessage;

/**
 * ȡ�����
 * @author �ܱ���
 *
 */
public class WithdrawMoney extends JFrame{
	private UserMessage usermessage = null;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JLabel moneyLabel = null;
	private JTextField moneyTextField = null;
	private JButton okButton = null;
	private JPanel J1 = null;
	private GridLayout g = null;
	public WithdrawMoney(UserMessage usermessage) {
		this.usermessage = usermessage;
		moneyLabel = new JLabel("���");
		moneyTextField = new JTextField(15);
		okButton = new JButton("ȷ��");
		J1 = new JPanel();
		g = new GridLayout(2,1);
		this.setLayout(g);
		J1.add(moneyLabel);
		J1.add(moneyTextField);
		this.add(J1);
		this.add(okButton);
		this.setTitle("ȡ��");
		this.setLocation((width - 250) / 2, (height - 140) / 2);
		this.setSize(250, 140);
		this.setResizable(false);
		this.setVisible(true);	
		okButton.addActionListener(new WithdrawMoneyOkButton(this));	
	}
	public UserMessage getUsermessage() {
		return usermessage;
	}
	
	public JTextField getMoneyTextField() {
		return moneyTextField;
	}	
}