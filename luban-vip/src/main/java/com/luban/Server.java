package com.luban;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args)  {

        try {
            ServerSocket socketServer = new ServerSocket(8081);


            Socket sock = socketServer.accept();

            System.out.println("-----------");

            BufferedOutputStream bo = new BufferedOutputStream(sock.getOutputStream());
            DataOutput dataOutput = new DataOutputStream(bo);
            dataOutput.writeUTF("hello");
            bo.flush();


            BufferedInputStream io = new BufferedInputStream(sock.getInputStream());
            DataInput dataInput = new DataInputStream(io);
            System.out.println("receive data from client : " + dataInput.readUTF());

            System.out.println("_____________");

            while (true){

            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
