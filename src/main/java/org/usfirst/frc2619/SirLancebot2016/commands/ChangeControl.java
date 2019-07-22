package org.usfirst.frc2619.SirLancebot2016.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class ChangeControl extends Command {

    public ChangeControl() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}
    	// Called just before this Command runs the first time
	protected void initialize() {
        Robot.xboxcontrol = !Robot.xboxcontrol;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.wrist.wristbool = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
        end();
	}
}