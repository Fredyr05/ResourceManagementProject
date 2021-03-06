package project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import project.model.Resource;
import project.model.Block;
import project.model.Columns;
import project.model.Formula;
import project.service.FormulaService;
import project.service.ResourceService;
@CrossOrigin
@RestController
public class FormulaController {

   @Autowired
   private FormulaService formulaService;
   @Autowired
   private ResourceService resourceService;
   /*--Save the value in every filed in a Formula page to database--*/
   @PostMapping("/project/{projectid}/formula/blocks")
   public ResponseEntity<?> saveBlocks(@RequestBody List<Block> blocks){
	   formulaService.saveOrUpdateBlocks(blocks);
	   return ResponseEntity.ok().body("Blocks have been saved or updated");
   }
   /*--Get all the values that should be shown in the Formula page--*/
   @GetMapping("/project/{projectid}/formula/blocks")
   public ResponseEntity<List<Block>> getBlocks(@PathVariable("projectid") long projectid){
	   return ResponseEntity.ok().body(formulaService.getBlocks(projectid));
   }
   /*--Get all the columns that should be shown in the Formula page/Template page--*/
   @GetMapping({"/project/{projectid}/formula/columns","/project/{projectid}/template/columns"})
   public ResponseEntity<List<Columns>> getColumns(@PathVariable("projectid") long projectid){
	   return ResponseEntity.ok().body(formulaService.getColumnsByProject(projectid));
   }
   /*--Get the formula information for the columns which are formulas--*/
   @GetMapping({"/project/{projectid}/formula/formulas","/project/{projectid}/template/formulas"})
   public ResponseEntity<List<Formula>> getFormulas(@PathVariable("projectid") long projectid){
	   return ResponseEntity.ok().body(formulaService.getFormulas(projectid));
   }
   /*--Get the resources for the selected project in Formula page--*/
   @GetMapping("/project/{projectid}/formula/resources")
   public ResponseEntity<List<Resource>> getResources(@PathVariable("projectid") long projectid){
	   return ResponseEntity.ok().body(resourceService.getResourcesInProject(projectid));
   }
   /*--Save the information of user defined columns in the template page--*/
   @PostMapping("/project/{projectid}/template/columns")
   public ResponseEntity<?> saveColumns(@PathVariable("projectid") long projectid,@RequestBody List<Columns> columns){
	   formulaService.saveOrUpdateColumns(projectid,columns);
	   return ResponseEntity.ok().body("Columns has been saved or updated");
   }
   /*--Save the formula information of formula columns--*/
   @PostMapping("project/{projectid}/template/formulas")
   public ResponseEntity<?> saveFormulas(@RequestBody List<Formula> formulas){
	   formulaService.saveOrUpdateFormulas(formulas);
	   return ResponseEntity.ok().body("Formulas has been saved or updated");
   }
   
}
