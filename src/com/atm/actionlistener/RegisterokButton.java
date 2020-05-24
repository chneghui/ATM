package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.atm.file.ATMFile;
import com.atm.gui.Register;
import com.atm.gui.RegisterOk;
import com.atm.jdbc.Find;
import com.atm.usermessage.UserMessage;

/**
 * ��¼����ȷ����ť�¼�������
 * �ص㣺���Ρ��û�������˺ź�������Register���б��棬�����޷�ֱ�ӷ���
 * ��ˣ���Register������ӷ����˻�������ķ��������ñ��๹�췽��ʱ����һ��Register���͵Ĳ���
 * �����ݵĲ�����ֵ��������Register�������ͨ���������get�������ɵõ��û�������˺ź�����
 * @author �ܱ���
 *
 */
public class RegisterokButton implements ActionListener {
	private Register register = null;

	public RegisterokButton(Register register) {
		this.register = register;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String id = register.getIdTextField().getText();
		String password = register.getPasswordTextField().getText();
		if(id.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(null, "�������˺Ż�����", "��Ϣ��",JOptionPane.ERROR_MESSAGE);
		}else {
			String sql = "select * from usermessage where userid = ? and userpassword = ?";
			//ʹ��UserMessage���󱣴淵��ֵ�����û��������Ϣ��ȷʱ��UserMessage�����б����Ÿ��û���ȫ����Ϣ
			//��������ʹ�ô˶�����Ϊ��������
			UserMessage usermessage = Find.find(UserMessage.class, sql, id, password);
			if(usermessage != null) {
				new RegisterOk(usermessage);
				//���û����˺�����д�뵽�ļ���
				String filepath = "src/info.txt";
				String str = usermessage.getUserid() + "," + usermessage.getUserpassword();
				ATMFile.write(str, filepath);
			}else {
				JOptionPane.showMessageDialog(null, "�˺Ż��������", "��Ϣ��",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}