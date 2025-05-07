package Models.Services;

import Models.Entities.Computador;
import Models.Repositories.ComputadorRepository;
import java.util.List;

public class ComputadorService {
    private final ComputadorRepository computadorRepository = new ComputadorRepository();

    public void agregarComputador(Computador computador) {
        computadorRepository.agregar(computador);
        System.out.println("ComputadorService: Solicitud para agregar computador procesada.");
    }

    public Computador obtenerComputadorPorId(int id) {
        Computador computador = computadorRepository.buscarPorId(id);
        System.out.println("ComputadorService: Solicitud para obtener computador por ID procesada.");
        return computador;
    }

    public List<Computador> listarTodosComputadores(int usuarioId) {
        List<Computador> computadores = computadorRepository.listarTodos(usuarioId);
        System.out.println("ComputadorService: Solicitud para listar todos los computadores del usuario procesada.");
        return computadores;
    }

    // Implementar lógica para listar personalizada, etc.
}