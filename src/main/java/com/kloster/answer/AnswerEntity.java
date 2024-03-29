package com.kloster.answer;

import com.kloster.question.QuestionEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "answer")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texto;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_entity_id")
    private QuestionEntity questionEntity;
}