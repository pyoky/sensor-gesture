import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Datasocket
{
	public static void main(String[] args) throws IOException
	{
		// Constructor to create a datagram socket
		DatagramSocket socket = new DatagramSocket();

		InetAddress address = InetAddress.getByName("192.168.11.111");

		int port = 5252;

		byte buf[] = new byte[64];
		buf = "hello".getBytes("UTF-8");
//		byte buf1[] = new byte[2];

		DatagramPacket dp = new DatagramPacket(buf, buf.length, address, port);
//		DatagramPacket dptorec = new DatagramPacket(buf1, 2);

		// connect() method
		socket.connect(address, port);

		// isBound() method
		System.out.println("IsBound : " + socket.isBound());

		// isConnected() method
		System.out.println("isConnected : " + socket.isConnected());

		// getInetAddress() method
		System.out.println("InetAddress : " + socket.getInetAddress());

		// getPort() method
		System.out.println("Port : " + socket.getPort());

		// getRemoteSocketAddress() method
		System.out.println("Remote socket address : " +
				socket.getRemoteSocketAddress());

		// getLocalSocketAddress() method
		System.out.println("Local socket address : " +
				socket.getLocalSocketAddress());

		// send() method
		for (int i = 0; i < 10; i++){
			socket.send(dp);
			System.out.println("...packet sent successfully....");
		}
		DatagramPacket packet = new DatagramPacket("kill".getBytes(Charset.forName("UTF-8")), "kill".getBytes().length, address, port);

		socket.send(packet);


//		// receive() method
//		socket.receive(dptorec);
//		System.out.println("Received packet data : " +
//				Arrays.toString(dptorec.getData()));
//
//		// getLocalPort() method
//		System.out.println("Local Port : " + socket.getLocalPort());
//
//		// getLocalAddress() method
//		System.out.println("Local Address : " + socket.getLocalAddress());
//
//		// setSOTimeout() method
//		socket.setSoTimeout(50);
//
//		// getSOTimeout() method
//		System.out.println("SO Timeout : " + socket.getSoTimeout());
	}

}
