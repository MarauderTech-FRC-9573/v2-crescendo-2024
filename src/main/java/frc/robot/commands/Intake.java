package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.intakingSpeed;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends Command {
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax motor;

    public Intake(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        motor = intakeSubsystem.intakeMotor;
    }

    @Override
    public void initialize() {
        motor.set(intakingSpeed);
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean isInterrupted) {
        intakeSubsystem.stop();
    }
}
