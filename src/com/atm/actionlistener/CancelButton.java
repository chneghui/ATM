package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ȡ���¼�������
 * @author �ܱ���
 *
 */
public class CancelButton implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}	
}
