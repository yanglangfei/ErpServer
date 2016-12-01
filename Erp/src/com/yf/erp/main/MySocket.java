package com.yf.erp.main;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

/**
 * @author 杨朗飞
 *2016年11月30日  下午5:52:45
 *
 *  WebSocket 只能以WebSocket的方式进行访问   否则返回400
 */
public class MySocket extends WebSocketServlet {
	private static final long serialVersionUID = -1207436218121510786L;
	private static List<MessageInbound> socketList = new ArrayList<MessageInbound>();
	
	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest arg1) {
		//创建socket
		System.out.println("创建socket");
		return new WebSocketMessageInbound();
	}

	public class WebSocketMessageInbound extends MessageInbound {

		@Override
		protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
			//接受到文件  遍历socket集合并进行转发
			System.out.println("接收到 binaryMessage");
			for(MessageInbound inbound : socketList){
				WsOutbound ws = inbound.getWsOutbound();
				ws.writeBinaryMessage(arg0);
				ws.flush();
			}

		}

		@Override
		protected void onTextMessage(CharBuffer charBuffer) throws IOException {
			//接受到文字信息   并遍历socket集合将文字消息输出
			System.out.println("接收到textMessage");
			for(MessageInbound inbound : socketList){
				CharBuffer charBuff = CharBuffer.wrap(charBuffer);
				WsOutbound ws = inbound.getWsOutbound();
				ws.writeTextMessage(charBuff);
				ws.flush();
			}
		}

		@Override
		protected void onOpen(WsOutbound outbound) {
			super.onOpen(outbound);
			//打开连接
			System.out.println("打开连接..");
			socketList.add(this);
		}

		@Override
		protected void onClose(int status) {
			super.onClose(status);
			//关闭连接
			System.out.println("关闭连接..");
			socketList.remove(this);
		}
	}

}
