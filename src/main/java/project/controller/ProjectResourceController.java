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

import project.model.Project;
import project.model.Resource;
import project.service.ProjectService;
import project.service.ResourceService;

@RestController
public class ProjectResourceController {

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ResourceService resourceService;
	
	/*---Add resource to project---*/
	@PostMapping("/project/{projId}/resource/{resId}")
	public ResponseEntity<?> addResourceToProject(@PathVariable("projId") long projId, @PathVariable("resId") long resId){
		long id = resourceService.addToProject(projId, resId);
		return ResponseEntity.ok().body("Added resource to project: " + id);
	}
	
	/*---Add new resource to project---*/
	@PostMapping("/project/{projId}/resource")
	public ResponseEntity<?> addNewResourceToProject(@PathVariable("projId") long projId, @RequestBody Resource resource){
		long id = resourceService.saveAddedProject(projId, resource);
		return ResponseEntity.ok().body("Added resource to project: " + id);
	}
	
	/*---Add new Resource---*/
	@PostMapping("/resource")
	public ResponseEntity<?> saveResource(@RequestBody Resource resource) {
		long resId = resourceService.save(resource);
		return ResponseEntity.ok().body("New Resource has been saved with ID:" + resId);
	}

	/*---Add new Project---*/
	@PostMapping("/project")
	public ResponseEntity<?> saveProject(@RequestBody Project project) {
		long projId = projectService.save(project);
		return ResponseEntity.ok().body("New Project has been saved with ID:" + projId);
	}

	/*---Get a resource by id---*/
	@GetMapping("/resource/{id}")
	public ResponseEntity<Resource> getResource(@PathVariable("id") long id) {
		Resource resource = resourceService.get(id);
		return ResponseEntity.ok().body(resource);
	}
	
	/*---Get a project by id---*/
	@GetMapping("/project/{id}")
	public ResponseEntity<Project> getProject(@PathVariable("id") long id) {
		Project project = projectService.get(id);
		return ResponseEntity.ok().body(project);
	}

	/*---get all projects---*/
	@GetMapping("/resource")
	public ResponseEntity<List<Resource>> listResources() {
		List<Resource> resources = resourceService.list();
		return ResponseEntity.ok().body(resources);
	}
	
	/*---get all projects---*/
	@GetMapping("/project")
	public ResponseEntity<List<Project>> listProjects() {
		List<Project> projects = projectService.list();
		return ResponseEntity.ok().body(projects);
	}

	/*---Update a resource by id---*/
	@PutMapping("/resource/{id}")
	public ResponseEntity<?> updateResource(@PathVariable("id") long id, @RequestBody Resource resource) {
		resourceService.update(id, resource);
		return ResponseEntity.ok().body("Resource has been updated successfully.");
	}
	
	/*---Update a project by id---*/
	@PutMapping("/project/{id}")
	public ResponseEntity<?> updateProject(@PathVariable("id") long id, @RequestBody Project project) {
		projectService.update(id, project);
		return ResponseEntity.ok().body("Project has been updated successfully.");
	}

	/*---Delete a resource by id---*/
	@DeleteMapping("/resource/{id}")
	public ResponseEntity<?> deleteResource(@PathVariable("id") long id) {
		projectService.delete(id);
		return ResponseEntity.ok().body("Project has been deleted successfully.");
	}
	
	/*---Delete a project by id---*/
	@DeleteMapping("/project/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable("id") long id) {
		projectService.delete(id);
		return ResponseEntity.ok().body("Project has been deleted successfully.");
	}

}
