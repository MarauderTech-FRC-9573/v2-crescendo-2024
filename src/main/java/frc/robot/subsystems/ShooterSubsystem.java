package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import static frc.robot.Constants.ShooterConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  final CANSparkMax bottomShooterMotor;
  final CANSparkMax topShooterMotor;
  
  public ShooterSubsystem() { 
    bottomShooterMotor = new CANSparkMax(0, MotorType.kBrushless);
    topShooterMotor = new CANSparkMax(1, MotorType.kBrushless);
  }
  
  public Command shootSpeaker() {
    return this.startEnd ( 
    () -> {
      bottomShooterMotor.set(kSpeakerSpeed);
      topShooterMotor.set(kSpeakerSpeed);
    }, 
    () -> {
      stop();
    });
  }
  
  public Command shootAmp() {
    return this.startEnd (
    () -> {
      bottomShooterMotor.set(kAmpSpeedTop);
      topShooterMotor.set(kAmpSpeedBottom);
    },
    () -> {
      stop();
    });
    
  }
  
  public void stop() {
    bottomShooterMotor.set(0);
    topShooterMotor.set(0);
  }
}