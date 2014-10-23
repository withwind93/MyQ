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
			System.out.println("--------MyQ实时聊天系统--------\n输入 1：登录\n输出 2：注册");
			int cmd1 = 0;
			cmd1 = cin.nextInt();
			if (cmd1 == 1) {
				int sendid;
				String pwd;
				System.out.println("MyQ帐号：");
				sendid = cin.nextInt();
				System.out.println("密码：");
				pwd = cin.next();
				Request.Login(sendid, pwd);
				if (Response.isokLogin()) {
					System.out.println("登录成功！");
					System.out.println("你好 ," + sendid + "!");
					while (true) {
						System.out.println("--------MyQ实时聊天系统--------\n"
								+ "输入 1 ：获取好友列表\n输入 2 ：增加好友\n"
								+ "输入 3：发送消息\n输入 4：删除好友\n输入 5：获取聊天记录\n输入 0：注销");
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
							System.out.println("请输入好友MyQ帐号：");
							int buddyid = 0;
							Request.Addbuddy(sendid, buddyid);
							if (Response.isokAddbuddy()) {
								System.out.println("添加好友" + buddyid + "成功！");
							}
						} else if (cmd2 == 3) {
							System.out.println("接收者的MyQ帐号：");
							int recvid = 0;
							recvid = cin.nextInt();
							System.out.println("发送内容：");
							String message = null;
							message = cin.next();
							String msgtype = "single";
							Request.Send(sendid, recvid, msgtype, message);
						} else if (cmd2 == 4) {
							System.out.println("请输入要删除的好友MyQ帐号：");
							int buddyid = 0;
							buddyid = cin.nextInt();
							Request.Deletebuddy(sendid, buddyid);
							if (Response.isokAddbuddy()) {
								System.out.println("删除好友" + buddyid + "成功！");
							}
						} else if(cmd2 == 5) {
							System.out.println("请输入聊天记录的好友MyQ帐号：");
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
				System.out.println("新帐号昵称：");
				nickname = cin.next();
				System.out.println("新帐号密码：");
				password = cin.next();
				Request.Register(nickname, password);
				String message = null;
				if ((message = Response.getRegisterMessage()) != null) {
					System.out.println("注册成功！你的MyQ帐号为：" + message);
				} else {
					System.out.println("注册失败！");
				}
			}
		}
	}
}
