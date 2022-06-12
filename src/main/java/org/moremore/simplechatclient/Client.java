package org.moremore.simplechatclient;

import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class Client {
    private final Socket socket;
    private final Transport transport;
    private Client() throws IOException {
        this.socket = new Socket("localhost", 5001);

        this.transport = Transport.of(socket.getInputStream(),
                                    socket.getOutputStream());

        transport.send("hello");
    }

    public static Client start() throws IOException{
        return new Client();
    }

    public void close() {
        try{
            if(!Objects.isNull(transport)) transport.close();
            if(!this.socket.isClosed() && !Objects.isNull(this.socket)) this.socket.close();
        }catch (IOException e){}
    }

    @Override
    public String toString() {
        return this.socket.toString();
    }
}
