package com.oright.android.messageapi.socket;

import java.io.*;
import java.net.Socket;

public class Client {
    private Socket client;
    private BufferedReader reader;
    private PrintWriter writer;
    private Integer userId;
    public int flag = 1;

    public Client(Socket client) {
        try {
            this.client = client;
            this.reader = new BufferedReader(new InputStreamReader(this.client.getInputStream()));
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.client.getOutputStream())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String message){
        if (message != null && !message.equals("")){
            this.writer.println(message);
            this.writer.flush();
        }
    }
    public String receverMessage(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
}
