package article;

import java.util.List;

public class ArticleController {
    private static ArticleController instance = new ArticleController();

    public static ArticleController getInstance() {
        return instance;
    }

    private ArticleService aricleService = ArticleServiceImpl.getInstance();

    private ArticleController() {

        this.aricleService = aricleService;
    }


    public List<?> getArticleList() {
        return aricleService.getArticleList();
    }
}
