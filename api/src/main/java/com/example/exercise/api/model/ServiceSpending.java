package com.example.exercise.api.model;

public class ServiceSpending {
  private String service;
  private double spending;
  public ServiceSpending() {
  }
  public ServiceSpending(String service, double spending) {
    this.service = service;
    this.spending = spending;
  }

  public String getService() {
    return service;
  }

  public double getSpending() {
    return spending;
  }

}