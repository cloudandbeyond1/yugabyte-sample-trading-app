package com.yugabyte.samples.tradex.api.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.time.Instant;

@TypeDefs({
  @TypeDef(name = "json", typeClass = JsonType.class)
})
@MappedSuperclass
public class BaseEntity {

  @Column(name = "created_date")
  private Instant createdDate;

  @Column(name = "updated_date")
  private Instant updatedDate;

  public Instant getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Instant createdDate) {
    this.createdDate = createdDate;
  }

  public Instant getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Instant updatedDate) {
    this.updatedDate = updatedDate;
  }

  @PrePersist
  public void prePersist(){
    this.createdDate = Instant.now();
    this.updatedDate = Instant.now();
  }

  @PreUpdate
  public void preUpdate(){
    this.updatedDate = Instant.now();
  }
}
