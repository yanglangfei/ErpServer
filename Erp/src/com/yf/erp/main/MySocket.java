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
 * @author ���ʷ�
 *2016��11��30��  ����5:52:45
 *
 *  WebSocket ֻ����WebSocket�ķ�ʽ���з���   ���򷵻�400
 */
public class MySocket extends WebSocketServlet {
	private static final long serialVersionUID = -1207436218121510786L;
	private static List<MessageInbound> socketList = new ArrayList<MessageInbound>();
	
	@Override
	protected StreamInbound createWebSocketInbound(String arg0,
			HttpServletRequest arg1) {
		//����socket
		System.out.println("����socket");
		return new WebSocketMessageInbound();
	}

	public class WebSocketMessageInbound extends MessageInbound {

		@Override
		protected void onBinaryMessage(ByteBuffer arg0) throws IOException {
			//���ܵ��ļ�  ����socket���ϲ�����ת��
			System.out.println("���յ� binaryMessage");
			for(MessageInbound inbound : socketList){
				WsOutbound ws = inbound.getWsOutbound();
				ws.writeBinaryMessage(arg0);
				ws.flush();
			}

		}

		@Override
		protected void onTextMessage(CharBuffer charBuffer) throws IOException {
			//���ܵ�������Ϣ   ������socket���Ͻ�������Ϣ���
			System.out.println("���յ�textMessage");
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
			//������
			System.out.println("������..");
			socketList.add(this);
		}

		@Override
		protected void onClose(int status) {
			super.onClose(status);
			//�ر�����
			System.out.println("�ر�����..");
			socketList.remove(this);
		}
	}

}
