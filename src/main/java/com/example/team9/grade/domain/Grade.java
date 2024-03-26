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

    @OneToOne(mappedBy = "grade")
    private Member member;

}
