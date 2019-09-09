package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import project.model.Formula;
import project.model.Block;
import project.model.Columns;
import project.service.FormulaService;

@RestController
public class FormulaController {

   @Autowired
   private FormulaService formulaService;
   @PostMapping("Formula/Blocks")
   public ResponseEntity<?> saveBlocks(@RequestBody List<Block> blocks){
	   formulaService.saveOrUpdateBlocks(blocks);
	   return ResponseEntity.ok().body("New Users has been saved");
   }
   @GetMapping("Formula/Blocks/{projectid}")
   public ResponseEntity<List<Block>> getBlocks(long projectid){
	   return ResponseEntity.ok().body(formulaService.getBlocks(projectid));
   }
   @GetMapping("Formula/Columns/{projectid}")
   public ResponseEntity<List<Columns>> getColumns(long projectid){
	   return ResponseEntity.ok().body(formulaService.getColumnsByProject(projectid));
   }

   /*---Add new formula---*/
//   @PostMapping("/formula")
//   public ResponseEntity<?> save(@RequestBody List<Formula> formulas) {
//      long id = formulaService.save(formula);
//      return ResponseEntity.ok().body("New Formula has been saved with ID:" + id);
//   }

//   /*---Get a formula by id---*/
//   @GetMapping("/formula/{id}")
//   public ResponseEntity<Formula> get(@PathVariable("id") long id) {
//      Formula formula = formulaService.get(id);
//      return ResponseEntity.ok().body(formula);
//   }
//
//   /*---get all formulas---*/
//   @GetMapping("/formula")
//   public ResponseEntity<List<Formula>> list() {
//      List<Formula> formulas = formulaService.list();
//      return ResponseEntity.ok().body(formulas);
//   }
//
//   /*---Update a formula by id---*/
//   @PutMapping("/formula/{id}")
//   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Formula formula) {
//      formulaService.update(id, formula);
//      return ResponseEntity.ok().body("Formula has been updated successfully.");
//   }
//
//   /*---Delete a formula by id---*/
//   @DeleteMapping("/formula/{id}")
//   public ResponseEntity<?> delete(@PathVariable("id") long id) {
//      formulaService.delete(id);
//      return ResponseEntity.ok().body("Formula has been deleted successfully.");
//   }
}