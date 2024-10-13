package frc.robot.subsystems;
import static frc.robot.Constants.IntakeConstants.*;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class IntakeSubsystem extends SubsystemBase { 
    public final CANSparkMax intakeMotor;
    public final DigitalInput beamBreaker;
    public IntakeSubsystem() {
        intakeMotor = new CANSparkMax(6, CANSparkLowLevel.MotorType.kBrushed);
        intakeMotor.setSmartCurrentLimit(kIntakeCurrentLimit);
        this.beamBreaker = new DigitalInput(0);
        
    }

    public void stop() {
        intakeMotor.set(stoppingSpeed);
    }

    public DigitalInput getBeamBreak() {
        return beamBreaker;
    }

    public void noteinPlace(CommandXboxController xboxController1, CommandXboxController xboxController2) {
      GenericHID controller1 = xboxController1.getHID();
      GenericHID controller2 = xboxController2.getHID();
    if (!beamBreaker.get()) {
      controller1.setRumble(RumbleType.kLeftRumble, 1.0);
      controller2.setRumble(RumbleType.kRightRumble, 1.0);
    } else {
      controller1.setRumble(RumbleType.kLeftRumble, 0);
      controller2.setRumble(RumbleType.kRightRumble, 0);
    }
    
  }
}