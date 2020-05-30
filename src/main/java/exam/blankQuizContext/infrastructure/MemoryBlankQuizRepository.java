package exam.blankQuizContext.infrastructure;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
public class MemoryBlankQuizRepository implements BlankQuizRepository {
  private List<BlankQuiz> blankQuizList = new ArrayList<>();

  @Override
  public BlankQuiz find(BlankQuizId blankQuizId) {
    return blankQuizList.stream().filter(blankQuiz-> {
      return blankQuiz.getBlankQuizId().equals(blankQuizId);
    }).findFirst().orElseThrow(NullPointerException::new);
  }

  @Override
  public void save(BlankQuiz blankQuiz) {
    blankQuizList.add(blankQuiz);
  }

  @Override
  public BlankQuizId nextBlankQuizId() {
    return new BlankQuizId("blankQuizzes-" + UUID.randomUUID().toString());
  }

  @Override
  public List<BlankQuiz> getAll() {
    return blankQuizList;
  }

  @Override
  public void delete(BlankQuizId blankQuizId) {
    blankQuizList.removeIf(item -> item.getBlankQuizId().sameValueAs(blankQuizId));
  }
}
