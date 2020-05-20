package com.challenge.entity;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 20/05/20
 Time: 14:25
 To change this template use File | Settings | File Templates.
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = "codenation")
public class Submission extends BaseEntity implements Serializable {

  @EmbeddedId
  SubmissionId submissionId;

  private BigDecimal score;

}
