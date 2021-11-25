package se.moondrop.binarylife.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;

public class ExerciseRepositoryTest {

    @Autowired
    private ExerciseRepository repository;

    @Test
    @Description("testStoringOfExercise")
    void testStorageOfExercise(){
//        repository.storeExercise("Walking", "", 0, 10);
    }

    @Test
    @Description("testRetrievalAfterStorageOfExercise")
    void testRetrievalAfterStorageOfExercise(){

    }

    @Test
    @Description("testQueryAgainstExerciseRepo-success - Should return found exercise")
    void testQueryAgainstExerciseRepo_success(){

    }

    @Test
    @Description("testQueryAgainstExerciseRepo-failure - Should return null")
    void testQueryAgainstExerciseRepo_failure(){

    }
}
