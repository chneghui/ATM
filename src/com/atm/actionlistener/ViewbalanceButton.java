package com.atm.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.atm.jdbc.Find;
import com.atm.usermessage.UserMessage;

/**
 * 登录成功界面查看余额按钮事件监听器
 * @author 周宝辉
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
		JOptionPane.showMessageDialog(null, "您的账户余额为：" + find.getUsermoney() + "￥", "消息框", JOptionPane.INFORMATION_MESSAGE);
	}
}