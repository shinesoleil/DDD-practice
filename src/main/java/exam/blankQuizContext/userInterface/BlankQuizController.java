package exam.blankQuizContext.userInterface;

import exam.blankQuizContext.application.BlankQuizService;
import exam.blankQuizContext.application.CreateBlankQuizCommand;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuiz;
import exam.blankQuizContext.domain.model.blankQuiz.BlankQuizId;
import exam.paperContext.application.AssemblePaperCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlankQuizController {

  private BlankQuizService blankQuizService;

  @Autowired
  public BlankQuizController(BlankQuizService blankQuizService) {
    this.blankQuizService = blankQuizService;
  }

  @PostMapping(value = "/blankQuizzes", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  @ResponseStatus(HttpStatus.CREATED)
  BlankQuizDTO create(@RequestBody CreateBlankQuizCommand command) {
    final BlankQuizId blankQuizId = blankQuizService.createBlankQuiz(command);
    return BlankQuizDTO.from(blankQuizId);
  }

  @GetMapping("/blankQuizzes")
  List<BlankQuiz> getAll() {
    return blankQuizService.getAll();
  }

  @PutMapping("/blankQuizzes/{blankQuizId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void update(@PathVariable String blankQuizId, @RequestBody CreateBlankQuizCommand command) {
    blankQuizService.updateBlankQuiz(blankQuizId, command);
  }

  @DeleteMapping("/blankQuizzes/{blankQuizId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  void delete(@PathVariable String blankQuizId) {
    blankQuizService.deleteBlankQuiz(blankQuizId);
  }

}
