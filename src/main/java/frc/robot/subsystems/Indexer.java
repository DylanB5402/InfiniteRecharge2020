/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.nerdherd.lib.motor.single.SingleMotorMechanism;
import com.nerdherd.lib.sensor.VexUltrasonic;
import com.nerdherd.lib.sensor.analog.LinearAnalogSensor;
import com.nerdherd.lib.sensor.digital.TalonTach;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import frc.robot.constants.IndexerConstants;

public class Indexer extends SingleMotorMechanism {
  public TimeOfFlight timeOfFlight1;
  public TimeOfFlight timeOfFlight2;
  public VexUltrasonic ultrasonic;
  // public Ultrasonic ultrasonic;
  /**
   * Creates a new Indexer.
   */
  public Indexer() {
    super(RobotMap.kIndex, "Indexer", false, false);
    timeOfFlight1 = new TimeOfFlight(RobotMap.kTimeOfFlightSensorID1);
    timeOfFlight2 = new TimeOfFlight(RobotMap.kTimeOfFlightSensorID2);
    // ultrasonic = new VexUltrasonic("Ultrasonic", 5, 6);
    // ultrasonic = new Ultrasonic(0, 0);
    super.configPIDF(IndexerConstants.kP, IndexerConstants.kI, IndexerConstants.kD, IndexerConstants.kF);
    super.configDeadband(IndexerConstants.kDeadband);


  }
  public int intakeDetermine(int intakeState){
    return intakeState;
  }

  @Override
  public void periodic() {
    // SmartDashboard.putNumber("TimeOfFlight1", timeOfFlight1.getRange());
    // SmartDashboard.putNumber("TimeOfFlight2", timeOfFlight2.getRange());
    // SmartDashboard.putNumber("VEXultra", ultrasonic.getRangeInches());
    
    // This method will be called once per scheduler run
  }

  @Override
  public void reportToSmartDashboard() {
    super.reportToSmartDashboard();
    SmartDashboard.putNumber("time of flight 1", timeOfFlight1.getRange());
    SmartDashboard.putNumber("time of flight 2", timeOfFlight2.getRange());
    // SmartDashboard.putNumber("Ultrasonic", ultrasonic.getRangeInches());
  }
}
