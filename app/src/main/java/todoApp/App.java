
package todoApp;

import controller.ProjectController;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

public class App {

    public static void main(String[] args) {
        
        ProjectController projectController1 = new ProjectController();

        Project project1 = new Project();
        project1.setName("Primeiro projeto criado");
        Task project1Tesk = new Task();
        project1Tesk.setDescription("project1Test");
        
        projectController1.save(project1);

        Project project2 = new Project();
        project2.setName("Segundo projeto criado");
        Task project2Tesk = new Task();
        project2Tesk.setDescription("project2Test");
        
        List<Project> projectList = new ArrayList();
        projectList.size();
        System.out.println("PROJECT LISTS:  " + projectList.size());
    }
}
