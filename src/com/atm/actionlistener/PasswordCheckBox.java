package com.atm.actionlistener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.atm.file.ATMFile;

/**
 * 登录界面记住密码按钮事件监听器
 * @author 周宝辉
 *
 */
public class PasswordCheckBox implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		String flag = ATMFile.read("src/bool2.txt");
		if(flag.equals("true")) {
			ATMFile.write("false", "src/bool2.txt");			
		}else {
			ATMFile.write("true", "src/bool2.txt");
		}
	}
}
