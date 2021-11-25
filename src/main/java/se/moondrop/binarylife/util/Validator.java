package se.moondrop.binarylife.util;

import se.moondrop.binarylife.training.Exercise;

public class Validator {


	/**
	 * Method for validating an exercise content
	 * @param exercise the object to be validated
	 * @return true if validation is successful, false otherwise
	 */
	public static boolean validateExercise(Exercise exercise) {

		if (exercise == null)
			return false;

		if (exercise.getTime() <= 0)
			return false;

		if (exercise.getActivity().getRemValue() <= 0.0)
			return false;

		return !exercise.getActivity().getName().isBlank();
	}

}
