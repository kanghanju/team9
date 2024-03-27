package com.example.team9.member.domain;

import com.example.team9.comment.domain.Comment;
import com.example.team9.commentlike.domain.CommentLike;
import com.example.team9.grade.domain.Grade;
import com.example.team9.post.domain.Post;
import com.example.team9.postlike.domain.PostLike;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @GeneratedValue : PK 값을 각 DBMS에 맞는 자동증가 컬럼으로
    @Column(name = "member_id", updatable = false)
    // updatable = false : update문 처리될때 반영할건지 말건지 )
    private Long memberId;

    // member_name : 닉네임
    @Column(name = "member_name", nullable = false, unique = true)
    private String memberName;

    // email : 아이디
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @CreatedDate
    @Column(name = "member_created_date", nullable = false)
    private LocalDateTime memberCreatedDate;

    @Column(name = "upgrade_request", nullable = false)
    private boolean upgradeRequest;

    /* grade <-> member 1:1 단방향 */
    @OneToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

//    /* comment <-> member N:1 양방향 처리 시 사용 */
//    @OneToMany(mappedBy = "member")
//    private List<Comment> comments;

//    /* post <-> member N:1 양방향 처리할 때 사용하기 */
//    @OneToMany(mappedBy = "member")
//    private List<Post> posts;

//    /* postLike <-> member N:1 양방향 처리할 때 사용하기 */
//    @OneToMany(mappedBy = "member")
//    private List<PostLike> postLikes;

//    /* commentLike <-> member N:1 양방향 처리 시 사용 */
//    @OneToMany(mappedBy = "member")
//    private List<CommentLike> commentLikes;

}