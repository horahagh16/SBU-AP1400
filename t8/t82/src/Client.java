import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;

    public Client(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 1222);
        Scanner input = new Scanner(System.in);
        System.out.println("enter username");
        String username = "";
        boolean usernameValidation = false;
        try {
            do {
                username = input.nextLine();
                client.dos.writeUTF(username);
                String serverValidation = client.dis.readUTF();
                System.out.println(serverValidation);
                if (!serverValidation.startsWith("username")) {
                    usernameValidation = true;
                }
            } while (!usernameValidation);

            Thread messageListener = new Thread(new MessageListener(client.dis));
            messageListener.start();
            while (true) {
                int number = input.nextInt();
                client.dos.writeInt(number);
            }
        } catch (Exception e) {
            client.socket.close();
            client.dis.close();
            client.dos.close();
        }
    }
}

class MessageListener implements Runnable {
    DataInputStream dis;

    MessageListener(DataInputStream dis) {
        this.dis = dis;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String serverMsg = this.dis.readUTF();
                System.out.println(serverMsg);
            }
        } catch (Exception e) {
            try {
                dis.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}


