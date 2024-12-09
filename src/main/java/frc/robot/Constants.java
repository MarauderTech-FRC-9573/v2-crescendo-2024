// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  
  public static final class DriveConstants {
    
    // PWM ports/CAN IDs for motor controllers
    public static final int kLeftRearID = 5;
    public static final int kLeftFrontID = 4;
    public static final int kRightRearID = 2;
    public static final int kRightFrontID = 3;
    
    // Current limit for drivetrain motors
    public static final int kDriveCurrentLimit = 40;
    
    public static int driverControllerPort = 0;
    public static int operatorControllerPort = 1;
    
    //PID values for gyro taken from wpilib gyrocommand example
    
    public static final boolean kGyroReversed = false;
    
    public static final double kTurnP = 0;
    public static final double kTurnI = 0;
    public static final double kTurnD = 0;
    
    public static final double kMaxTurnRateDegPerS = 100;
    public static final double kMaxTurnAccelerationDegPerSSquared = 300;
    
    public static final double kTurnToleranceDeg = 5;
    public static final double kTurnRateToleranceDegPerS = 10; // degrees per second
    
    // varys per robot and must be tuned 
    // try Robot Characterization Toolsuite to get these values
    // These values are not used anywhere on the robot
    public static final double ksVolts = 0.22;
    public static final double kvVoltSecondsPerMeter = 1.98;
    public static final double kaVoltSecondsSquaredPerMeter = 0.2;
    public static final double kvVoltSecondsPerRadian = 1.5;
    public static final double kaVoltSecondsSquaredPerRadian = 0.3;
    
    public static double kWheelDiameterMeters = 0.15;
    
    // default speed of the robot
    public static double precisionSpeed = 0.2;
    public static double defaultSpeed = 0.8;
    public static double turboSpeed = 1.0;
    
    
    
    
  }
  
    
    // Intake Constants
    public static final class IntakeConstants {
      
      public static final double intakingSpeed = -0.50;
      public static final double ejectingSpeed = 0.50;
      public static final double stoppingSpeed = 0.00;
      public static final double launchSpeed = 0.2;

      public static final int kIntakeCurrentLimit = 40;
      
    }
            
    
    public static final class ShooterConstants {
      
      // Speeds for wheels when intaking and launching. Intake speeds are negative to run the wheels
      // in reverse
      public static final double kSpeakerSpeed = 0.7; //Speed of shooting into speaker. both top and bottom flywheels run at the same speed 
      
      public static final double kAmpSpeedTop = 0.1; //Speed of shooting into the amp, running the top wheels
      public static final double kAmpSpeedBottom = 0.30; //Speed of shooting into the amp, running the bottom wheels
      
      public static final double kSpoonSpeedTop = 0.8;
      public static final double kSpoonSpeedBottom = 0.5;

      public static final double kIntakeEject = -0.3;

      public static final int kShooterCurrentLimit = 80;
      
    }
    
    
  }