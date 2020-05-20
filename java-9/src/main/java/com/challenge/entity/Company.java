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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Table(schema = "codenation")
public class Company extends BaseEntity{

  @Column(length = 100)
  private String name;

  @Column(length = 50)
  private String slug;
}
