package frc.robot.commands;

import static frc.robot.Constants.IntakeConstants.intakingSpeed;
import static frc.robot.Constants.IntakeConstants.launchSpeed;
import java.util.*;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class AutoIntakeBack extends Command {
    private IntakeSubsystem intakeSubsystem;
    private CANSparkMax motor;
    private int timer = 0;

    public AutoIntakeBack(IntakeSubsystem intakeSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        motor = intakeSubsystem.intakeMotor;
    }

    @Override
    public void initialize() {
        motor.set(launchSpeed);
    }

    @Override
    public void execute() {}

    @Override
    public void end(boolean isInterrupted) {
        intakeSubsystem.stop();
    }

    @Override
    public boolean isFinished() {
        timer++;

        //if (timer = )
        return true;
    }
}
