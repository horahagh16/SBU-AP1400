import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/*
public class ClientHandler implements Runnable {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;
    String username;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try {
            this.username = dis.readUTF();
            while (Server.users.containsKey(username)) {
                this.dos.writeUTF("username already exists.Choose another username: ");
                this.username = dis.readUTF();
            }
            this.dos.writeUTF("registered");
            Server.users.put(username, this);
            if (Server.counter == 5) {
                for (String user : Server.users.keySet()) {
                    ClientHandler receiverHandler = Server.users.get(user);
                    receiverHandler.dos.writeUTF("The Game is on");
                }
            }
            while (true) {
                int GuessedNumber = this.dis.readInt();
                if (GuessedNumber == Server.num) {
                    for (String user : Server.users.keySet()) {
                        ClientHandler receiverHandler = Server.users.get(user);
                        receiverHandler.dos.writeUTF(username + " won the round");
                    }
                    this.dos.writeUTF("You won");
                }

            }
        } catch (Exception e) {
            Server.users.remove(username);
            try {
                this.socket.close();
                this.dis.close();
                this.dos.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
*/
