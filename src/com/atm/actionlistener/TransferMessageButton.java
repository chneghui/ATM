package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * ת�˽���ת����֪��ť�¼�������
 * @author �ܱ���
 *
 */
public class TransferMessageButton implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "����ת����ѣ�����ת����ȡ1%������", "ת����֪", JOptionPane.INFORMATION_MESSAGE);
	}
}