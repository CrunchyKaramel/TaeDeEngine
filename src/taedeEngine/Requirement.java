package taedeEngine;

/**
 * This class signalizes that a certain class in a certain state has to be available for an event to be available.
 * When writing a child of a class, you need to add a fitting class
 * @author Twentyone
 *
 */
public abstract class Requirement {
	private RequirementType type;
	
	//an initialized child class will have the requirement needed here
	/*
	/**
	 * This class is non-functional and only exists to show how the requirement check should be constructed.
	 * @param checkedClass the class to be checked
	 * @param value the different value the checked class should have
	 * @return true if all requirements are met, otherwise false
	 *
	private boolean checkRequirementExample(Object checkedClass, Object[] value) {
		//non-functional demonstrational class
		return false; //this part is only to complete the non-functional class,
		              //the actual class should give the boolean value that is specified
	}
	*/
}
