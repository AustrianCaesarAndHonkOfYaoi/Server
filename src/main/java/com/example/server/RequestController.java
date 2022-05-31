package com.example.server;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

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

  @GetMapping("/getAllInfos")
  public ResponseEntity<List<UserNation>> getTopScores() {
    return ResponseEntity.ok(repo.findAll());
  }

  @GetMapping("/getAlloy/{id}/{name}")
  public ResponseEntity<Integer> getAlloy(@PathVariable int id, @PathVariable String name) {
    UserNation nation = getNation(id, name);

    int alloy = nation.getHighestAmountAlloy();

    return ResponseEntity.ok(alloy);
  }

  @GetMapping("/getFood/{id}/{name}")
  public ResponseEntity<Integer> getFood(@PathVariable int id, @PathVariable String name) {
    UserNation nation = getNation(id, name);

    int food = nation.getHighestAmountFood();

    return ResponseEntity.ok(food);
  }

  @GetMapping("/getYaoi/{id}/{name}")
  public ResponseEntity<Integer> getYaoi(@PathVariable int id, @PathVariable String name) {
    UserNation nation = getNation(id, name);

    int yaoi = nation.getHighestAmountYaoi();

    return ResponseEntity.ok(yaoi);
  }

  @GetMapping("/getMineral/{id}/{name}")
  public ResponseEntity<Integer> getMineral(@PathVariable int id, @PathVariable String name) {
    UserNation nation = getNation(id, name);

    int mineral = nation.getHighestAmountMineral();

    return ResponseEntity.ok(mineral);
  }

  @GetMapping("/getEnergy/{id}/{name}")
  public ResponseEntity<Integer> getEnergy(@PathVariable int id, @PathVariable String name) {
    UserNation nation = getNation(id, name);

    int energy = nation.getHighestAmountEnergy();

    return ResponseEntity.ok(energy);
  }

  @PostMapping("/setEnergy/{id}/{name}/{amount}")
  public ResponseEntity<Boolean> setEnergy(@PathVariable int id, @PathVariable String name,
      @PathVariable int amount) {

    UserNation nation = getNation(id, name);

    nation.setHighestAmountEnergy(amount);

    repo.save(nation);

    return ResponseEntity.ok(true);
  }


  @PostMapping("/setMineral/{id}/{name}/{amount}")
  public ResponseEntity<Boolean> setMineral(@PathVariable int id, @PathVariable String name,
      @PathVariable int amount) {

    UserNation nation = getNation(id, name);
    nation.setHighestAmountMineral(amount);
    repo.save(nation);

    return ResponseEntity.ok(true);
  }

  @PostMapping("/setAlloy/{id}/{name}/{amount}")
  public ResponseEntity<Boolean> setAlloy(@PathVariable int id, @PathVariable String name,
      @PathVariable int amount) {

    UserNation nation = getNation(id, name);
    nation.setHighestAmountAlloy(amount);
    repo.save(nation);

    return ResponseEntity.ok(true);
  }

  @PostMapping("/setYaoi/{id}/{name}/{amount}")
  public ResponseEntity<Boolean> setYaoi(@PathVariable int id, @PathVariable String name,
      @PathVariable int amount) {

    UserNation nation = getNation(id, name);
    nation.setHighestAmountYaoi(amount);
    repo.save(nation);

    return ResponseEntity.ok(true);
  }

  @PostMapping("/setFood/{id}/{name}/{amount}")
  public ResponseEntity<Boolean> setFood(@PathVariable int id, @PathVariable String name,
      @PathVariable int amount) {

    UserNation nation = getNation(id, name);
    nation.setHighestAmountFood(amount);
    repo.save(nation);

    return ResponseEntity.ok(true);
  }

  private UserNation getNation(Integer id, String name) {
    Optional<UserNation> nationOptional = repo.getById(id);
    UserNation nation;
    if (nationOptional.isEmpty()) {
      nation = new UserNation(id, name, STANDARD_VALUE, STANDARD_VALUE, STANDARD_VALUE,
          STANDARD_VALUE, STANDARD_VALUE);
      repo.save(nation);
    } else {
      nation = nationOptional.get();
    }

    return nation;
  }

}
