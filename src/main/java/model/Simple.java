package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "Simple")
public class Simple {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @NotBlank
  private String description;

}
