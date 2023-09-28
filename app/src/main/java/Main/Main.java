
package Main;
import model.Project;
import controller.ProjectController;
import java.util.List;

public class Main {
    
    public static void main(String[] args){
    ProjectController projectController = new ProjectController();
    Project project = new Project();
//    project.setId(7);
//    project.setName("Atualizado");
//    project.setDescription("Atualizado");
//    projectController.save(project);
//    
        List<Project> projects = projectController.getAll();
        System.out.println("TOTAL DE PROJETOS: " + projects.size());
        projectController.removeById(10);
    
    }
    
}
