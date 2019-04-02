package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

/**
 *
 */
public class TankDrive extends DriveBase {

	public TankDrive() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		boolean enabled = Robot.oi.driveMode.getSelected().equals("tank");

		return !enabled || super.isFinished();
	}

	protected double getLeft() {
		double leftspeed = MathUtil.deadbandCheck(Robot.oi.leftJoystick.getY(),
				super.deadbandY);
		leftspeed = MathUtil.delinearize(leftspeed, power);
		leftspeed *= -1;

		return leftspeed;
	}

	protected double getRight() {
		double rightspeed = MathUtil.deadbandCheck(
				Robot.oi.rightJoystick.getY(), super.deadbandY);
		rightspeed = MathUtil.delinearize(rightspeed, power);
		rightspeed *= -1;

		return rightspeed;
	}
}
