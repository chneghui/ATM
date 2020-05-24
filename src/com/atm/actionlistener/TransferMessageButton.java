package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * 转账界面转账须知按钮事件监听器
 * @author 周宝辉
 *
 */
public class TransferMessageButton implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "本行转账免费，跨行转账收取1%手续费", "转账须知", JOptionPane.INFORMATION_MESSAGE);
	}
}