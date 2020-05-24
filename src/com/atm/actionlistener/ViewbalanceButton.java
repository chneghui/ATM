package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.atm.jdbc.Find;
import com.atm.usermessage.UserMessage;

/**
 * ��¼�ɹ�����鿴��ť�¼�������
 * @author �ܱ���
 *
 */
public class ViewbalanceButton implements ActionListener{
	private UserMessage usermessage = null;
	
	public ViewbalanceButton(UserMessage usermessage) {
		this.usermessage = usermessage;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String userid = usermessage.getUserid();
		String sql = "select usermoney from usermessage where userid = ?";
		UserMessage find = Find.find(UserMessage.class, sql, userid);
		JOptionPane.showMessageDialog(null, "�����˻����Ϊ��" + find.getUsermoney() + "��", "��Ϣ��", JOptionPane.INFORMATION_MESSAGE);
	}
}