package TestUnits.TestUsuario;

import Models.Entities.Usuario;
import Models.Services.UsuarioService;

public class TestUsuario {
    private static int contadorUsuarios = 1;
    private static final UsuarioService usuarioService = new UsuarioService();

    public static void main(String[] args) {
        testAgregarUsuario();
        testObtenerUsuarioPorId();
        testListarTodosUsuarios();
    }

    public static void testAgregarUsuario() {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername("usuario" + contadorUsuarios);
        nuevoUsuario.setPassword("clave" + contadorUsuarios);
        nuevoUsuario.setNombre("Nombre " + contadorUsuarios);
        nuevoUsuario.setEmail("usuario" + contadorUsuarios + "@example.com");
        usuarioService.agregarUsuario(nuevoUsuario);
        System.out.println("TestUsuario: Prueba de agregar usuario " + nuevoUsuario.getUsername() + " completada.");
        contadorUsuarios++;
    }

    public static void testObtenerUsuarioPorId() {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(1); // Asumiendo que el primer usuario insertado tiene ID 1
        if (usuario != null) {
            System.out.println("TestUsuario: Usuario obtenido por ID: " + usuario.getNombre());
        } else {
            System.out.println("TestUsuario: No se encontró usuario con ID 1.");
        }
    }

    public static void testListarTodosUsuarios() {
        java.util.List<Usuario> usuarios = usuarioService.listarTodosUsuarios();
        if (usuarios != null && !usuarios.isEmpty()) {
            System.out.println("TestUsuario: Listado de todos los usuarios:");
            for (Usuario usuario : usuarios) {
                System.out.println("- " + usuario.getNombre());
            }
        } else {
            System.out.println("TestUsuario: No se encontraron usuarios en la base de datos.");
        }
    }
}