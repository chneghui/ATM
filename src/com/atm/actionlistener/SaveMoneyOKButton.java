package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.atm.gui.SaveMoney;
import com.atm.jdbc.Find;
import com.atm.jdbc.Update;
import com.atm.usermessage.UserMessage;

/**
 * 存钱界面确定按钮事件监听器
 * @author 周宝辉
 *
 */
public class SaveMoneyOKButton implements ActionListener{
	private SaveMoney saveMoney = null;
	
	public SaveMoneyOKButton(SaveMoney saveMoney) {
		this.saveMoney = saveMoney;
	}

	public void actionPerformed(ActionEvent e) {
		String inputMoney = saveMoney.getMoneyTextField().getText();//用户输入的存款金额
		if(inputMoney.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入存款金额", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int inputMoneyInt = Integer.parseInt(inputMoney);
		if(inputMoneyInt < 100 || inputMoneyInt % 100 != 0) {
			JOptionPane.showMessageDialog(null, "存款金额必须大于100并且金额是100的倍数", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql1 = "select usermoney from usermessage where userid = ?";
		UserMessage find = Find.find(UserMessage.class, sql1, saveMoney.getUsermessage().getUserid());
		String idMoney = find.getUsermoney();//用户账户当前的余额
		int idMonryInt = Integer.parseInt(idMoney);
		int money = idMonryInt + inputMoneyInt;
		String moneyC = String.valueOf(money);
		String sql = "update usermessage set usermoney = ? where userid = ?";
		int count = Update.update(sql, moneyC, saveMoney.getUsermessage().getUserid());
		if(count <= 0) {
			JOptionPane.showMessageDialog(null, "存款失败", "消息框", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "存款成功", "消息框", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}