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
 * 登录界面确定按钮事件监听器
 * 重点：传参。用户输入的账号和密码在Register类中保存，本类无法直接访问
 * 因此，在Register类中添加返回账户和密码的方法，调用本类构造方法时传递一个Register类型的参数
 * 将传递的参数赋值给本类中Register的类对象，通过调用相关get方法即可得到用户输入的账号和密码
 * @author 周宝辉
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
			JOptionPane.showMessageDialog(null, "请输入账号或密码", "消息框",JOptionPane.ERROR_MESSAGE);
		}else {
			String sql = "select * from usermessage where userid = ? and userpassword = ?";
			//使用UserMessage对象保存返回值，当用户输入的信息正确时，UserMessage对象中保存着该用户的全部信息
			//后续操作使用此对象作为参数传递
			UserMessage usermessage = Find.find(UserMessage.class, sql, id, password);
			if(usermessage != null) {
				new RegisterOk(usermessage);
				//将用户的账号密码写入到文件中
				String filepath = "src/info.txt";
				String str = usermessage.getUserid() + "," + usermessage.getUserpassword();
				ATMFile.write(str, filepath);
			}else {
				JOptionPane.showMessageDialog(null, "账号或密码错误", "消息框",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}