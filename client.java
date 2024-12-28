import java.net.*;
import java.io.*;

public class client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost",4999);
        

        // PrintWriter pr = new PrintWriter(s.getOutputStream());
        // pr.println("Hello from client");
        // pr.flush();

        DataInputStream ir = new DataInputStream(s.getInputStream());
        DataOutputStream iw = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = "", str2 = "";

        while (!str1.equals("stop")) {
            str1 = ir.readUTF();
            System.out.println("Server says: " + str1);
            str2 = br.readLine();
            iw.writeUTF(str2);
            iw.flush();

        }
        // String str = br.readLine();
        // System.out.println("Server:" +str);

        
        br.close();
        s.close();
    }
}
