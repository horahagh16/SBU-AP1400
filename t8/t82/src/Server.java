import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    static Map<String, ClientHandler> users;
    static int num;
    //= 10000 + (int) (Math.random() * 89999 + 1);
    static int counter = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(1222);
        users = new ConcurrentHashMap<>();
        URL url = new URL("https://api.github.com/users/roozbehsayadi");
        Scanner sc = new Scanner(url.openStream());
        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        String result = sb.toString();
        result = result.substring(result.indexOf(",\"node_id") - 5, result.indexOf(",\"node_id"));
        num = Integer.parseInt(result);
        try {
            while (counter != 5) {
                Socket socket = ss.accept();
                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();
                counter++;
            }
            System.out.println("start");
        } catch (Exception e) {
            ss.close();
        }
    }
}

class ClientHandler implements Runnable {
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
                int round = 1;
                int GuessedNumber = this.dis.readInt();
                if (GuessedNumber == Server.num) {
                    for (String user : Server.users.keySet()) {
                        ClientHandler receiverHandler = Server.users.get(user);
                        receiverHandler.dos.writeUTF(username + " won the round");
                    }
                    this.dos.writeUTF("You won");
                    round++;
                    Server.num = Server.num * round;
                    //Server.num = 10000 + (int) (Math.random() * 89999);
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