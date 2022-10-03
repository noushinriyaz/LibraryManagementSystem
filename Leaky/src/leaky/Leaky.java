package leaky;
import java.util.Scanner;

public class Leaky {
    public static int bucketSize=1000;
    public static int outputRate=100;
    public static void sendPacket(int pktSize)
    {
        if(pktSize>bucketSize)
        {
            System.out.println("bucket overflow");
        }
        else
        {
            while(pktSize>outputRate)
            {
                System.out.println(outputRate+ "bytes of packet sent");
                pktSize=pktSize-outputRate;
                
            }
            System.out.println(pktSize+"bytes of packet sent");
            
        }
    }
    
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the no. of packets");
        int numpacket= scanner.nextInt();
        if(numpacket>0)
        {
            for(int i=1;i<=numpacket;i++)
            {
                System.out.println("Enter the packets:" +i+ "size:");
                int pktSize= scanner.nextInt();
                sendPacket(pktSize);
            }
        }
        else
        {
            System.out.println("No packets to send");
        }
        
    }
    
}
