package com.yugabyte.samples.tradex.api.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "ref_data")
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class RefDatum extends BaseEntity{
  @EmbeddedId
  private RefDatumId id;

  @Type(type = "json")
  @Column(name="key_value", columnDefinition = "json")
  private String keyValue;

}
