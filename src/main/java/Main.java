import org.moremore.simplechatclient.Client;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try{
            Client.start();
        }catch (IOException e){}
    }
}
