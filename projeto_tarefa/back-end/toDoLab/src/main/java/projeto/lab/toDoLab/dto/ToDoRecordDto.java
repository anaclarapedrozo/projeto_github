package projeto.lab.toDoLab.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;


public record ToDoRecordDto(@NotBlank String nome,
                            @Future(message = "Data de vencimento não pode ser uma data passada")
                      LocalDate data,
                            @NotBlank String categories) {

}
