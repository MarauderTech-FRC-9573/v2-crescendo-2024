package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.intakingSpeed;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax motor;
    public final DigitalInput beamBreaker;


    public Intake(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        motor = intakeSubsystem.intakeMotor;
        beamBreaker = intakeSubsystem.getBeamBreak();
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        if (!beamBreaker.get()) {
            motor.set(0);
        } else {
            motor.set(intakingSpeed);
        }
    }

    @Override
    public void end(boolean isInterrupted) {
        intakeSubsystem.stop();
    }
}
