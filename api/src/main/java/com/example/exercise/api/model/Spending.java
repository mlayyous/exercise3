package com.example.exercise.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Spending {

  @Id
  private Long id;

  private String organisationName;

  private String effectiveDate;

  private String service;

  private String supplierName;

  private String paidDate;

  private double netAmount;

  private String purpose;

  private String transactionNumber;

  private Long ownerId;

  public Long getId() {
    return id;
  }

  public String getOrganisationName() {
    return organisationName;
  }

  public String getEffectiveDate() {
    return effectiveDate;
  }

  public String getService() {
    return service;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public String getPaidDate() {
    return paidDate;
  }

  public double getNetAmount() {
    return netAmount;
  }

  public String getPurpose() {
    return purpose;
  }

  public String getTransactionNumber() {
    return transactionNumber;
  }

  public Long getOwnerId() {
    return ownerId;
  }
}
