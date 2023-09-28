package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import model.Project;

public class ProjectController {

    public void save(Project project) {

        String sql = "INSERT INTO Project("
                + "name,"
                + "description,"
                + "creationAt,"
                + "updateAt"
                + ")VALUES (?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreationAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdateAt().getTime()));
            statement.execute();

        } catch (SQLException exception) {

            throw new RuntimeException("ERRO AO SALVAR  O PROJETO: ", exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void removeById(int idProject) {
    String sql = "DELETE FROM Project WHERE id = ?";
    Connection connection = null;
    PreparedStatement statement = null;

    try {
        connection = ConnectionFactory.getConnection();
        statement = connection.prepareStatement(sql);
        statement.setInt(1, idProject);
        statement.execute();
    } catch (Exception exception) {
        // Capturamos a exceção original e lançamos uma RuntimeException com mensagem personalizada.
        throw new RuntimeException("ERRO AO DELETAR O PROJETO: " + exception.getMessage(), exception);
    } finally {
        ConnectionFactory.closeConnection(connection, statement);
    }
}


    public void update(Project project) {

        String sql = "UPDATE Project SET "
                + "name = ?,"
                + "description = ?,"
                + "creationAt = ?"
                + "updatedAt = ?"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new java.sql.Date(project.getCreationAt().getTime()));
            statement.setDate(4, new java.sql.Date(project.getUpdateAt().getTime()));
            statement.setInt(5, project.getId());
            statement.execute();

        } catch (Exception exception) {
            throw new RuntimeException(" ERRO AO ATUALIZAR O PROJETO: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public List<Project> getAll(int idProject) {
        String sql = "SELECT * FROM Project WHERE idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();
            resultSet.first();

            while (resultSet.next()) {
                Project projectsList = new Project();
                projectsList.setId(resultSet.getInt("id"));
                projectsList.setName(resultSet.getString("name"));
                projectsList.setDescription(resultSet.getString("description"));
                projectsList.setCreationAt(resultSet.getDate("creationAt"));
                projectsList.setUpdateAt(resultSet.getDate("updateAt"));
                projects.add(projectsList);
            }

        } catch (Exception exception) {
            throw new RuntimeException("ERRO AO LISTAR DADO DA TABELA PROJETOS: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return projects;
    }

    public List<Project> getAll() {
        String sql = "SELECT * FROM Project;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<Project>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project projectsList = new Project();
                projectsList.setId(resultSet.getInt("id"));
                projectsList.setName(resultSet.getString("name"));
                projectsList.setDescription(resultSet.getString("description"));
                projectsList.setCreationAt(resultSet.getDate("creationAt"));
                projectsList.setUpdateAt(resultSet.getDate("updateAt"));
                projects.add(projectsList);
            }

        } catch (Exception exception) {
            throw new RuntimeException("ERRO AO LISTAR DADO DA TABELA PROJETOS: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return projects;
    }

}
