package Models.Repositories;

import Models.Entities.Computador;
import Libs.orm.ormconfig;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ComputadorRepository {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ormconfig.DB_URL, ormconfig.DB_USER, ormconfig.DB_PASSWORD);
    }

    public void agregar(Computador computador) {
        String sql = "INSERT INTO Computadores (marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, MarcaMonitor, pulgadas, precio, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, computador.getMarca());
            pstmt.setString(2, computador.getCategoria());
            pstmt.setString(3, computador.getMarcaCpu());
            pstmt.setString(4, computador.getVelocidadCpu());
            pstmt.setString(5, computador.getTecnologiaRam());
            pstmt.setString(6, computador.getCapacidadRam());
            pstmt.setString(7, computador.getTecnologiaDisco());
            pstmt.setString(8, computador.getCapacidadDisco());
            pstmt.setInt(9, computador.getNumPuertosUSB());
            pstmt.setInt(10, computador.getNumPuertosHDMI());
            pstmt.setString(11, computador.getMarcaMonitor());
            pstmt.setDouble(12, computador.getPulgadas());
            pstmt.setDouble(13, computador.getPrecio());
            pstmt.setInt(14, computador.getUsuarioId());
            pstmt.executeUpdate();
            System.out.println("ComputadorRepository: Computador agregado a la base de datos.");
        } catch (SQLException e) {
            System.err.println("ComputadorRepository: Error al agregar computador: " + e.getMessage());
        }
    }

    public Computador buscarPorId(int id) {
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, MarcaMonitor, pulgadas, precio, usuario_id FROM Computadores WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Computador computador = new Computador();
                computador.setId(rs.getInt("id"));
                computador.setMarca(rs.getString("marca"));
                computador.setCategoria(rs.getString("categoria"));
                computador.setMarcaCpu(rs.getString("marcaCpu"));
                computador.setVelocidadCpu(rs.getString("velocidadCpu"));
                computador.setTecnologiaRam(rs.getString("tecnologiaRam"));
                computador.setCapacidadRam(rs.getString("capacidadRam"));
                computador.setTecnologiaDisco(rs.getString("tecnologiaDisco"));
                computador.setCapacidadDisco(rs.getString("capacidadDisco"));
                computador.setNumPuertosUSB(rs.getInt("numPuertosUSB"));
                computador.setNumPuertosHDMI(rs.getInt("numPuertosHDMI"));
                computador.setMarcaMonitor(rs.getString("MarcaMonitor"));
                computador.setPulgadas(rs.getDouble("pulgadas"));
                computador.setPrecio(rs.getDouble("precio"));
                computador.setUsuarioId(rs.getInt("usuario_id"));
                System.out.println("ComputadorRepository: Computador encontrado con ID: " + id);
                return computador;
            } else {
                System.out.println("ComputadorRepository: No se encontró computador con ID: " + id);
                return null;
            }
        } catch (SQLException e) {
            System.err.println("ComputadorRepository: Error al buscar computador por ID: " + e.getMessage());
            return null;
        }
    }

    public List<Computador> listarTodos(int usuarioId) {
        List<Computador> computadores = new ArrayList<>();
        String sql = "SELECT id, marca, categoria, marcaCpu, velocidadCpu, tecnologiaRam, capacidadRam, tecnologiaDisco, capacidadDisco, numPuertosUSB, numPuertosHDMI, MarcaMonitor, pulgadas, precio, usuario_id FROM Computadores WHERE usuario_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Computador computador = new Computador();
                computador.setId(rs.getInt("id"));
                computador.setMarca(rs.getString("marca"));
                computador.setCategoria(rs.getString("categoria"));
                computador.setMarcaCpu(rs.getString("marcaCpu"));
                computador.setVelocidadCpu(rs.getString("velocidadCpu"));
                computador.setTecnologiaRam(rs.getString("tecnologiaRam"));
                computador.setCapacidadRam(rs.getString("capacidadRam"));
                computador.setTecnologiaDisco(rs.getString("tecnologiaDisco"));
                computador.setCapacidadDisco(rs.getString("capacidadDisco"));
                computador.setNumPuertosUSB(rs.getInt("numPuertosUSB"));
                computador.setNumPuertosHDMI(rs.getInt("numPuertosHDMI"));
                computador.setMarcaMonitor(rs.getString("MarcaMonitor"));
                computador.setPulgadas(rs.getDouble("pulgadas"));
                computador.setPrecio(rs.getDouble("precio"));
                computador.setUsuarioId(rs.getInt("usuario_id"));
                computadores.add(computador);
            }
            System.out.println("ComputadorRepository: Listando todos los computadores del usuario con ID: " + usuarioId);
            return computadores;
        } catch (SQLException e) {
            System.err.println("ComputadorRepository: Error al listar computadores: " + e.getMessage());
            return null;
        }
    }

    // Implementar métodos para buscar por marca, categoría, listar personalizada, etc.
}