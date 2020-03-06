package frc.robot.commands.auto;

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/


import java.util.List;

import com.nerdherd.lib.drivetrain.auto.DriveStraightContinuous;
import com.nerdherd.lib.drivetrain.experimental.Drivetrain;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.constants.DriveConstants;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class Ramsete5Ball extends SequentialCommandGroup {
  /**
   * Creates a new Ramsete5Ball.
   */
  private Drivetrain m_drive;
  public Ramsete5Ball(Drivetrain drive) {
    m_drive = drive;
    m_drive.setPose(new Pose2d(DriveConstants.kAutoLineMeters, DriveConstants.kGoalMetersY, new Rotation2d(Math.PI)));
   

    TrajectoryConfig m_config = new TrajectoryConfig(3, 2.0);
    // m_config.addConstraint(autoVoltageConstraint);
     Trajectory m_traj = TrajectoryGenerator.generateTrajectory(new Pose2d(3.048, -2.404, new Rotation2d(Math.PI)),
    List.of(new Translation2d(1.5,-2.404)), new Pose2d(-0.0254, -2.404, new Rotation2d(Math.PI)),
        m_config);
     RamseteCommand ramsete = new RamseteCommand(m_traj, m_drive::getPose2d, new RamseteController(2.0, 2.7), 
     new SimpleMotorFeedforward(DriveConstants.kramseteS, DriveConstants.kramseteV, DriveConstants.kramseteA), 
     m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
     new PIDController(DriveConstants.kLeftP, DriveConstants.kLeftI, DriveConstants.kLeftD), 
     new PIDController(DriveConstants.kRightP, DriveConstants.kRightI, DriveConstants.kRightD),
     m_drive::setVoltage, m_drive);
      
    
      Trajectory m_traj2 = TrajectoryGenerator.generateTrajectory(new Pose2d(0, -2.404, new Rotation2d(Math.PI)),
      List.of(new Translation2d(1.344, -2.268), new Translation2d(3.5, -0.685)), new Pose2d(5.182, -0.705, new Rotation2d(0)),
      m_config);
      RamseteCommand ramsete2 = new RamseteCommand(m_traj2, m_drive::getPose2d, new RamseteController(2.28, 0.7), 
      new SimpleMotorFeedforward(DriveConstants.kramseteS, DriveConstants.kramseteV, DriveConstants.kramseteA), 
      m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
      new PIDController(DriveConstants.kLeftP, DriveConstants.kLeftI, DriveConstants.kLeftD), 
      new PIDController(DriveConstants.kRightP, DriveConstants.kRightI, DriveConstants.kRightD),
      m_drive::setVoltage, m_drive);
    
      
      Trajectory m_traj3 = TrajectoryGenerator.generateTrajectory(new Pose2d(5.182, -0.705, new Rotation2d(0)),
      List.of(new Translation2d(10.735, -0.705), new Translation2d(10.1, -2.1)), new Pose2d(6.401, -2.404, new Rotation2d(Math.PI)),
      m_config);
      RamseteCommand ramsete3 = new RamseteCommand(m_traj3, m_drive::getPose2d, new RamseteController(0.21, 0.7), 
      new SimpleMotorFeedforward(DriveConstants.kramseteS, DriveConstants.kramseteV, DriveConstants.kramseteA), 
      m_drive.m_kinematics, m_drive::getCurrentSpeeds, 
      new PIDController(DriveConstants.kLeftP, DriveConstants.kLeftI, DriveConstants.kLeftD), 
      new PIDController(DriveConstants.kRightP, DriveConstants.kRightI, DriveConstants.kRightD),
      m_drive::setVoltage, m_drive);
    
      
      addCommands(ramsete, ramsete2, ramsete3, new DriveStraightContinuous(m_drive, 0, 0));
 
  }
}