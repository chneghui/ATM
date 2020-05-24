package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.atm.gui.LoginButton;
import com.atm.jdbc.Find;
import com.atm.jdbc.Update;
import com.atm.usermessage.UserMessage;

/**
 * ע�����ȷ����ť�¼�������
 * @author �ܱ���
 *
 */
public class LoginOkButton implements ActionListener {
	private LoginButton lb = null;

	public LoginOkButton(LoginButton lb) {
		this.lb = lb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = lb.getNameTextField().getText();
		String sex = (String) lb.getSexComboBox().getSelectedItem();
		String phone = lb.getPhoneTextField().getText();
		String home = lb.getHomeTextField().getText();
		String password = lb.getPasswordTextField().getText();
		if (name == null || phone == null || home == null || password == null || password.length() != 6) {
			JOptionPane.showMessageDialog(null, "������Ϣ����Ϊ�������볤��Ϊ6λ", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
			return;
		}
		for (int i = 0; i < password.length(); i++) {
			char temp = password.charAt(i);
			boolean result = Character.isDigit(temp);
			if (!result) {
				JOptionPane.showMessageDialog(null, "����ֻ��������", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		//�����˺�
		String userid = "6193823417890000";
		for(int i = 0; i < 3; i++) {
			int temp = (int)(Math.random()*10);
			userid += String.valueOf(temp);
		}		
		//��֤�˺��Ƿ��Ѵ���
		String sql1 = "select * from usermessage where userid=?";
		UserMessage find = Find.find(UserMessage.class, sql1, userid);
		System.out.println(find);
		String sql2 = "insert into usermessage values(?,?,?,?,?,?,?)";
		int update = Update.update(sql2, userid,password,"0", name,sex,phone, home);
		if(update <= 0) {
			JOptionPane.showMessageDialog(null, "ע��ʧ�ܣ����Ժ�����", "��Ϣ��", JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "ע��ɹ�", "��Ϣ��", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}