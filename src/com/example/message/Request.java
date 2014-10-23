package com.example.message;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.example.model.AddbuddyRequest;
import com.example.model.DeletebuddyRequest;
import com.example.model.GetbuddylistRequest;
import com.example.model.GettalkmessageRequest;
import com.example.model.LoginRequest;
import com.example.model.LogoutRequest;
import com.example.model.RegisterRequest;
import com.example.model.SendRequest;

public class Request {
	public static void Register(String nickname, String password) {
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setNickname(nickname);
		registerRequest.setPassword(password);
		OutputSocket.getInstance().setMessageRequest(registerRequest);
	}

	public static void Login(int sendid, String password) {
		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setSendid(sendid);
		loginRequest.setPassword(password);
		OutputSocket.getInstance().setMessageRequest(loginRequest);
	}

	public static void Logout(int sendid) {
		LogoutRequest logoutRequest = new LogoutRequest();
		logoutRequest.setSendid(sendid);
		OutputSocket.getInstance().setMessageRequest(logoutRequest);
	}

	public static void Send(int sendid, int recvid, String msgtype,
			String message) {
		SendRequest sendRequest = new SendRequest();
		sendRequest.setSendid(sendid);
		sendRequest.setRecvid(recvid);
		sendRequest.setMsgtype(msgtype);
		sendRequest.setMessage(message);
		OutputSocket.getInstance().setMessageRequest(sendRequest);
	}

	public static void Addbuddy(int sendid, int buddyid) {
		AddbuddyRequest addbuddyRequest = new AddbuddyRequest();
		addbuddyRequest.setSendid(sendid);
		addbuddyRequest.setBuddyid(buddyid);
		OutputSocket.getInstance().setMessageRequest(addbuddyRequest);
	}

	public static void Deletebuddy(int sendid, int buddyid) {
		DeletebuddyRequest deletebuddyRequest = new DeletebuddyRequest();
		deletebuddyRequest.setSendid(sendid);
		deletebuddyRequest.setBuddyid(buddyid);
		OutputSocket.getInstance().setMessageRequest(deletebuddyRequest);
	}

	public static void Getbuddylist(int sendid) {
		GetbuddylistRequest getbuddylistRequest = new GetbuddylistRequest();
		getbuddylistRequest.setSendid(sendid);
		OutputSocket.getInstance().setMessageRequest(getbuddylistRequest);
	}

	public static void Gettalkmessage(int sendid, int recvid) {
		GettalkmessageRequest gettalkmessageRequest = new GettalkmessageRequest();
		gettalkmessageRequest.setSendid(sendid);
		gettalkmessageRequest.setRecvid(recvid);
		OutputSocket.getInstance().setMessageRequest(gettalkmessageRequest);
	}
}
