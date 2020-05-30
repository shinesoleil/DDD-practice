package exam.blankQuizContext.application;

import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlankQuizService {
  private BlankQuizRepository blankQuizRepository;

  @Autowired
  public BlankQuizService(BlankQuizRepository blankQuizRepository) {
    this.blankQuizRepository = blankQuizRepository;
  }

  public BlankQuizId createBlankQuiz(CreateBlankQuizCommand command) {
    final int score = command.getScore();
    final BlankQuizId blankQuizId = blankQuizRepository.nextBlankQuizId();
    final BlankQuiz blankQuiz = BlankQuiz.create(blankQuizId, score);
    blankQuizRepository.save(blankQuiz);

    return blankQuizId;
  }

  public List<BlankQuiz> getAll() {
    return blankQuizRepository.getAll();
  }

  public void updateBlankQuiz(String blankQuizId, CreateBlankQuizCommand command) {
    final int score = command.getScore();
    final BlankQuiz blankQuiz = BlankQuiz.create(new BlankQuizId(blankQuizId), score);

    blankQuizRepository.delete(new BlankQuizId(blankQuizId));
    blankQuizRepository.save(blankQuiz);
  }

  public void deleteBlankQuiz(String blankQuizId) {
    blankQuizRepository.delete(new BlankQuizId(blankQuizId));
  }
}
