package com.yugabyte.samples.tradex.api.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "trades")
public class Trade {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "trade_id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumns({
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false),
    @JoinColumn(name = "preferred_region", referencedColumnName = "preferred_region", nullable = false)
  })
  private AppUser appUser;

  @Column(name = "symbol", length = 6)
  private String symbol;

  @Column(name = "trade_type", length = 20)
  private String tradeType;

  @Column(name = "order_time")
  private Instant orderTime;

  @Column(name = "bid_price")
  private Double bidPrice;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public AppUser getAppUser() {
    return appUser;
  }

  public void setAppUser(AppUser appUser) {
    this.appUser = appUser;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getTradeType() {
    return tradeType;
  }

  public void setTradeType(String tradeType) {
    this.tradeType = tradeType;
  }

  public Instant getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(Instant orderTime) {
    this.orderTime = orderTime;
  }

  public Double getBidPrice() {
    return bidPrice;
  }

  public void setBidPrice(Double bidPrice) {
    this.bidPrice = bidPrice;
  }

}
