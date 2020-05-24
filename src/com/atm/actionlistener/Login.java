package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.atm.gui.LoginButton;

/**
 * 登录解界面注册按钮事件监听器
 * @author 周宝辉
 *
 */
public class Login implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginButton();
	}
}