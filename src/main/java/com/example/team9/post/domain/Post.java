package com.example.team9.post.domain;

import com.example.team9.board.domain.Board;
import com.example.team9.comment.domain.Comment;
import com.example.team9.member.domain.Member;
import com.example.team9.postlike.domain.PostLike;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id", nullable = false, updatable = false)
    private Long postId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedAt;

    // 조회수
    @Column(name = "post_view", nullable = false, columnDefinition = "BIGINT default 0")
    private Long postView;

    // 사용자 매핑
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    // 게시판 매핑
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post")
    private List<PostLike> postLikes = new ArrayList<>();


//    @Builder
//    public Post(String title, String content, Long postView) {
//        this.title = title;
//        this.content = content;
//        this.postView = postView;
//    }
}
