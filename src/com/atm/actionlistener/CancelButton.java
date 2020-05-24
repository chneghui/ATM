package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 取消事件监听器
 * @author 周宝辉
 *
 */
public class CancelButton implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}	
}
