package br.icaromartins.todolisticaro.tasks;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Entity(name = "tb_tasks")
public class TaskModel {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "descricao", nullable = false)
    private String description;

    @Column(nullable = false, length = 50, name = "titulo")
    private String title;


    private LocalDateTime startAt;


    private LocalDateTime endAt;

    @Column(name = "prioridade", length = 30, nullable = false)
    private String priority;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private UUID idUser;
}
