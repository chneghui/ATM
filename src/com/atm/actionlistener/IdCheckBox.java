package com.atm.actionlistener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.atm.file.ATMFile;

/**
 * 登录界面记住账号按钮事件监听器
 * @author 周宝辉
 *
 */
public class IdCheckBox implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		//当执行该代码时说明用户想改变复选框的状态
		//先获取当前复选框的状态
		//当前状态为true则修改为false，反之亦然
		String flag = ATMFile.read("src/bool1.txt");
		if(flag.equals("true")) {
			ATMFile.write("false", "src/bool1.txt");			
		}else {
			ATMFile.write("true", "src/bool1.txt");
		}
	}
}
