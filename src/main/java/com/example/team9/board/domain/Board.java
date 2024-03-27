package com.example.team9.board.domain;

import com.example.team9.post.domain.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Board {
    @Id
    @Column(name = "board_id", nullable = false)
    private Long boardId;

    @Column(name = "board_name", nullable = false)
    private String boardName;

    @Column(name = "board_wrtie_grade", nullable = false)
    private String boardWriteGrade;

    @Column(name = "board_read_grade", nullable = false)
    private String boardReadGrade;

    @Column(name = "board_sort", nullable = false)
    private int boardSort;

//    /* post <-> board N:1 양방향 처리 시 사용 */
//    @OneToMany(mappedBy = "board")
//    private List<Post> posts;

}
