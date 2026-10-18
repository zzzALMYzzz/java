package ru.education.bootlab.model;
import lombok.Getter;
@Getter
public enum Positions {
 DEV(2.2,false), HR(1.2,false), TL(2.6,true), PO(2.8,true), TPM(3.0,true), CTO(3.5,true);
 private final double positionCoefficient;
 private final boolean manager;
 Positions(double coefficient,boolean manager) {this.positionCoefficient=coefficient;this.manager=manager;}
 public boolean isManager() { return manager; }
}
