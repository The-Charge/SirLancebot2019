package org.usfirst.frc2619.SirLancebot2016.commands;

import org.usfirst.frc2619.MathUtil;
import org.usfirst.frc2619.SirLancebot2016.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TankDrive extends DriveBase {

	public double speedMode;
	
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
		/**double leftspeed = MathUtil.deadbandCheck(Robot.oi.leftJoystick.getY(),
				super.deadbandY);
		leftspeed = MathUtil.delinearize(leftspeed, power);
		//Test this code after June Demos and if still doesn't work, comment out the above line. If it still doesn't work, try different powers in drive base
		leftspeed *= -1*Robot.driveTrain.speedMode;

		return leftspeed;
		 */
		return  MathUtil.adjSpeed( -Robot.oi.leftJoystick.getY());
	}

	protected double getRight() {
		/** 
		double rightspeed = MathUtil.deadbandCheck(
				Robot.oi.rightJoystick.getY(), super.deadbandY);
		rightspeed = MathUtil.delinearize(rightspeed, power);
		//Test this code after June Demos and if still doesn't work, comment out the above line. If it still doesn't work, try different powers in drive base
		rightspeed *= -1*Robot.driveTrain.speedMode;

		return rightspeed;
		*/
		
		return  MathUtil.adjSpeed( -Robot.oi.rightJoystick.getY());
	}

	
}
