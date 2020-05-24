package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.atm.gui.SaveMoney;
import com.atm.jdbc.Find;
import com.atm.jdbc.Update;
import com.atm.usermessage.UserMessage;

/**
 * ��Ǯ����ȷ����ť�¼�������
 * @author �ܱ���
 *
 */
public class SaveMoneyOKButton implements ActionListener{
	private SaveMoney saveMoney = null;
	
	public SaveMoneyOKButton(SaveMoney saveMoney) {
		this.saveMoney = saveMoney;
	}

	public void actionPerformed(ActionEvent e) {
		String inputMoney = saveMoney.getMoneyTextField().getText();//�û�����Ĵ����
		if(inputMoney.equals("")) {
			JOptionPane.showMessageDialog(null, "����������", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int inputMoneyInt = Integer.parseInt(inputMoney);
		if(inputMoneyInt < 100 || inputMoneyInt % 100 != 0) {
			JOptionPane.showMessageDialog(null, "�����������100���ҽ����100�ı���", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql1 = "select usermoney from usermessage where userid = ?";
		UserMessage find = Find.find(UserMessage.class, sql1, saveMoney.getUsermessage().getUserid());
		String idMoney = find.getUsermoney();//�û��˻���ǰ�����
		int idMonryInt = Integer.parseInt(idMoney);
		int money = idMonryInt + inputMoneyInt;
		String moneyC = String.valueOf(money);
		String sql = "update usermessage set usermoney = ? where userid = ?";
		int count = Update.update(sql, moneyC, saveMoney.getUsermessage().getUserid());
		if(count <= 0) {
			JOptionPane.showMessageDialog(null, "���ʧ��", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "���ɹ�", "��Ϣ��", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}