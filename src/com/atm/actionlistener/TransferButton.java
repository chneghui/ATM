package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.atm.gui.Transfer;
import com.atm.usermessage.UserMessage;

/**
 * ��¼�ɹ�����ת�˰�ť�¼�������
 * @author �ܱ���
 *
 */
public class TransferButton implements ActionListener{
	private UserMessage usermessage = null;
	
	public TransferButton(UserMessage usermessgge) {
		this.usermessage = usermessgge;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Transfer(usermessage);
	}
}