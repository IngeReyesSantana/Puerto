/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puertos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inghe
 */
public class Puertos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Puerto del servidor
        final int PUERTO = 80;
        DataInputStream in;
        DataOutputStream out;
        
         try {
            InetAddress direccionServidor = InetAddress.getByName("localhost"); 
            //Creo el socket para conectarme con el cliente
            Socket sc = new Socket("216.58.222.196", PUERTO);
            
            in = new DataInputStream(sc.getInputStream());
            out = new DataOutputStream(sc.getOutputStream());
            
            //Envio un mensaje desde el cliente
            //out.writeUTF("¡Hola mundo desde el cliente!");

            //Recibo el mensaje del servidor
            String mensaje = in.readUTF();

            System.out.println(mensaje);
            //Cerrar cliente
            sc.close();
         }catch (IOException ex) {
            Logger.getLogger(Puertos.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
