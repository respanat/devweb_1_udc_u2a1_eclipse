package Models.Services;

import Models.Entities.Usuario;
import Models.Repositories.UsuarioRepository;
import java.util.List;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository = new UsuarioRepository();

    public void agregarUsuario(Usuario usuario) {
        usuarioRepository.agregar(usuario);
        System.out.println("UsuarioService: Solicitud para agregar usuario procesada.");
    }

    public Usuario obtenerUsuarioPorId(int id) {
        Usuario usuario = usuarioRepository.buscarPorId(id);
        System.out.println("UsuarioService: Solicitud para obtener usuario por ID procesada.");
        return usuario;
    }

    public List<Usuario> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.listarTodos();
        System.out.println("UsuarioService: Solicitud para listar todos los usuarios procesada.");
        return usuarios;
    }

    public Usuario autenticarUsuario(String username, String password) {
        List<Usuario> usuarios = usuarioRepository.listarTodos(); // Por ahora, una implementación simple
        for (Usuario usuario : usuarios) {
            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                System.out.println("UsuarioService: Usuario autenticado.");
                return usuario;
            }
        }
        System.out.println("UsuarioService: Fallo en la autenticación.");
        return null;
    }

    // Implementar lógica para listar personalizada, etc.
}