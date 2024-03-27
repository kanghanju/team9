package com.example.team9.grade.domain;

import com.example.team9.member.domain.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
public class Grade {
    @Id
    @Column(name = "grade_id", nullable = false)
    private Long gradeId;

    @Column(name = "grade_name", nullable = false)
    private String gradeName;

//    /* member <-> grade 1:1 양방향 처리할 때 사용하기 */
//    @OneToOne(mappedBy = "grade")
//    private Member member;

}