package com.example.team9.member.domain;

import com.example.team9.grade.domain.Grade;
import com.example.team9.post.domain.Post;
import com.example.team9.postlike.domain.PostLike;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "member")
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
    private LocalDateTime created_date;

    @Column(name = "upgrade_request", nullable = false)
    private boolean upgradeRequest;

    // member <-> post 1:N 양방향
    @OneToMany(mappedBy = "member")
    private List<Post> posts;

    // member <-> postLike 1:N 양? 단?
    @OneToMany(mappedBy = "member")
    private List<PostLike> postLikes;

    //grade <-> member 1:1 양방향
    @OneToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;


//    @Builder
//    public Member(String memberName, String email, String password, String grade) {
//        this.memberName = memberName;
//        this.email = email;
//        this.password = password;
////        this.grade = grade;
//    }

}
