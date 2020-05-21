package com.challenge.entity;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 20/05/20
 Time: 14:25
 To change this template use File | Settings | File Templates.
*/

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(schema = "codenation")
public class Candidate implements Serializable{

  @EmbeddedId
  private CandidatePK candidatePK;

  @Column(nullable = false)
  @NotNull
  private int status;

  @Column(name = "created_at", nullable = false, updatable = false)
  @CreatedDate
  @NotNull
  private LocalDateTime createdAt;

}
