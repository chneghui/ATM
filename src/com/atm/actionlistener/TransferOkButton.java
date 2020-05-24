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
 * 转账界面确定按钮事件监听器
 * @author 周宝辉
 *
 */
public class TransferOkButton implements ActionListener{
	private Transfer transfer = null;
	
	public TransferOkButton(Transfer transfer) {
		this.transfer = transfer;
	}

	public void actionPerformed(ActionEvent e) {
		//判断用户输入的账号是否存在
		String id = transfer.getIdTextField().getText();
		if(id.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入账号", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		String sql1 = "select * from usermessage where userid = ?";
		UserMessage find = Find.find(UserMessage.class, sql1, id);
		if(find == null || find.getUserid().equals(transfer.getUsermessage().getUserid())) {
			JOptionPane.showMessageDialog(null, "您输入的账户不存在或不能给自己账户转账", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//判断用户输入的金额是否合法
		String money = transfer.getMoneyTextField().getText();
		if(money.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入金额", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		int moneyInt = Integer.parseInt(money);
		if(moneyInt < 100 || moneyInt % 100 != 0) {
			JOptionPane.showMessageDialog(null, "请输入大于100的倍数", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//判断用户余额是否充足
		String sql2 = "select * from usermessage where userid = ?";
		UserMessage find2 = Find.find(UserMessage.class, sql2, transfer.getUsermessage().getUserid());
		String idMoney = find2.getUsermoney();
		int idMoneyInt = Integer.parseInt(idMoney);
		if(moneyInt > idMoneyInt) {
			JOptionPane.showMessageDialog(null, "您的账户余额不足", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//判断密码是否正确
		String password = transfer.getPassword().getText();
		if(password.equals("")) {
			JOptionPane.showMessageDialog(null, "请输入密码", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		if(!password.equals(find2.getUserpassword())) {
			JOptionPane.showMessageDialog(null, "密码错误", "消息框", JOptionPane.ERROR_MESSAGE);
			return;
		}
		//判断是否是本行账户		
		int idmoney1 = Integer.parseInt(find.getUsermoney()) + moneyInt;
		String idmoneyString1 = String.valueOf(idmoney1);//被转账的账户余额
		int idmoney2 = idMoneyInt - moneyInt;
		String idmoneyString2 = String.valueOf(idmoney2);//转账账户余额
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
			JOptionPane.showMessageDialog(null, "转账成功", "消息框", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "转账失败，请重试", "消息框", JOptionPane.INFORMATION_MESSAGE);
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