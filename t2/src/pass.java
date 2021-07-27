import java.util.Scanner;

public class pass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String password = input.nextLine();
        char[] passArr = password.toCharArray();
        int flag = 0;
        for (int i = 0; i < passArr.length; i++) {
            if (passArr[i] == '1' || passArr[i] == '0') {
                flag = 1;
            } else{
                flag=0;
                break;
            }
        }

//        if (flag == 0) {
//            for (int i = 0; i < passArr.length; i++) {
//                if (passArr[i] == 'a' || passArr[i]=='b'){
//                    if ((i+1)%3==0&&passArr[i]!='a'){
//                        flag=0;
//                        break;
//                    }
//                    flag=1;
//                }else {
//                    flag=0;
//                    break;
//                }
//            }
//        }
        if (flag==0)
            System.out.println("Invalid password");

    }
}
