// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenixpro.hardware.core.CoreCANcoder;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {

    public static final int controller1 = 0;//Has To Change

    public static final int Left_Stick_Y = 1;//Has To Change

    public static final int Left_Stick_X = 5;//Has To Change

    public static final int left_bumper = 1;//Has To Change

    public static final int right_bumper = 0;//Has To Change

    public static final double CDB = 0.05;



    
    public static final int controller2 = 1;

    public static final int Right_Stick_Y = 5;

    public static final int Right_Stick_X = 4;

    public static final String AbuttonC1 = null;

    
  }
  public static final class ModuleConstants {
    public static final double kWheelDiameterMeters = Units.inchesToMeters(4);//Has To Change
    public static final double kDriveMotorGearRatio = 1 / 5.8462;//Has To Change
    public static final double kTurningMotorGearRatio = 1 / 18.0;//Has To Change
    public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
    public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
    public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;//Has To Change
    public static final double kTurningEncoderRPM2RadPerSec = kTurningEncoderRot2Rad / 60;//Has To Change
    public static final double kPTurning = 0.5;//Has To Change
}

public static final class DriveConstants {

  public static final double kTrackWidth = Units.inchesToMeters(21);
  // Distance between right and left wheels
  public static final double kWheelBase = Units.inchesToMeters(25.5);
  // Distance between front and back wheels
  public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
          new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
          new Translation2d(kWheelBase / 2, kTrackWidth / 2),
          new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
          new Translation2d(-kWheelBase / 2, kTrackWidth / 2));

  public static final int kFrontLeftDriveMotorPort = 8;//Has To Change
  public static final int kBackLeftDriveMotorPort = 2;//Has To Change
  public static final int kFrontRightDriveMotorPort = 6;//Has To Change
  public static final int kBackRightDriveMotorPort = 4;//Has To Change

  public static final int kFrontLeftTurningMotorPort = 7;//Has To Change
  public static final int kBackLeftTurningMotorPort = 1;//Has To Change
  public static final int kFrontRightTurningMotorPort = 5;//Has To Change
  public static final int kBackRightTurningMotorPort = 3;//Has To Change

  public static final boolean kFrontLeftTurningEncoderReversed = true;
  public static final boolean kBackLeftTurningEncoderReversed = true;
  public static final boolean kFrontRightTurningEncoderReversed = true;
  public static final boolean kBackRightTurningEncoderReversed = true;

  public static final boolean kFrontLeftDriveEncoderReversed = true;
  public static final boolean kBackLeftDriveEncoderReversed = true;
  public static final boolean kFrontRightDriveEncoderReversed = false;
  public static final boolean kBackRightDriveEncoderReversed = false;

  public static final int kFrontLeftDriveAbsoluteEncoderPort = 0;//Has To Change
  public static final int kBackLeftDriveAbsoluteEncoderPort = 2;//Has To Change
  public static final int kFrontRightDriveAbsoluteEncoderPort = 1;//Has To Change
  public static final int kBackRightDriveAbsoluteEncoderPort = 3;//Has To Change

  public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = false;
  public static final boolean kBackLeftDriveAbsoluteEncoderReversed = false;
  public static final boolean kFrontRightDriveAbsoluteEncoderReversed = false;
  public static final boolean kBackRightDriveAbsoluteEncoderReversed = false;

  public static final double kFrontLeftDriveAbsoluteEncoderOffsetRad = 1;//Has To Change
  public static final double kBackLeftDriveAbsoluteEncoderOffsetRad  = 1;//Has To Change
  public static final double kFrontRightDriveAbsoluteEncoderOffsetRad  = 1;//Has To Change
  public static final double kBackRightDriveAbsoluteEncoderOffsetRad  = 1;//Has To Change

  public static final double kPhysicalMaxSpeedMetersPerSecond = 5;
  public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

  public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 4;
  public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
  public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3;
  public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;


}










  public static final double motorMAX = 0.5;
  public static int controller2;
public static int controller1;



}

