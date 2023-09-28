package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionFactory;
import model.Task;

public class TaskController {

    public void save(Task task) {
        String sql = "INSERT INTO Task("
                + "idProject,"
                + " name,"
                + " description,"
                + " completed,"
                + " notes,"
                + " deadline,"
                + " creationAt,"
                + " updateAt"
                + ")VALUES (?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadLine().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreationAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdateAt().getTime()));
            statement.execute();

        } catch (Exception exception) {
            throw new RuntimeException(" ERRO AO SALVAR A TAREFA: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);

        }
    }

    public void removedById(int taskId) throws SQLException {
        String sql = "DELETE FROM Task WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (SQLException exception) {
            throw new SQLException("ERRO AO DELETAR A TAREFA: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE Task SET "
                + "idProject = ?,"
                + "name = ?,"
                + "description = ?,"
                + "completed = ?,"
                + "notes = ?,"
                + "deadline = ?"
                + "creationAt = ?"
                + "updatedAt = ?"
                + "WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.getIsCompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new java.sql.Date(task.getDeadLine().getTime()));
            statement.setDate(7, new java.sql.Date(task.getCreationAt().getTime()));
            statement.setDate(8, new java.sql.Date(task.getUpdateAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();

        } catch (Exception exception) {
            throw new RuntimeException(" ERRO AO ATUALIZAR A TAREFA: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public List<Task> getAll(int idProject) {
        String sql = "SELECT * FROM Task WHERE idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();

            resultSet.first();

            while (resultSet.next()) {
                Task taskList = new Task();
                taskList.setId(resultSet.getInt("id"));
                taskList.setIdProject(resultSet.getInt("idProject"));
                taskList.setName(resultSet.getString("name"));
                taskList.setDescription(resultSet.getString("description"));
                taskList.setNotes(resultSet.getString("notes"));
                taskList.setIsCompleted(resultSet.getBoolean("completed"));
                taskList.setDeadLine(resultSet.getDate("deadline"));
                taskList.setCreationAt(resultSet.getDate("creationAt"));
                taskList.setUpdateAt(resultSet.getDate("updateAt"));

                tasks.add(taskList);
            }
        } catch (Exception exception) {
            throw new RuntimeException("ERRO AO LISTAR DADO DA TABELA: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return tasks;
    }

    public List<Task> getAll() {
        String sql = "SELECT * FROM Task;";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<Task>();

        try {

            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task taskList = new Task();
                taskList.setId(resultSet.getInt("id"));
                taskList.setIdProject(resultSet.getInt("idProject"));
                taskList.setName(resultSet.getString("name"));
                taskList.setDescription(resultSet.getString("description"));
                taskList.setNotes(resultSet.getString("notes"));
                taskList.setIsCompleted(resultSet.getBoolean("completed"));
                taskList.setDeadLine(resultSet.getDate("deadline"));
                taskList.setCreationAt(resultSet.getDate("creationAt"));
                taskList.setUpdateAt(resultSet.getDate("updateAt"));
                tasks.add(taskList);
            }

        } catch (Exception exception) {
            throw new RuntimeException("ERRO AO LISTAR DADOS DA TABELA TASKS: " + exception.getMessage(), exception);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return tasks;
    }
}
