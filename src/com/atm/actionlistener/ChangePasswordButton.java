package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.atm.gui.ChangePassword;
import com.atm.usermessage.UserMessage;

/**
 *登录成功界面修改密码按钮事件监听器
 * @author 周宝辉
 *
 */
public class ChangePasswordButton implements ActionListener {
	private UserMessage usermessage = null;

	public ChangePasswordButton(UserMessage usermessage) {
		this.usermessage = usermessage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new ChangePassword(usermessage);
	}
}
