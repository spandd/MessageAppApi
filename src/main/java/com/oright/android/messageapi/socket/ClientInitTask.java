package com.oright.android.messageapi.socket;

public class ClientInitTask implements Runnable {

    private Client client;

    public ClientInitTask(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true){
            String userId = client.receverMessage();
            if (userId != null){
                for (int i = 0; i < ClientPool.clients.size();i++){
                    if (ClientPool.clients.get(i).getUserId() == Integer.valueOf(userId) && ClientPool.clients.get(i).flag == 0){
                        ClientPool.clients.remove(i);
                        break;
                    }
                }
                client.flag = 0;
                System.out.println("------ClientCount:" + ClientPool.clients.size() + "------");
                client.setUserId(Integer.valueOf(userId));
                break;
            }
        }
    }
}
