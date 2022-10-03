package crc;
import java.util.Scanner;
public class CRC {
    public static String msg;
    public static String csum;
    public static String genp="1000100000100001";
    public static int msgLen;
    public static int totalmsgLen;
    public static int genpLen;
    public static String xor(String csumstr,String genpstr)
    {
        int csumint= Integer.parseInt(csumstr,2);
        int genpint= Integer.parseInt(genpstr,2);
        int result= csumint^genpint;
        return Integer.toBinaryString(result);
        
    }
    public static void crc()
    {
        int i=genp.length();
        csum=msg.substring(0,genpLen);
        do
        {
            if(csum.charAt(0)!='1')
                csum=csum.substring(1,csum.length());
            if(csum.length()==genpLen)
                csum=xor(csum,genp);
            csum+=msg.charAt(i++);
        }while(i<totalmsgLen);
        
    }
    public static void main(String[] args) 
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the message");
        msg=scanner.next();
        System.out.println("generating polynomial is:"+genp);
        msgLen=msg.length();
        genpLen=genp.length();
        totalmsgLen=msgLen+genpLen-1;
        for(int i=msgLen;i<totalmsgLen;i++)
        {
            msg+='0';
        }
        System.out.println("modified message is:"+msg);
        crc();
        System.out.println("check sum is:"+csum);
        msg=xor(msg,csum);
        System.out.println("Finally transmitted mmessage is:"+msg);
        System.out.println("enter the recieved message");
        msg=scanner.next();
        crc();
        if (msg.contains("1"))
        {
            System.out.println("error detected");
            
        }
        else{
            System.out.println("no error");
        }
        
    }
    
}
