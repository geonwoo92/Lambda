package user;

import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserView {
    public static void main(Scanner scanner) throws SQLException {
        UserController controller = new UserController();

        String msg = controller.addUsers();

        System.out.println(" addUsers 결과 : ");
        while (true) {
            System.out.println("[사용자메뉴] 0-종료\n " +
                    "1-회원가입\n " +
                    "2-로그인\n " +
                    "3-ID검색\n " +
                    "4-비번변경\n" +
                    "5-탈퇴\n " +
                    "6-회원목록\n " +
                    "7-이름검색\n" +
                    "8-직업검색\n" +
                    "9-회원수\n" +
                    "touch-테이블생성\n" +
                    "rm-테이블삭제");
            switch (scanner.next()) {
                case "0":
                    System.out.println("종료");
                    return;
                case "1":
                    System.out.println("1-회원가입");
                    System.out.println("회원가입 결과 : " + controller.save(scanner));
                    System.out.println("" + controller.test());
                    break;
                case "2":
                    System.out.println("2-로그인");
                    System.out.println("로그인 결과 : " + controller.login(scanner));
                    break;
                case "3":
                    System.out.println("3-ID 검색");
//                    User u= finO
//                  System.out.println(controller.getOne(scanner));

                    break;
                case "4":
                    System.out.println("4-비번변경");
                    System.out.println(controller.updatePassword(scanner));
                    break;
                case "5":
                    System.out.println("5-탈퇴");
                    System.out.println(controller.delete(scanner));
                    break;
                case "6":
                    System.out.println("6-회원목록");
                    List<?> users = controller.findUsers();
//                    users.forEach(i-> System.out.println(i));

                    break;
                case "7":
                    System.out.println("7-이름검색");
                    controller.findUsersByName(scanner).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "8":
                    System.out.println("8-직업검색");
                    controller.findUsersByJob(scanner).forEach((i) -> {
                        System.out.println(i);
                    });
                    break;
                case "touch":
                    System.out.println("테이블생성");

                    System.out.println("회원테이블 생성 성공"+ controller.createTable());

                    break;

                case "rm":
                    System.out.println("테이블삭제");
                    System.out.println("회원테이블 삭제 성공 "+controller.deleteTable());
                    break;


            }
        }
    }
}


