package com.zhangdong.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executors;

public class NewIOServer {
	public static void main(String[] args) throws Exception {
		
		//���������̳߳�
		int threads = 3;
		Executors executors = (Executors) Executors.newScheduledThreadPool(threads);
		
		
		//����selector
		Selector selector = Selector.open();
		//һ���̷߳���ѡ����������channel
		//����һ��ͨ��
		ServerSocketChannel ssc = ServerSocketChannel.open();
		int port = 9200;
		ssc.bind(new InetSocketAddress(port));
		//ע�ᵽselector����selector������⵽���ӽ���
		//ʹ�÷�������ʽ
		ssc.configureBlocking(false);
		//ע��
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		while(true) {
			
			//����ѡ������¼���select()���Ա��ж�
			int readChannelCount = selector.select();
			
			
			if(readChannelCount==0)
				continue;
			
			//�õ�������channel
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			
			while (iterator.hasNext()) {
				SelectionKey key = (SelectionKey) iterator.next();
				
				if(key.isAcceptable()) {//���ӽ���
					//��������
					SocketChannel sc = ssc.accept();
					
					//ע�ᵽselector��������æ������ݵ���
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_ACCEPT);
				}else if (key.isReadable()) {//�����Ѿ��������� ȥ��ȡ����
					
					
					
				}else if (key.isWritable()) {//���Է��ͳ�ȥ��
					
				}else if (key.isConnectable()) {//�ͻ����� ����ͨ������
					
				}
				
				iterator.remove();//�Ѿ�����һ��Ҫ��
			}
		}
	}
	
	
	static class ScoketProcess implements Runnable{
		
		SelectionKey key = null;
		public ScoketProcess(SelectionKey key){
			this.key = key;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}
}

