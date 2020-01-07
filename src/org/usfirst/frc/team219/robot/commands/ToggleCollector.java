package org.usfirst.frc.team219.robot.commands;

import org.usfirst.frc.team219.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This command toggles the ball collector.
 */
public class ToggleCollector extends Command 
{
	private double setSpeed;
	
	public ToggleCollector() 
	{
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.harvester);
	}

	// Called just before this Command runs the first time
	protected void initialize() 
	{
		Robot.harvester.startRoller(.85);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() 
	{
		Robot.harvester.startRoller(.85);

		//Robot.harvester.startRoller(setSpeed);
		//Robot.harvester.collectorMotor.set(ControlMode.PercentOutput,-.85);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() 
	{
		return false;
	}

	// Called once after isFinished returns true
	protected void end() 
	{
		Robot.harvester.stopRoller();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted()
	{
		end();
	}
}
