package com.atm.actionlistener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.atm.file.ATMFile;

/**
 * ��¼�����ס���밴ť�¼�������
 * @author �ܱ���
 *
 */
public class PasswordCheckBox implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		String flag = ATMFile.read("src/bool2.txt");
		if(flag.equals("true")) {
			ATMFile.write("false", "src/bool2.txt");			
		}else {
			ATMFile.write("true", "src/bool2.txt");
		}
	}
}
