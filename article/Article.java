package article;

import lombok.Builder;

public class Article { private int id;
    private String title;
    private String content;
    private String writer;

    @Builder(builderMethodName = "builder")

    public Article( String title, String content, String writer) {

        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
