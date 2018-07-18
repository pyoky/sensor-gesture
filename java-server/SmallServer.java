import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class SmallServer {
     
    public static void main(String[] args) throws IOException {
                     
        DatagramSocket ds = new DatagramSocket(5252);
        byte buffer[] = new byte[64];
        byte send[] = { 0 };

        while (true) {
            DatagramPacket dp = new DatagramPacket(buffer, 64);
            ds.receive(dp);
            String stringData = new String(dp.getData(), "UTF-8");
            stringData.replaceAll("\\s+","");
            System.out.println("recieved packet :" + stringData);
            System.out.println("length of string :" + Integer.toString(stringData.length()));
            if (stringData.equals("kill")) break;
            buffer = new byte[64];
        }
        //DatagramPacket senddp = new DatagramPacket(send, 2, dp.getAddress(), dp.getPort());
        //ds.send(senddp);
        //System.out.println("sent packet successfully");
    }
         
}
