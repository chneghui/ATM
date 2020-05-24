package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.atm.gui.SaveMoney;
import com.atm.usermessage.UserMessage;

/**
 * ��¼�ɹ������Ǯ��ť�¼�������
 * @author �ܱ���
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
