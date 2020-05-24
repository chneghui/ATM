package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.atm.gui.WithdrawMoney;
import com.atm.usermessage.UserMessage;

/**
 * ��¼�ɹ�����ȡǮ��ť�¼�������
 * @author �ܱ���
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