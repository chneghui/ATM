package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.atm.gui.LoginButton;

/**
 * ��¼�����ע�ᰴť�¼�������
 * @author �ܱ���
 *
 */
public class Login implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		new LoginButton();
	}
}