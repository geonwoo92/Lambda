package article;

import java.util.List;

public class ArticleController {
    private static ArticleController instance = new ArticleController();
    private ArticleService aricleService;

    private ArticleController() {
        this.aricleService = ArticleServiceImpl.getInstance();
    }
    public static ArticleController getInstance() {
        return instance;
    }

    public List<?> getArticleList() {
        return aricleService.getArticleList();
    }
}
