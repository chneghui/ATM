package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.atm.gui.WithdrawMoney;
import com.atm.jdbc.Find;
import com.atm.jdbc.Update;
import com.atm.usermessage.UserMessage;


/**
 * ȡǮ����ȷ����ť�¼�������
 * @author �ܱ���
 *
 */
public class WithdrawMoneyOkButton implements ActionListener{
	private WithdrawMoney withdrawMoney = null;
	
	public WithdrawMoneyOkButton(WithdrawMoney withdrawMoney) {
		this.withdrawMoney = withdrawMoney;
	}

	public void actionPerformed(ActionEvent e) {
		String inputMoney = withdrawMoney.getMoneyTextField().getText();//�û�����Ĵ����
		if(inputMoney.equals("")) {
			JOptionPane.showMessageDialog(null, "������ȡ����", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int inputMoneyInt = Integer.parseInt(inputMoney);
		if(inputMoneyInt < 100 || inputMoneyInt % 100 != 0) {
			JOptionPane.showMessageDialog(null, "ȡ����������100���ҽ����100�ı���", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql1 = "select usermoney from usermessage where userid = ?";
		UserMessage find = Find.find(UserMessage.class, sql1, withdrawMoney.getUsermessage().getUserid());
		String idMoney = find.getUsermoney();//�û��˻���ǰ�����
		int idMonryInt = Integer.parseInt(idMoney);
		if(inputMoneyInt > idMonryInt) {
			JOptionPane.showMessageDialog(null, "�˻�����", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int money = idMonryInt - inputMoneyInt;
		String moneyC = String.valueOf(money);
		String sql = "update usermessage set usermoney = ? where userid = ?";
		int count = Update.update(sql, moneyC, withdrawMoney.getUsermessage().getUserid());
		if(count <= 0) {
			JOptionPane.showMessageDialog(null, "ȡ��ʧ��", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "ȡ��ɹ�", "��Ϣ��", JOptionPane.INFORMATION_MESSAGE);
		}	
	}
}