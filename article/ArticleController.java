package com.erich.api.article;

import java.sql.SQLException;
import java.util.List;

public class ArticleController {
    private ArticleServiceImpl articleService;

    public ArticleController() {
        this.articleService = ArticleServiceImpl.getInstance();
    }

    public List<?> findAll() throws SQLException {
        return articleService.findAll();
    }
}
