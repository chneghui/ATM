package com.atm.gui;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.atm.actionlistener.CancelButton;
import com.atm.actionlistener.SaveMoneyButton;
import com.atm.actionlistener.TransferButton;
import com.atm.actionlistener.ViewbalanceButton;
import com.atm.actionlistener.WithdrawMoneyButton;
import com.atm.actionlistener.ChangePasswordButton;
import com.atm.usermessage.UserMessage;

/**
 * 登录成功界面
 * @author 周宝辉
 *
 */
public class RegisterOk extends JFrame {
	private UserMessage usermessage = null;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private JButton saveMoney = null;// 存钱
	private JButton withdrawMoney = null;// 取钱
	private JButton viewbalance = null;// 查看余额
	private JButton transfer = null;// 转账
	private JButton changePassword = null;// 修改密码
	private JButton cancel = null;// 退出
	private JLabel label1 = null;
	private JLabel label2 = null;
	private JLabel label3 = null;
	private GridLayout g = null;
	private JPanel J1 = null;
	private JPanel J2 = null;
	private JPanel J3 = null;

	public RegisterOk(UserMessage usermessage) {
		this.usermessage = usermessage;
		saveMoney = new JButton("存         款");
		withdrawMoney = new JButton("取         款");
		viewbalance = new JButton("查看余额");
		transfer = new JButton("转         账");
		changePassword = new JButton("修改密码");
		cancel = new JButton("退         出");
		StringBuilder st1 = new StringBuilder();
		Calendar calendar1 = Calendar.getInstance();
		st1.append(calendar1.get(Calendar.YEAR));
		st1.append("-");
		st1.append(calendar1.get(Calendar.MONTH));
		st1.append("-");
		st1.append(calendar1.get(Calendar.DATE));
		StringBuilder st2 = new StringBuilder();
		Calendar calendar2 = Calendar.getInstance();
		st2.append(calendar2.get(Calendar.HOUR_OF_DAY));
		st2.append(":");
		st2.append(calendar2.get(Calendar.MINUTE));
		st2.append(":");
		st2.append(calendar2.get(Calendar.SECOND));
		label1 = new JLabel("        欢迎使用        ");
		label2 = new JLabel("       " + st1.toString() + "       ");
		label3 = new JLabel("         " + st2.toString() + "         ");
		J1 = new JPanel();
		J2 = new JPanel();
		J3 = new JPanel();
		g = new GridLayout(3, 3);
		this.setLayout(g);
		J1.add(saveMoney);
		J1.add(label1);
		J1.add(withdrawMoney);
		J2.add(viewbalance);
		J2.add(label2);
		J2.add(transfer);
		J3.add(changePassword);
		J3.add(label3);
		J3.add(cancel);
		this.add(J1);
		this.add(J2);
		this.add(J3);
		this.setTitle("欢迎使用");
		this.setSize(330, 400);
		this.setLocation((width - 330) / 2, (height - 400) / 2);
		this.setResizable(false);
		this.setVisible(true);
		saveMoney.addActionListener(new SaveMoneyButton(this.usermessage));
		withdrawMoney.addActionListener(new WithdrawMoneyButton(this.usermessage));
		viewbalance.addActionListener(new ViewbalanceButton(this.usermessage));
		transfer.addActionListener(new TransferButton(this.usermessage));
		changePassword.addActionListener(new ChangePasswordButton(this.usermessage));
		cancel.addActionListener(new CancelButton());
	}	
}