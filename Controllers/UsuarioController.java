package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usuarios")
public class UsuarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "listar"; // Acción por defecto
        }

        switch (action) {
            case "agregarForm":
                // Mostrar formulario para agregar usuario
                System.out.println("UsuarioController: Preparando formulario para agregar usuario.");
                request.getRequestDispatcher("/Views/forms/usuarios/agregar.jsp").forward(request, response);
                break;
            case "agregar":
                // Lógica para agregar un nuevo usuario
                System.out.println("UsuarioController: Recibida petición para agregar usuario.");
                // Aquí iría la interacción con el Modelo (Service y Repository)
                break;
            case "buscarForm":
                // Mostrar formulario para buscar usuario
                System.out.println("UsuarioController: Preparando formulario para buscar usuario.");
                request.getRequestDispatcher("/Views/forms/usuarios/buscar.jsp").forward(request, response);
                break;
            case "buscar":
                // Lógica para buscar un usuario
                System.out.println("UsuarioController: Recibida petición para buscar usuario.");
                // Aquí iría la interacción con el Modelo
                break;
            case "listarPersonalizadaForm":
                // Mostrar formulario para listar usuarios de forma personalizada
                System.out.println("UsuarioController: Preparando formulario para listar usuarios de forma personalizada.");
                request.getRequestDispatcher("/Views/forms/usuarios/listar_personalizada.jsp").forward(request, response);
                break;
            case "listarPersonalizada":
                // Lógica para listar usuarios de forma personalizada
                System.out.println("UsuarioController: Recibida petición para listar usuarios de forma personalizada.");
                // Aquí iría la interacción con el Modelo
                break;
            case "listar":
            default:
                // Lógica para listar todos los usuarios
                System.out.println("UsuarioController: Recibida petición para listar todos los usuarios.");
                // Aquí iría la interacción con el Modelo
                break;
            case "loginForm":
                System.out.println("UsuarioController: Preparando formulario de login.");
                request.getRequestDispatcher("/Views/forms/usuarios/login.jsp").forward(request, response);
                break;
            case "login":
                System.out.println("UsuarioController: Recibida petición de login.");
                // Lógica de autenticación aquí
                break;
            case "recordarPasswordForm":
                System.out.println("UsuarioController: Preparando formulario para recordar contraseña.");
                request.getRequestDispatcher("/Views/forms/usuarios/recordar_password.jsp").forward(request, response);
                break;
            case "recordarPassword":
                System.out.println("UsuarioController: Recibida petición para recordar contraseña.");
                // Lógica para recordar contraseña
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}