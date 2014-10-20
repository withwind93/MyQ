package com.example.message;

import java.util.List;

import com.example.model.AddbuddyResponse;
import com.example.model.ConnectResponse;
import com.example.model.DeletebuddyResponse;
import com.example.model.GetbuddylistResponse;
import com.example.model.LoginResponse;
import com.example.model.RegisterResponse;
import com.example.model.SendRequest;
import com.example.model.User;

public class Response {
	public static void setConnect(String string) {
		ConnectResponse connectResponse = (ConnectResponse) JSonUtils.readValue(string, ConnectResponse.class);
		if (connectResponse.getOk().equals("ok")) {
			System.out.println("-----connect ok-----");
			MyQSocket.getInstance().setToken(connectResponse.getToken());
			System.out.println("-----token : " + MyQSocket.getInstance().getToken() + "-----");
		}
	}
	
	private static RegisterResponse registerResponse = null;
	public static void setRegisterResponse(String string)  {
		while (registerResponse != null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		registerResponse = JSonUtils.readValue(string, RegisterResponse.class);
	}
	public static RegisterResponse getRegisterResponse(){
		while (registerResponse == null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RegisterResponse tmpRegisterResponse = registerResponse;
		registerResponse = null;
		return tmpRegisterResponse;
	}
	public static String getRegisterMessage() {
		return getRegisterResponse().getMessage();
	}
	
	private static AddbuddyResponse addbuddyResponse = null;
	public static void setAddbuddyResponse(String string)  {
		while (addbuddyResponse != null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		addbuddyResponse = JSonUtils.readValue(string, AddbuddyResponse.class);
	}
	public static AddbuddyResponse getAddbuddyResponse(){
		while (addbuddyResponse == null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		AddbuddyResponse tmpAddbuddyResponse = addbuddyResponse;
		addbuddyResponse = null;
		return tmpAddbuddyResponse;
	}
	public static boolean isokAddbuddy() {
		return getAddbuddyResponse().getOk().equals("ok");
	}
	
	private static DeletebuddyResponse deletebuddyResponse = null;
	public static void setDeletebuddyResponse(String string)  {
		while (deletebuddyResponse != null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		deletebuddyResponse = JSonUtils.readValue(string, DeletebuddyResponse.class);
	}
	public static DeletebuddyResponse getDeletebuddyResponse(){
		while (deletebuddyResponse == null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		DeletebuddyResponse tmpDeletebuddyResponse = deletebuddyResponse;
		deletebuddyResponse = null;
		return tmpDeletebuddyResponse;
	}
	public static boolean isokDeletebuddy(){
		return getDeletebuddyResponse().getOk().equals("ok");
	}
	
	private static GetbuddylistResponse getbuddylistResponse = null;
	public static void setGetbuddylistResponse(String string)  {
		while (getbuddylistResponse != null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		getbuddylistResponse = JSonUtils.readValue(string, GetbuddylistResponse.class);
	}
	public static GetbuddylistResponse getGetbuddylistResponse(){
		while (getbuddylistResponse == null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		GetbuddylistResponse tmpGetbuddylistResponse = getbuddylistResponse;
		getbuddylistResponse = null;
		return tmpGetbuddylistResponse;
	}
	public static List<User> getGetbuddylist(){
		return getGetbuddylistResponse().getList();
	}
	
	private static LoginResponse loginResponse = null;
	public static void setLoginResponse(String string)  {
		while (loginResponse != null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		loginResponse = JSonUtils.readValue(string, LoginResponse.class);
	}
	public static LoginResponse getLoginResponse(){
		while (loginResponse == null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		LoginResponse tmpLoginResponse = loginResponse;
		loginResponse = null;
		return tmpLoginResponse;
	}
	public static boolean isokLogin(){
		return getLoginResponse().getOk().equals("ok");
	}
	
	private static SendRequest recvResponse = null;
	public static void setRecvResponse(String string) {
		while (recvResponse != null) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		recvResponse = JSonUtils.readValue(string, SendRequest.class);
		System.out.println("收到一条来自" + recvResponse.getSendid() + "消息！内容： " + recvResponse.getMessage());
		recvResponse = null;
	}
}
