package com.example.team9.comment.domain;

import com.example.team9.commentlike.domain.CommentLike;
import com.example.team9.member.domain.Member;
import com.example.team9.post.domain.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long commentId;

    @Column(name = "comment_content", columnDefinition = "TEXT", nullable = false)
    private String commentContent;

    /* comment <-> member N:1 단방향 */
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    /* comment <-> post N:1 단방향 */
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//    // 주인이 되는 CommentLike 클래스에서 연관관계로 선언된 Comment 필드명(comment)을 mappedBy에 나타냄.
//    /* commentLike <-> comment N:1 양방향 처리 시 사용 */
//    @OneToMany(mappedBy = "comment")
//    private List<CommentLike> commentLikes;

}