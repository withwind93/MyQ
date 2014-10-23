package com.example.message;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;

import com.example.model.BuddyEntity;
import com.example.model.ChatMsgEntity;

public class SocketTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputSocket.getInstance().start();
		OutputSocket.getInstance().start();
		while (MyQSocket.getInstance().getToken() == null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		;
		while (true) {
			Scanner cin = new Scanner(System.in);
			System.out.println("--------MyQʵʱ����ϵͳ--------\n���� 1����¼\n��� 2��ע��");
			int cmd1 = 0;
			cmd1 = cin.nextInt();
			if (cmd1 == 1) {
				int sendid;
				String pwd;
				System.out.println("MyQ�ʺţ�");
				sendid = cin.nextInt();
				System.out.println("���룺");
				pwd = cin.next();
				Request.Login(sendid, pwd);
				if (Response.isokLogin()) {
					System.out.println("��¼�ɹ���");
					System.out.println("��� ," + sendid + "!");
					while (true) {
						System.out.println("--------MyQʵʱ����ϵͳ--------\n"
								+ "���� 1 ����ȡ�����б�\n���� 2 �����Ӻ���\n"
								+ "���� 3��������Ϣ\n���� 4��ɾ������\n���� 5����ȡ�����¼\n���� 0��ע��");
						int cmd2 = 0;
						cmd2 = cin.nextInt();
						if (cmd2 == 0) {
							Request.Logout(sendid);
							break;
						} else if (cmd2 == 1) {
							Request.Getbuddylist(sendid);
							List<BuddyEntity> list = Response.getGetbuddylist();
							if (list != null) {
								for (BuddyEntity user : list) {
									System.out.println(user.getId() + " : "
											+ user.getName());
								}
							}
						} else if (cmd2 == 2) {
							System.out.println("���������MyQ�ʺţ�");
							int buddyid = 0;
							Request.Addbuddy(sendid, buddyid);
							if (Response.isokAddbuddy()) {
								System.out.println("��Ӻ���" + buddyid + "�ɹ���");
							}
						} else if (cmd2 == 3) {
							System.out.println("�����ߵ�MyQ�ʺţ�");
							int recvid = 0;
							recvid = cin.nextInt();
							System.out.println("�������ݣ�");
							String message = null;
							message = cin.next();
							String msgtype = "single";
							Request.Send(sendid, recvid, msgtype, message);
						} else if (cmd2 == 4) {
							System.out.println("������Ҫɾ���ĺ���MyQ�ʺţ�");
							int buddyid = 0;
							buddyid = cin.nextInt();
							Request.Deletebuddy(sendid, buddyid);
							if (Response.isokAddbuddy()) {
								System.out.println("ɾ������" + buddyid + "�ɹ���");
							}
						} else if(cmd2 == 5) {
							System.out.println("�����������¼�ĺ���MyQ�ʺţ�");
							int recvid = 0;
							recvid = cin.nextInt();
							Request.Gettalkmessage(sendid, recvid);
							List<ChatMsgEntity> list = Response.getGettalkmessagelist();
							if (list != null) {
								for (ChatMsgEntity msg : list) {
									System.out.println(msg.getTime() + " : "
											+ msg.getMessage());
								}
							}
						}
					}
				}
			} else if (cmd1 == 2) {
				String nickname, password;
				System.out.println("���ʺ��ǳƣ�");
				nickname = cin.next();
				System.out.println("���ʺ����룺");
				password = cin.next();
				Request.Register(nickname, password);
				String message = null;
				if ((message = Response.getRegisterMessage()) != null) {
					System.out.println("ע��ɹ������MyQ�ʺ�Ϊ��" + message);
				} else {
					System.out.println("ע��ʧ�ܣ�");
				}
			}
		}
	}
}
