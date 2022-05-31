package com.example.server;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class RequestController {

    private final int STANDARD_VALUE = 12;
    /*  Wenns vorhanden ist, dann mach dies
        nationOptional.ifPresent(userNation -> userNation.setName("Something"));

        Zum Speichern immer zum Schluss
        repo.save(test);
    */
    private final UserNationRepository repo;

    @GetMapping("/getAlloy")
    public ResponseEntity<Integer> getAlloy(int id, String name) {
        UserNation nation = getNation(id, name);

        int alloy = nation.getHighestAmountAlloy();

        return ResponseEntity.ok(alloy);
    }

    @PostMapping("/setEnergy")
    public ResponseEntity<Boolean> setEnergy(Integer id, String name, int amount) {

        UserNation nation = getNation(id, name);

        nation.setHighestAmountEnergy(amount);

        return ResponseEntity.ok(true);
    }

    @PostMapping("/setMineral")
    public ResponseEntity<Boolean> setMineral(Integer id, String name, int amount) {

        UserNation nation = getNation(id, name);

        nation.setHighestAmountMineral(amount);

        return ResponseEntity.ok(true);
    }

    @PostMapping("/setAlloy")
    public ResponseEntity<Boolean> setAlloy(Integer id, String name, int amount) {

        UserNation nation = getNation(id, name);

        nation.setHighestAmountAlloy(amount);

        return ResponseEntity.ok(true);
    }

    @PostMapping("/setYaoi")
    public ResponseEntity<Boolean> setYaoi(Integer id, String name, int amount) {

        UserNation nation = getNation(id, name);

        nation.setHighestAmountYaoi(amount);

        return ResponseEntity.ok(true);
    }

    @PostMapping("/setFood")
    public ResponseEntity<Boolean> setFood(Integer id, String name, int amount) {

        UserNation nation = getNation(id, name);

        nation.setHighestAmountFood(amount);

        return ResponseEntity.ok(true);
    }

    private UserNation getNation(Integer id, String name) {
        Optional<UserNation> nationOptional = repo.getById(id);
        UserNation nation;
        if (nationOptional.isEmpty()) {
            nation = new UserNation(id, name, STANDARD_VALUE, STANDARD_VALUE, STANDARD_VALUE, STANDARD_VALUE, STANDARD_VALUE);
            repo.save(nation);
        } else {
            nation = nationOptional.get();
        }

        return nation;
    }

}
