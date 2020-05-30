package exam.blankQuizContext.domain.model.blankQuiz;

import exam.blankQuizContext.domain.shared.Entity;

public class BlankQuiz implements Entity<BlankQuiz> {
  private BlankQuizId blankQuizId;
  private int score;

  public BlankQuiz(BlankQuizId blankQuizId, int score) {
    this.blankQuizId = blankQuizId;
    this.score = score;
  }

  public static BlankQuiz create(BlankQuizId blankQuizId, int score) {
    // TODO: score validation
    return new BlankQuiz(blankQuizId, score);
  }

  public BlankQuizId getBlankQuizId() {
    return blankQuizId;
  }

  @Override
  public boolean sameIdentityAs(BlankQuiz other)  {
    return blankQuizId.sameValueAs(other.getBlankQuizId());
  }
}
