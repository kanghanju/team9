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

    @Column(name = "wrtie_grade")
    private String writeGrade;

    @Column(name = "read_grade")
    private String readGrade;

    @Column(name = "board_sort")
    private int boardSort;

    @OneToMany(mappedBy = "board")
    private List<Post> posts;

}
