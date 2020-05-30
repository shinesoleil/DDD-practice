package exam.blankQuizContext.application;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateBlankQuizCommand {
  private int score;
}