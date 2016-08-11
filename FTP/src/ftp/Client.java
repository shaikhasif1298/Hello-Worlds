/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ftp;

import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;
/**
 *
 * @author user
 */
public class Client {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.net.SocketException
     */
    public static void main(String[] args) throws IOException , SocketException{
        // TODO code application logic here
        File f1=new File("C:\\Users\\user\\Desktop\\FTP\\src\\ftp\\input.txt");
        FileReader fr=new FileReader(f1);
        BufferedReader br=new BufferedReader(fr);
        Socket s=new Socket("127.0.0.1",1234);
        DataInputStream sc1;
        sc1 = new DataInputStream(s.getInputStream());
        String no=br.readLine();
        DES d=new DES();
        String b=d.Encryption(no);
        
        PrintStream p=new PrintStream(s.getOutputStream());
        p.println(b);
        String temp;
        temp = sc1.readLine();
        
        File file2=new File("C:\\Users\\user\\Desktop\\FTP\\src\\ftp\\output.txt");
        FileWriter fw=new FileWriter(file2);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.write(temp);
        bw.close();
        
        
    }
    
}

class DES{
    public String Encryption(String s)
    {
       try{

		    KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
		    SecretKey myDesKey = keygenerator.generateKey();

		    Cipher desCipher;

		    // Create the cipher
		    desCipher = Cipher.getInstance("DES/ECB/NoPadding");

		    // Initialize the cipher for encryption
		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);

		    //sensitive information
                    
		    byte[] text = s.getBytes();

		    

		    // Encrypt the text
		    byte[] textEncrypted = desCipher.doFinal(text);
                    String s1=new String(textEncrypted);
                   
		 return s1;  

		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
		}catch(NoSuchPaddingException e){
			e.printStackTrace();
		}catch(InvalidKeyException e){
			e.printStackTrace();
		}catch(IllegalBlockSizeException e){
			e.printStackTrace();
		}catch(BadPaddingException e){
			e.printStackTrace();
		}
    
         
         
      return null;
    }

}
