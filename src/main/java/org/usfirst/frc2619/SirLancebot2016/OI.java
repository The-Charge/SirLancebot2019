// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc2619.SirLancebot2016;

import org.usfirst.frc2619.SirLancebot2016.commands.*;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	
	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton shiftHighButtonLeft;
    public JoystickButton lightsOn;
    public JoystickButton lightsOff;
    public Joystick leftJoystick;
    public JoystickButton shiftLowButtonRight;
    public Joystick rightJoystick;
    public JoystickButton lowBarOffButton;
    public JoystickButton lowBarOnButton;
    public JoystickButton prepShooterOn;
    public JoystickButton prepShooterOff;
    public JoystickButton fireButton;
    public JoystickButton collectorOnButton;
    public JoystickButton collectorOffButton;
    public JoystickButton prepHighGoalButton;
    public JoystickButton highGoalResetButton;
    public JoystickButton prepLowGoalButton;
    public JoystickButton lowGoalResetButton;
    public JoystickButton wristUpButton;
    public JoystickButton armsUpButton;
    public JoystickButton shooterUpButton;
    public JoystickButton wristDownButton;
    public JoystickButton armsDownButton;
    public JoystickButton shooterDownButton;
    public Joystick buttonBox;
    public JoystickButton fullSpeedButton;
    public JoystickButton halfSpeedButton;
    public JoystickButton quarterSpeedButton;
    public Joystick xbox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public SendableChooser driveMode;
    public SendableChooser<Integer> driveControl;
    public SendableChooser driveSpeed;
	public SendableChooser loopMode;
	public SendableChooser autonCommand; // this one is for testing the sendable
											// chooser
	public SendableChooser autoposition;
	public SendableChooser autoDefenseAgainst;

	public OI() {
        
        driveControl = new SendableChooser<Integer>();
		driveControl.addDefault("Traditional", (Integer) (3));
        driveControl.addObject("Xbox Control", (Integer) (1));
        SmartDashboard.putData("Drive Control", driveControl);

      
        xbox = new Joystick(0);


        if (driveControl.getSelected().equals(1))
        {
            
            System.out.println("XBOX CONTROLLER SELECTED");
            int direction = xbox.getPOV(0);
            
            if (direction != -1)
            {
                if (direction == 0)
                {
                   
                }

                if (direction == 90)
                {
                  if (Robot.shooterPivot.shooterUp)
                        new LowerShooter();
                    else new LiftShooter();
                } 

                if (direction == 180)
                {
                   if (Robot.wrist.wristbool)
                        new WristDown();
                    else new WristUp();
                }

                if (direction == 270)
                {
                   if(Robot.arms.status)
                        new LowerArms();
                    else new LiftArms();
                }

                
            }


            lowGoalResetButton = new JoystickButton(xbox, 1);
            lowGoalResetButton.whenReleased(new DefaultPositionCG());
            prepLowGoalButton = new JoystickButton(xbox, 1);
            prepLowGoalButton.whenPressed(new PrepLowGoalCG());

            highGoalResetButton = new JoystickButton(xbox, 2);
            highGoalResetButton.whenReleased(new DefaultPositionCG());
            prepHighGoalButton = new JoystickButton(xbox, 2);
            prepHighGoalButton.whenPressed(new PrepHighGoalCG());

            collectorOffButton = new JoystickButton(xbox, 3);
            collectorOffButton.whenReleased(new CollectorOffCG());
            collectorOnButton = new JoystickButton(xbox, 3);
            collectorOnButton.whenPressed(new CollectorOnCG());
         
            fireButton = new JoystickButton(xbox, 8);
            fireButton.whenPressed(new Fire());

            prepShooterOff = new JoystickButton(xbox, 4);
            prepShooterOff.whenReleased(new StopShooterCommand());
            prepShooterOn = new JoystickButton(xbox, 4);
            prepShooterOn.whenPressed(new PrepShooter());
         
 
            shiftLowButtonRight = new JoystickButton(xbox, 5);
            shiftLowButtonRight.whenPressed(new ShiftLow());
            
            shiftHighButtonLeft = new JoystickButton(xbox, 6);
            shiftHighButtonLeft.whenPressed(new ShiftHigh());

        }
        else
        {

        buttonBox = new Joystick(2);
        
        shooterDownButton = new JoystickButton(buttonBox, 10);
        shooterDownButton.whenPressed(new LowerShooter());
        armsDownButton = new JoystickButton(buttonBox, 8);
        armsDownButton.whenPressed(new LowerArms());
        wristDownButton = new JoystickButton(buttonBox, 12);
        wristDownButton.whenPressed(new WristDown());
        shooterUpButton = new JoystickButton(buttonBox, 9);
        shooterUpButton.whenPressed(new LiftShooter());
        armsUpButton = new JoystickButton(buttonBox, 7);
        armsUpButton.whenPressed(new LiftArms());
        wristUpButton = new JoystickButton(buttonBox, 11);
        wristUpButton.whenPressed(new WristUp());
        lowGoalResetButton = new JoystickButton(buttonBox, 3);
        lowGoalResetButton.whenReleased(new DefaultPositionCG());
        prepLowGoalButton = new JoystickButton(buttonBox, 3);
        prepLowGoalButton.whenPressed(new PrepLowGoalCG());
        highGoalResetButton = new JoystickButton(buttonBox, 5);
        highGoalResetButton.whenReleased(new DefaultPositionCG());
        prepHighGoalButton = new JoystickButton(buttonBox, 5);
        prepHighGoalButton.whenPressed(new PrepHighGoalCG());
        collectorOffButton = new JoystickButton(buttonBox, 2);
        collectorOffButton.whenReleased(new CollectorOffCG());
        collectorOnButton = new JoystickButton(buttonBox, 2);
        collectorOnButton.whenPressed(new CollectorOnCG());
        fireButton = new JoystickButton(buttonBox, 1);
        fireButton.whenPressed(new Fire());
        prepShooterOff = new JoystickButton(buttonBox, 6);
        prepShooterOff.whenReleased(new StopShooterCommand());
        prepShooterOn = new JoystickButton(buttonBox, 6);
        prepShooterOn.whenPressed(new PrepShooter());
        //lowBarOnButton = new JoystickButton(buttonBox, 4);
        //lowBarOnButton.whenPressed(new LowBarOn());
        //lowBarOffButton = new JoystickButton(buttonBox, 4);
        //lowBarOffButton.whenReleased(new LowBarOff());
        rightJoystick = new Joystick(1);
        
        shiftLowButtonRight = new JoystickButton(rightJoystick, 4);
        shiftLowButtonRight.whenPressed(new ShiftLow());
        leftJoystick = new Joystick(0);


        fullSpeedButton = new JoystickButton(rightJoystick, 8);
        fullSpeedButton.whenPressed(new FullSpeed());
        halfSpeedButton = new JoystickButton(rightJoystick, 10);
        halfSpeedButton.whenPressed(new HalfSpeed());
        quarterSpeedButton = new JoystickButton(rightJoystick, 12);
        quarterSpeedButton.whenPressed(new QuarterSpeed());

        
        //lightsOff = new JoystickButton(leftJoystick, 3);
        //lightsOff.whenPressed(new VisionLightsOff());
        //lightsOn = new JoystickButton(leftJoystick, 5);
        //lightsOn.whenPressed(new VisionLightsOn());
        shiftHighButtonLeft = new JoystickButton(leftJoystick, 4);
        shiftHighButtonLeft.whenPressed(new ShiftHigh());
        }

        // SmartDashboard Buttons
        //SmartDashboard.putData("CameraDebug", new CameraDebug());
        //SmartDashboard.putData("TurnNDegreesAbsolute: 0", new TurnNDegreesAbsolute(0));
        //SmartDashboard.putData("TurnSDDegrees", new TurnSDDegrees());
        //SmartDashboard.putData("VisionLightsOn", new VisionLightsOn());
        //SmartDashboard.putData("VisionLightsOff", new VisionLightsOff());
        //SmartDashboard.putData("LowBarOff", new LowBarOff());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		driveMode = new SendableChooser();
		driveMode.addDefault("TankDrive", "tank");
		driveMode.addObject("ArcadeDrive", "arcade");
		driveMode.addObject("ClaytonDrive", "clayton");

        SmartDashboard.putData("Drive Mode", driveMode);
        
        driveSpeed = new SendableChooser();
        driveSpeed.addDefault("FullSpeed", 1);
        driveSpeed.addObject("HalfSpeed", 0.5);
        driveSpeed.addObject("QuaterSpeed", 0.25);

        SmartDashboard.putData("Drive Speed", driveSpeed);


	}

    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }

    public Joystick getButtonBox() {
        return buttonBox;
    }

    public int getDpad()
    {
        if (driveControl.getSelected().equals(1))
        {
            //xbox = new Joystick (0);

            int direction = xbox.getPOV(0);
            
           return direction;
        }
        else return -2;
    }


}
