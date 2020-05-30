package exam.blankQuizContext.domain.model.blankQuiz;

import java.util.List;

public interface BlankQuizRepository {
  void save(BlankQuiz blankQuiz);

  BlankQuizId nextBlankQuizId();

  List<BlankQuiz> getAll();

  void delete(BlankQuizId blankQuizId);

  BlankQuiz find(BlankQuizId blankQuizId);
}
