package com.atm.actionlistener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import com.atm.file.ATMFile;

/**
 * ��¼�����ס�˺Ű�ť�¼�������
 * @author �ܱ���
 *
 */
public class IdCheckBox implements ItemListener{
	public void itemStateChanged(ItemEvent e) {
		//��ִ�иô���ʱ˵���û���ı临ѡ���״̬
		//�Ȼ�ȡ��ǰ��ѡ���״̬
		//��ǰ״̬Ϊtrue���޸�Ϊfalse����֮��Ȼ
		String flag = ATMFile.read("src/bool1.txt");
		if(flag.equals("true")) {
			ATMFile.write("false", "src/bool1.txt");			
		}else {
			ATMFile.write("true", "src/bool1.txt");
		}
	}
}
