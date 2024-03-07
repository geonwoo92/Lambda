package board;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})

public class Board {
    private int id;
    private String boardName;
    private String boardType;

    @Builder(builderMethodName = "builder")

    public Board(String titboardNamele, String boardType) {
        this.boardName = boardName;
        this.boardType = boardType;

    }
}
