// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.SwerveSubsystem;

public class Swerve extends CommandBase {
  /** Creates a new Swerve. */
  private  Supplier<Double> xSpdFunction,ySpdFunction, turningSpdFunction;
  private  Supplier<Boolean> fieldOrientedFunction;
  private  SwerveSubsystem swerveSubsystem;
  private  SlewRateLimiter xLimiter,yLimiter,turLimiter;

      public void SwerveJoystickCmd(SwerveSubsystem swerveSubsystem,Supplier<Double> xSpdFunction ,Supplier<Double> ySpdFunction,
      Supplier<Double>turningSpdFunction,Supplier<Boolean>fieldOrientedFunction){
        this.swerveSubsystem = swerveSubsystem;
        this.xSpdFunction = xSpdFunction;
        this.ySpdFunction = ySpdFunction;
        this.turningSpdFunction = turningSpdFunction;
        this.fieldOrientedFunction = fieldOrientedFunction;
        this.xLimiter = new SlewRateLimiter(DriveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
        this.yLimiter = new SlewRateLimiter(DriveConstants.kTeleDriveMaxAccelerationUnitsPerSecond);
        this.turLimiter = new SlewRateLimiter(DriveConstants.kTeleDriveMaxAngularAccelerationUnitsPerSecond);
        addRequirements(swerveSubsystem);
      }

  
   
    // Use addRequirements() here to declare subsystem dependencies.
  

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double xSpeed = xSpdFunction.get();
    double ySpeed = ySpdFunction.get();
    double turnigSpeed = turningSpdFunction.get();

    xSpeed = Math.abs(xSpeed) > OperatorConstants.CDB ? xSpeed : 0.0;
    ySpeed = Math.abs(ySpeed) > OperatorConstants.CDB ? ySpeed : 0.0;
    turnigSpeed = Math.abs(turnigSpeed) > OperatorConstants.CDB ? turnigSpeed : 0.0;

    xSpeed = xLimiter.calculate(xSpeed) * DriveConstants.kTeleDriveMaxSpeedMetersPerSecond;
    ySpeed = yLimiter.calculate(ySpeed) * DriveConstants.kTeleDriveMaxSpeedMetersPerSecond;
    turnigSpeed = turLimiter.calculate(turnigSpeed) * DriveConstants.kTeleDriveMaxAngularSpeedRadiansPerSecond;

    ChassisSpeeds chassisSpeeds;
    if(fieldOrientedFunction.get()){
      chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed,ySpeed,turnigSpeed,swerveSubsystem.getRotation2d());
    } else{
      chassisSpeeds = new ChassisSpeeds(xSpeed,ySpeed,turnigSpeed);
    }
    
    SwerveModuleState[] modulestates = DriveConstants.kDriveKinematics.toSwerveModuleStates(chassisSpeeds);

    swerveSubsystem.setModuleStates(modulestates);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    swerveSubsystem.stopModules();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
