package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import com.atm.gui.ChangePassword;
import com.atm.jdbc.Update;

/**
 * 修改密码界面确定按钮事件监听器
 * @author 周宝辉
 *
 */
public class ChangePasswordOkButton implements ActionListener{
	private ChangePassword changePassword = null;
	
	public ChangePasswordOkButton(ChangePassword changePassword) {
		this.changePassword = changePassword;
	}
	
	public void actionPerformed(ActionEvent e) {
		//获取用户输入的旧密码，判断旧密码是否正确
		String usedPassword = changePassword.getUsedPasswordTextField().getText();
		if(!usedPassword.equals(changePassword.getUsermessage().getUserpassword())) {
			JOptionPane.showMessageDialog(null, "旧密码不正确，请重试","消息框",JOptionPane.ERROR_MESSAGE);
			return;
		}
		//获取用户输入的第一次的新密码，判断新密码长度是否为6位，是否含有非数字
		String newPassword1 = changePassword.getNewPasswordTextField1().getText();
		if(newPassword1.length() != 6) {
			JOptionPane.showMessageDialog(null, "密码长度为6位，请重试","消息框",JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(int i = 0; i < newPassword1.length(); i++) {
			char temp = newPassword1.charAt(i);
			if(!Character.isDigit(temp)) {
				JOptionPane.showMessageDialog(null, "密码只能是数字，请重试","消息框",JOptionPane.ERROR_MESSAGE);
				return;
			}	
		}
		//如果程序可以执行到此处，说明旧密码和第一次的新密码都合法
		//所以此处获取第二次的新密码，判断第二次的新密码是否和第一次的新密码相同
		String newPassword2 = changePassword.getNewPasswordTextField2().getText();
		if(!newPassword1.equals(newPassword2)) {
			JOptionPane.showMessageDialog(null, "两次密码输入不一致，请重试","消息框",JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql = "update usermessage set userpassword = ? where userid = ?";
		int count = Update.update(sql, newPassword1,changePassword.getUsermessage().getUserid());
		if(count <= 0) {
			JOptionPane.showMessageDialog(null, "修改失败，请重试","消息框",JOptionPane.ERROR_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "修改成功","消息框",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}