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
		
		//创建极少线程池
		int threads = 3;
		Executors executors = (Executors) Executors.newScheduledThreadPool(threads);
		
		
		//创建selector
		Selector selector = Selector.open();
		//一个线程敷在选择器就绪的channel
		//创建一个通道
		ServerSocketChannel ssc = ServerSocketChannel.open();
		int port = 9200;
		ssc.bind(new InetSocketAddress(port));
		//注册到selector，让selector帮助检测到连接进来
		//使用非阻塞方式
		ssc.configureBlocking(false);
		//注册
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		while(true) {
			
			//阻塞选择就绪事件，select()可以被中断
			int readChannelCount = selector.select();
			
			
			if(readChannelCount==0)
				continue;
			
			//得到就绪的channel
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			
			Iterator<SelectionKey> iterator = selectionKeys.iterator();
			
			while (iterator.hasNext()) {
				SelectionKey key = (SelectionKey) iterator.next();
				
				if(key.isAcceptable()) {//连接进来
					//接收链接
					SocketChannel sc = ssc.accept();
					
					//注册到selector，请他帮忙检测数据到来
					sc.configureBlocking(false);
					sc.register(selector, SelectionKey.OP_ACCEPT);
				}else if (key.isReadable()) {//数据已经发过来了 去读取数据
					
					
					
				}else if (key.isWritable()) {//可以发送出去了
					
				}else if (key.isConnectable()) {//客户端用 以联通服务器
					
				}
				
				iterator.remove();//已经处理，一定要从
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

