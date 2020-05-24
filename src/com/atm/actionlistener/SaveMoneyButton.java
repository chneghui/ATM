package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.atm.gui.SaveMoney;
import com.atm.usermessage.UserMessage;

/**
 * 登录成功界面存钱按钮事件监听器
 * @author 周宝辉
 *
 */
public class SaveMoneyButton implements ActionListener{
	private UserMessage usermessage = null;
	public SaveMoneyButton(UserMessage usermessage) {
		this.usermessage = usermessage;
	}
	
	public void actionPerformed(ActionEvent e) {
		new SaveMoney(this.usermessage);
	}
}
