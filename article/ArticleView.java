package article;

import java.util.Scanner;

public class ArticleView {
    private static ArticleController articleController = ArticleController.getInstance();

    public static void main(Scanner sc) {


        while (true){
            System.out.println("=== 0-종료 " +
                    "1-글 목록");
            switch (sc.next()){
                case"0":
                    System.out.println("종료");
                    return;
                case"1":
                    System.out.println("글 목록");
                    articleController.getArticleList().forEach(System.out::println);


                    break;

            }
        }
    }
}
