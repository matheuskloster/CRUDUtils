package com.kloster.question;

import com.kloster.answer.AnswerModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class QuestionModel {

    private Long id;
    private String texto;
    private String username;
    private List<AnswerModel> answers;


}
