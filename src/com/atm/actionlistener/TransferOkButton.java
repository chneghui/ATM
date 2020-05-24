package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import com.atm.gui.Transfer;
import com.atm.jdbc.Find;
import com.atm.jdbc.JDBC;
import com.atm.jdbc.Update;
import com.atm.usermessage.UserMessage;

/**
 * ת�˽���ȷ����ť�¼�������
 * @author �ܱ���
 *
 */
public class TransferOkButton implements ActionListener{
	private Transfer transfer = null;
	
	public TransferOkButton(Transfer transfer) {
		this.transfer = transfer;
	}

	public void actionPerformed(ActionEvent e) {
		//�ж��û�������˺��Ƿ����
		String id = transfer.getIdTextField().getText();
		if(id.equals("")) {
			JOptionPane.showMessageDialog(null, "�������˺�", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql1 = "select * from usermessage where userid = ?";
		UserMessage find = Find.find(UserMessage.class, sql1, id);
		if(find == null || find.getUserid().equals(transfer.getUsermessage().getUserid())) {
			JOptionPane.showMessageDialog(null, "��������˻������ڻ��ܸ��Լ��˻�ת��", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//�ж��û�����Ľ���Ƿ�Ϸ�
		String money = transfer.getMoneyTextField().getText();
		if(money.equals("")) {
			JOptionPane.showMessageDialog(null, "��������", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int moneyInt = Integer.parseInt(money);
		if(moneyInt < 100 || moneyInt % 100 != 0) {
			JOptionPane.showMessageDialog(null, "���������100�ı���", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//�ж��û�����Ƿ����
		String sql2 = "select * from usermessage where userid = ?";
		UserMessage find2 = Find.find(UserMessage.class, sql2, transfer.getUsermessage().getUserid());
		String idMoney = find2.getUsermoney();
		int idMoneyInt = Integer.parseInt(idMoney);
		if(moneyInt > idMoneyInt) {
			JOptionPane.showMessageDialog(null, "�����˻�����", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//�ж������Ƿ���ȷ
		String password = transfer.getPassword().getText();
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null, "����������", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!password.equals(find2.getUserpassword())) {
			JOptionPane.showMessageDialog(null, "�������", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//�ж��Ƿ��Ǳ����˻�		
		int idmoney1 = Integer.parseInt(find.getUsermoney()) + moneyInt;
		String idmoneyString1 = String.valueOf(idmoney1);//��ת�˵��˻����
		int idmoney2 = idMoneyInt - moneyInt;
		String idmoneyString2 = String.valueOf(idmoney2);//ת���˻����
		if(!find.getUserid().startsWith("6193823417890000")) {
			int tempMoney = (int)(moneyInt * 0.01);
			idmoney2 = idMoneyInt - moneyInt - tempMoney;
			idmoneyString2 = String.valueOf(idmoney2);
		}
		String sql3 = "update usermessage set usermoney = ? where userid = ?";
		String sql4 = "update usermessage set usermoney = ? where userid = ?";
		Connection conn = null;
		try {
			conn = JDBC.getmysql();
			conn.setAutoCommit(false);
			Update.update2(conn, sql3, idmoneyString1, find.getUserid());		
			Update.update2(conn, sql4, idmoneyString2, find2.getUserid());
			conn.commit();
			JOptionPane.showMessageDialog(null, "ת�˳ɹ�", "��Ϣ��", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "ת��ʧ�ܣ�������", "��Ϣ��", JOptionPane.INFORMATION_MESSAGE);
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e1.printStackTrace();
		}finally {
			JDBC.closeResourse(conn, null, null);
		}
	}
}