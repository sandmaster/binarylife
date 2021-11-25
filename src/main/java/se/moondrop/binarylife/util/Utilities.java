package se.moondrop.binarylife.util;

import se.moondrop.binarylife.player.Player;
import se.moondrop.binarylife.training.Exercise;

public class Utilities {

	public double calculateCalories(Exercise exercise, Player player) {

		return Validator.validateExercise(exercise)
				? exercise.getTime() * (exercise.getActivity().getRemValue() * 3.5 * player.getWeight()) / 200
				: 0.0;
	}

}
