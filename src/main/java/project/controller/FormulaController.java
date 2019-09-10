package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import project.model.Resource;
import project.model.Block;
import project.model.Columns;
import project.model.Formula;
import project.service.FormulaService;
import project.service.ResourceService;

@RestController
public class FormulaController {

   @Autowired
   private FormulaService formulaService;
   @Autowired
   private ResourceService resourceService;
   @PostMapping("Formula/{projectid}/Blocks")
   public ResponseEntity<?> saveBlocks(@RequestBody List<Block> blocks){
	   formulaService.saveOrUpdateBlocks(blocks);
	   return ResponseEntity.ok().body("Blocks have been saved or updated");
   }
   @GetMapping("Formula/{projectid}/Blocks")
   public ResponseEntity<List<Block>> getBlocks(long projectid){
	   return ResponseEntity.ok().body(formulaService.getBlocks(projectid));
   }
   @GetMapping({"Formula/{projectid}/Columns","Template/{projectid}/Columns"})
   public ResponseEntity<List<Columns>> getColumns(long projectid){
	   return ResponseEntity.ok().body(formulaService.getColumnsByProject(projectid));
   }
   @GetMapping({"Formula/{projectid}/Formula","Template/{projectid}/Formula"})
   public ResponseEntity<List<Formula>> getFormulas(long projectid){
	   return ResponseEntity.ok().body(formulaService.getFormulas(projectid));
   }
   @GetMapping("Formula/{projectid}/Resources")
   public ResponseEntity<List<Resource>> getResources(long projectid){
	   return ResponseEntity.ok().body(resourceService.getResourcesInProject(projectid));
   }
   @PostMapping("Template/{projectid}/Columns")
   public ResponseEntity<?> saveColumns(List<Columns> columns){
	   formulaService.saveOrUpdateColumns(columns);
	   return ResponseEntity.ok().body("Columns has been saved or updated");
   }
   @PostMapping("Template/{projectid}/Formulas")
   public ResponseEntity<?> saveFormulas(List<Formula> formulas){
	   formulaService.saveOrUpdateFormulas(formulas);
	   return ResponseEntity.ok().body("Formulas has been saved or updated");
   }
   
}
