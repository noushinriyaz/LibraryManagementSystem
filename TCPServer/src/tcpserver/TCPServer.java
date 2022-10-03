package tcpserver;
import java.io.*;
import java.net.*;
import java.nio.file.*;
public class TCPServer 
{
    public static void main(String[] args)throws IOException
    {
        ServerSocket server;
        DataOutputStream out= null;
        DataInputStream in;
        try
        {
            server= new ServerSocket(6000,1);
            System.out.println("server waiting for client");
            Socket socket= server.accept();
            System.out.println("client connected to server");
            in= new DataInputStream(socket.getInputStream());
            out= new DataOutputStream(socket.getOutputStream());
            String fileName= in.readUTF();
            System.out.println("the requested file is="+fileName);
            byte[]filedata= Files.readAllBytes(Paths.get(fileName));
            String fileContent= new String(filedata);
            out.writeUTF(fileContent.toString());
            System.out.println("File sent successfully");
            
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            out.writeUTF("file doesnt exist");
        }
        
    }
    
}
