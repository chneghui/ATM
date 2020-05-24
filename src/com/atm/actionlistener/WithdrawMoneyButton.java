package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.atm.gui.WithdrawMoney;
import com.atm.usermessage.UserMessage;

/**
 * 登录成功界面取钱按钮事件监听器
 * @author 周宝辉
 *
 */
public class WithdrawMoneyButton implements ActionListener{
	private UserMessage usermessage = null;
	public WithdrawMoneyButton(UserMessage usermessage) {
		this.usermessage = usermessage;
	}
	
	public void actionPerformed(ActionEvent e) {
		new WithdrawMoney(this.usermessage);
	}
}