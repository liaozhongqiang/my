package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;


public class Server {

	public static void main(String[] args) throws IOException {
		final ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8889));
		serverSocketChannel.configureBlocking(false);
		Selector selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (!Thread.interrupted()) {
			selector.select();
			Set<SelectionKey> keys = selector.selectedKeys();
			for (SelectionKey key : keys) {
				if (key.isAcceptable()) {
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
				}
				if (key.isReadable()) {
					new Worker((SocketChannel) key.channel(), selector).run();
				}
			}
			keys.clear();
		}
	}
}

class Worker {
	private SocketChannel socketChannel;

	private Selector selector;

	public Worker(SocketChannel socketChannel, Selector selector) {
		this.socketChannel = socketChannel;
		this.selector = selector;
	}

	public void run() {
		ByteBuffer head = ByteBuffer.allocate(4);

		try {
			int read = socketChannel.read(head);

			if (read == -1) {
				socketChannel.close();
				System.out.println("客户端已经关闭");
			}
			int palength = ByteUtils.byteToInt(head.array(), 0);
			int bodylength = palength - 4;
			ByteBuffer body = ByteBuffer.allocate(bodylength);
			int read2 = socketChannel.read(body);
			System.out.println("服务端接收的数据：" + new String(body.array(),0,read2));
			ByteBuffer send = ByteBuffer.allocate(1024);
			send.put("11111".getBytes());
			send.flip();
			socketChannel.write(send);
			socketChannel.register(selector, SelectionKey.OP_READ);
			//buf.clear();
			//buf.put("1111111".getBytes());
			// buf.flip();
			// socketChannel.write(buf);
			// socketChannel.register(selector, SelectionKey.OP_READ);
		} catch (IOException e) {
			try {
				socketChannel.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

}
