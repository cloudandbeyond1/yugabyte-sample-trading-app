package com.yugabyte.samples.tradex.api.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RefDatumId implements Serializable {
  private static final long serialVersionUID = -3709233261715645987L;
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "key_name", nullable = false, length = 200)
  private String keyName;

  @Column(name = "classifier", nullable = false, length = 100)
  private String classifier;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getKeyName() {
    return keyName;
  }

  public void setKeyName(String keyName) {
    this.keyName = keyName;
  }

  public String getClassifier() {
    return classifier;
  }

  public void setClassifier(String classifier) {
    this.classifier = classifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    RefDatumId entity = (RefDatumId) o;
    return Objects.equals(this.keyName, entity.keyName) &&
      Objects.equals(this.classifier, entity.classifier) &&
      Objects.equals(this.id, entity.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyName, classifier, id);
  }

}
