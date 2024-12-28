import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.io.PrintWriter;
import java.net.*;


public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(4999);
        Socket s = ss.accept();

        System.out.println("Connection established ");

        // PrintWriter pr = new PrintWriter(s.getOutputStream());
        // pr.println("Hello from Server");
        // pr.flush();

        // InputStreamReader ir = new InputStreamReader(s.getInputStream());
        // BufferedReader br = new BufferedReader(ir);

        DataInputStream ir = new DataInputStream(s.getInputStream());
        DataOutputStream iw = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // String str = br.readLine();
        // System.out.println("Client:" +str);
        String str1 = "", str2 = "";

        while (!str1.equals("stop")) {
            str1 = br.readLine();
            iw.writeUTF(str1);
            iw.flush();
            str2 = ir.readUTF();
            System.out.println("Client says: " + str2);
            

        }

        br.close();
        s.close();
        ss.close();
    }
}
