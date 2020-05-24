package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.atm.gui.ChangePassword;
import com.atm.jdbc.Update;

/**
 * �޸��������ȷ����ť�¼�������
 * @author �ܱ���
 *
 */
public class ChangePasswordOkButton implements ActionListener{
	private ChangePassword changePassword = null;
	
	public ChangePasswordOkButton(ChangePassword changePassword) {
		this.changePassword = changePassword;
	}
	
	public void actionPerformed(ActionEvent e) {
		//��ȡ�û�����ľ����룬�жϾ������Ƿ���ȷ
		String usedPassword = changePassword.getUsedPasswordTextField().getText();
		if(!usedPassword.equals(changePassword.getUsermessage().getUserpassword())) {
			JOptionPane.showMessageDialog(null, "�����벻��ȷ��������","��Ϣ��",JOptionPane.ERROR_MESSAGE);
			return;
		}
		//��ȡ�û�����ĵ�һ�ε������룬�ж������볤���Ƿ�Ϊ6λ���Ƿ��з�����
		String newPassword1 = changePassword.getNewPasswordTextField1().getText();
		if(newPassword1.length() != 6) {
			JOptionPane.showMessageDialog(null, "���볤��Ϊ6λ��������","��Ϣ��",JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(int i = 0; i < newPassword1.length(); i++) {
			char temp = newPassword1.charAt(i);
			if(!Character.isDigit(temp)) {
				JOptionPane.showMessageDialog(null, "����ֻ�������֣�������","��Ϣ��",JOptionPane.ERROR_MESSAGE);
				return;
			}	
		}
		//����������ִ�е��˴���˵��������͵�һ�ε������붼�Ϸ�
		//���Դ˴���ȡ�ڶ��ε������룬�жϵڶ��ε��������Ƿ�͵�һ�ε���������ͬ
		String newPassword2 = changePassword.getNewPasswordTextField2().getText();
		if(!newPassword1.equals(newPassword2)) {
			JOptionPane.showMessageDialog(null, "�����������벻һ�£�������","��Ϣ��",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql = "update usermessage set userpassword = ? where userid = ?";
		int count = Update.update(sql, newPassword1,changePassword.getUsermessage().getUserid());
		if(count <= 0) {
			JOptionPane.showMessageDialog(null, "�޸�ʧ�ܣ�������","��Ϣ��",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�","��Ϣ��",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}