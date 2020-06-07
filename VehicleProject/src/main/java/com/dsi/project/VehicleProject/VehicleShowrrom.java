package com.dsi.project.VehicleProject;

import java.io.*;
import java.util.*;

interface ShowroomDelegate {
  public void addToShowroom(Showroom showroom);
  public void removeFromShowroom(Showroom showroom);
}

abstract class Vehicle implements ShowroomDelegate
{
  String model;
  enum engine_type {
      OIL,
      GAS,
      DIESEL
    };
  int engine_power;
  String tier_size;
  
  engine_type eg_typ;

  public Vehicle(String model, int engine_power, String tier_size, engine_type eg_typ) {
    super();
    this.model = model;
    this.engine_power = engine_power;
    this.tier_size = tier_size;
    this.eg_typ = eg_typ;
  }
  
  public void printDetails() {
      System.out.println("model: " + model + "\n"+ "Engine Power: "+ engine_power+ "\n"+ "tier size: " + tier_size +"\n"+ "Engine Type: "+ eg_typ);
  }
  
  @Override
  public void addToShowroom(Showroom showroom) {
    showroom.vehicles.add(this);
  }
  
  @Override
  public void removeFromShowroom(Showroom showroom) {
    showroom.vehicles.remove(this);
  }
}

class Normal extends Vehicle
{
  public Normal(String model, int engine_power, String tier_size, engine_type eg_typ) {
    super(model, engine_power, tier_size, eg_typ);
  }  
}

class Sports extends Vehicle
{
  boolean IsTurbo;
  public Sports(String model, int engine_power, String tier_size) {
    super(model, engine_power, tier_size, engine_type.OIL);
    this.IsTurbo = true;
  }
  
  @Override
  public void printDetails() {
      super.printDetails();
      System.out.println("IsTurbo: " + IsTurbo);
  }
  
  @Override
  public void addToShowroom(Showroom showroom) {
    super.addToShowroom(showroom);
    showroom.spectators += 20;
  }
  
  @Override
  public void removeFromShowroom(Showroom showroom) {
    super.removeFromShowroom(showroom);
    showroom.spectators -= 20;
  }
}

class Heavy extends Vehicle
{
  int weight;
  public Heavy(String model, int engine_power, String tier_size, int weight) {
    super(model, engine_power, tier_size, engine_type.DIESEL);
    this.weight = weight;
  }
  
  @Override
  public void printDetails() {
      super.printDetails();
      System.out.println("Weight: " + weight);
  }
}

class Showroom
{
  Set<Vehicle> vehicles;
  long spectators;
  
  public Showroom() {
    vehicles = new HashSet<Vehicle>();
    spectators = 30;
  }
  
  public Showroom(Set<Vehicle> vehicles, long spectators) {
    this.vehicles = vehicles;
    this.spectators = spectators;
  }
  
  public void printList()
  {
     for (Vehicle vehicle: vehicles)
     {
        vehicle.printDetails();
     }    
    
    System.out.println("Visitors: "+ spectators);
    System.out.println();
    System.out.println();
    System.out.println();
  }
  
}

public class VehicleShowrrom {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Showroom showroom = new Showroom();
	    Vehicle v1 = new Normal("Chervolet", 125, "21581/AcP250", Vehicle.engine_type.GAS);
	    Vehicle v2 = new Sports("mod2", 125, "mod2/AcP250");
	    Vehicle v3 = new Heavy("mod3", 652, "mod3/AcP250", 60);
	    v1.addToShowroom(showroom);
	    v2.addToShowroom(showroom);
	    v3.addToShowroom(showroom);
	    showroom.printList();
	    v2.removeFromShowroom(showroom);
	    showroom.printList();
        
	}

}
