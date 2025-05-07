package Models.Repositories;

import Models.Entities.Usuario;
import Libs.orm.ormconfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ormconfig.DB_URL, ormconfig.DB_USER, ormconfig.DB_PASSWORD);
    }

    public void agregar(Usuario usuario) {
        String sql = "INSERT INTO Usuario (username, password, nombre, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, usuario.getUsername());
            pstmt.setString(2, usuario.getPassword());
            pstmt.setString(3, usuario.getNombre());
            pstmt.setString(4, usuario.getEmail());
            pstmt.executeUpdate();
            System.out.println("UsuarioRepository: Usuario agregado a la base de datos.");
        } catch (SQLException e) {
            System.err.println("UsuarioRepository: Error al agregar usuario: " + e.getMessage());
        }
    }

    public Usuario buscarPorId(int id) {
        String sql = "SELECT id, username, password, nombre, email FROM Usuario WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                System.out.println("UsuarioRepository: Usuario encontrado con ID: " + id);
                return usuario;
            } else {
                System.out.println("UsuarioRepository: No se encontró usuario con ID: " + id);
                return null;
            }
        } catch (SQLException e) {
            System.err.println("UsuarioRepository: Error al buscar usuario por ID: " + e.getMessage());
            return null;
        }
    }

    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT id, username, password, nombre, email FROM Usuario";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }
            System.out.println("UsuarioRepository: Listando todos los usuarios.");
            return usuarios;
        } catch (SQLException e) {
            System.err.println("UsuarioRepository: Error al listar usuarios: " + e.getMessage());
            return null;
        }
    }

    // Implementar métodos para buscar por username, email, listar personalizada, etc.
}