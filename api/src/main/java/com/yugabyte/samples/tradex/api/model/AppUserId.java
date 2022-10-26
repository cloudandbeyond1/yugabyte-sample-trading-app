package com.yugabyte.samples.tradex.api.model;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AppUserId implements Serializable {
  private static final long serialVersionUID = -4563840026487429109L;
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "preferred_region", nullable = false, length = 20)
  private String preferredRegion;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getPreferredRegion() {
    return preferredRegion;
  }

  public void setPreferredRegion(String preferredRegion) {
    this.preferredRegion = preferredRegion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    AppUserId entity = (AppUserId) o;
    return Objects.equals(this.preferredRegion, entity.preferredRegion) &&
      Objects.equals(this.id, entity.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(preferredRegion, id);
  }

}
