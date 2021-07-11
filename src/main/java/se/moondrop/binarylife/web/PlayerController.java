package se.moondrop.binarylife.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import se.moondrop.binarylife.player.Player;

@Controller
public class PlayerController {

    @GetMapping(value = "/player")
    public ResponseEntity<String> getMethodName() {

        /**
         * This endpoint should fetch the current users player and desplay its values
         */
        Player temp = new Player("Robin", 32, 152);
        temp.init();

        String result = temp.toString();
        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
