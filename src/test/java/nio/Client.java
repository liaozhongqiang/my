package nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;

public class Client {
	
	public static void main(String[] args) throws Exception {
		SocketChannel socketChannel=SocketChannel.open();
		socketChannel.configureBlocking(false);
		Selector selector=Selector.open();
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		socketChannel.connect(new InetSocketAddress("127.0.0.1", 8889));
		while(!Thread.interrupted()){
			selector.select();
			Set<SelectionKey> keys=selector.selectedKeys();
			for(SelectionKey key:keys){
				if(key.isConnectable()){
					final SocketChannel client=(SocketChannel) key.channel();
					//客户端输入
					if(client.isConnectionPending()){
						client.finishConnect();
						new Thread(new Runnable() {
							@Override
							public void run() {
								int i=0;
								ByteBuffer buf=ByteBuffer.allocate(1024);
								while(i<100){
									try {
										/*BufferedReader br=new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
										String str=br.readLine();*/
										String str=RandomStringUtils.randomAlphanumeric(i+1);
										int packageleght=4+str.getBytes().length;
										byte[] packag=ArrayUtils.addAll(ByteUtils.intToByte(packageleght), str.getBytes());
										buf.clear();
										buf.put(str.getBytes());
										System.out.println("客户端发送的数据是："+str);
										buf.flip();
										client.write(buf);
										i++;
									} catch (Exception e) {
										e.printStackTrace();
									}
								}
							}
						}).start();
					}
					client.register(selector, SelectionKey.OP_READ);
				}
				if(key.isReadable()){
					SocketChannel client=(SocketChannel) key.channel();
					ByteBuffer buff=ByteBuffer.allocate(10);
					int read=client.read(buff);
					if(read>0){
						System.out.println("客户端接收的数据："+new String(buff.array(),0,read));
						client.register(selector, SelectionKey.OP_READ);
					}
				}
			}
			keys.clear();
		}
	}

}
