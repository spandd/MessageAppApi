package com.oright.android.messageapi.socket;


import java.util.ArrayList;
import java.util.List;

public class ClientPool{
    public static volatile List<Client> clients = new ArrayList<>();
}
