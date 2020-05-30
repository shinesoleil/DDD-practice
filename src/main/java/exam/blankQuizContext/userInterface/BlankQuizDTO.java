package exam.blankQuizContext.userInterface;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlankQuizDTO {
  private String uri;

  public static BlankQuizDTO from(BlankQuizId blankQuizId) {
    return new BlankQuizDTO("blankQuizzes/" + blankQuizId);
  };
}