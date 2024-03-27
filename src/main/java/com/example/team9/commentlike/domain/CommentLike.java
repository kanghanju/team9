package com.example.team9.commentlike.domain;

import com.example.team9.comment.domain.Comment;
import com.example.team9.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class CommentLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentlike_id", nullable = false)
    private Long commentLikeId;

    /* commentLike <-> member N:1 단방향 */
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    /* commentLike <-> comment N:1 단방향 */
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;
}

