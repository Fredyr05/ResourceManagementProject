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
	   return ResponseEntity.ok().body("Blocks have been saved or updated");
   }
   @GetMapping("Formula/Blocks/{projectid}")
   public ResponseEntity<List<Block>> getBlocks(long projectid){
	   return ResponseEntity.ok().body(formulaService.getBlocks(projectid));
   }
   @GetMapping("Formula/Columns/{projectid}")
   public ResponseEntity<List<Columns>> getColumns(long projectid){
	   return ResponseEntity.ok().body(formulaService.getColumnsByProject(projectid));
   }
   @PostMapping("Template/Columns")
   public ResponseEntity<?> saveColumns(List<Columns> columns){
	   formulaService.saveOrUpdateColumns(columns);
	   return ResponseEntity.ok().body("Columns has been saved or updated");
   }

}