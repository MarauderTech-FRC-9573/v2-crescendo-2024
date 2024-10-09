package frc.robot.commands;

import javax.swing.plaf.synth.SynthToolTipUI;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.ShooterSubsystem;

public class NoteInPlace extends Command {
    ShooterSubsystem shooterSubsystem;
    CommandXboxController xboxController;
    XboxController controller;

    public NoteInPlace(ShooterSubsystem shoot, CommandXboxController xbox) {
        shooterSubsystem = shoot;
        xboxController
         = xbox;
        controller = xboxController.getHID();

    }

    public void periodic() {
        if (shooterSubsystem.beamBreaker.get()) {
            controller.setRumble(RumbleType.kLeftRumble, 1.0);
            controller.setRumble(RumbleType.kRightRumble, 1.0);
        } else {
            controller.setRumble(RumbleType.kLeftRumble, 1);
            controller.setRumble(RumbleType.kRightRumble, 1);
        }

    }
}
