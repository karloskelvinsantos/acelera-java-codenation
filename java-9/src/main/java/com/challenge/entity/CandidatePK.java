package com.challenge.entity;
/*
 Created by IntelliJ IDEA.
 User: kelvin
 Date: 20/05/20
 Time: 19:46
 To change this template use File | Settings | File Templates.
*/

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@Data
class CandidatePK implements Serializable {
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  @NotNull
  private User user;

  @ManyToOne
  @JoinColumn(name = "acceleration_id", nullable = false)
  @NotNull
  private Acceleration acceleration;

  @ManyToOne
  @JoinColumn(name = "company_id", nullable = false)
  @NotNull
  private Company company;
}
