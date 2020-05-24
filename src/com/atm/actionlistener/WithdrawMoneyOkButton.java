package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.atm.gui.WithdrawMoney;
import com.atm.jdbc.Find;
import com.atm.jdbc.Update;
import com.atm.usermessage.UserMessage;


/**
 * 取钱界面确定按钮事件监听器
 * @author 周宝辉
 *
 */
public class WithdrawMoneyOkButton implements ActionListener{
	private WithdrawMoney withdrawMoney = null;
	
	public WithdrawMoneyOkButton(WithdrawMoney withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	public void actionPerformed(ActionEvent e) {
		String inputMoney = withdrawMoney.getMoneyTextField().getText();//用户输入的存款金额
		if(inputMoney.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入取款金额", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int inputMoneyInt = Integer.parseInt(inputMoney);
		if(inputMoneyInt < 100 || inputMoneyInt % 100 != 0) {
			JOptionPane.showMessageDialog(null, "取款金额必须大于100并且金额是100的倍数", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql1 = "select usermoney from usermessage where userid = ?";
		UserMessage find = Find.find(UserMessage.class, sql1, withdrawMoney.getUsermessage().getUserid());
		String idMoney = find.getUsermoney();//用户账户当前的余额
		int idMonryInt = Integer.parseInt(idMoney);
		if(inputMoneyInt > idMonryInt) {
			JOptionPane.showMessageDialog(null, "账户余额不足", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int money = idMonryInt - inputMoneyInt;
		String moneyC = String.valueOf(money);
		String sql = "update usermessage set usermoney = ? where userid = ?";
		int count = Update.update(sql, moneyC, withdrawMoney.getUsermessage().getUserid());
		if(count <= 0) {
			JOptionPane.showMessageDialog(null, "取款失败", "消息框", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "取款成功", "消息框", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}