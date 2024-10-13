package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import static frc.robot.Constants.ShooterConstants.*;

import java.time.Year;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ShooterSubsystem extends SubsystemBase {
  public final CANSparkMax bottomShooterMotor;
  public final CANSparkMax topShooterMotor;
  //public final DigitalInput beamBreaker = new DigitalInput(0); // arbitrary channel value chnage to actual value
  
  public ShooterSubsystem() { 
    bottomShooterMotor = new CANSparkMax(7, MotorType.kBrushless);
    topShooterMotor = new CANSparkMax(8, MotorType.kBrushless);
    bottomShooterMotor.setSmartCurrentLimit(kShooterCurrentLimit);
    topShooterMotor.setSmartCurrentLimit(kShooterCurrentLimit);
  }
  
  public void stop() {
    bottomShooterMotor.set(0);
    topShooterMotor.set(0);
  }
  
}