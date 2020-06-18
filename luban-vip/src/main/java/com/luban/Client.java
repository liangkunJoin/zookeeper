package com.luban;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket = new Socket();

        try {
            socket.connect(new InetSocketAddress(8081));

            System.out.println("-----------");

            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bi = new BufferedInputStream(inputStream);
            DataInput dataInput = new DataInputStream(bi);
            System.out.println("receive from server: " + dataInput.readUTF());

            System.out.println("_____________");

            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bo = new BufferedOutputStream(outputStream);
            DataOutput dataOutput = new DataOutputStream(bo);
            dataOutput.writeUTF("client first data send to server");
            bo.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
