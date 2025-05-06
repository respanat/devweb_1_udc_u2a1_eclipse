package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/computadores")
public class ComputadorController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("usuarioLogueado") == null) {
            System.out.println("ComputadorController: Usuario no logueado, redirigiendo al login.");
            response.sendRedirect(request.getContextPath() + "/usuarios?action=loginForm");
            return;
        }

        String action = request.getParameter("action");
        if (action == null) {
            action = "listar"; // Acción por defecto
        }

        switch (action) {
            case "agregarForm":
                // Mostrar formulario para agregar computador
                System.out.println("ComputadorController: Preparando formulario para agregar computador.");
                request.getRequestDispatcher("/Views/forms/computadores/agregar.jsp").forward(request, response);
                break;
            case "agregar":
                // Lógica para agregar un nuevo computador
                System.out.println("ComputadorController: Recibida petición para agregar computador.");
                // Aquí iría la interacción con el Modelo
                break;
            case "buscarForm":
                // Mostrar formulario para buscar computador
                System.out.println("ComputadorController: Preparando formulario para buscar computador.");
                request.getRequestDispatcher("/Views/forms/computadores/buscar.jsp").forward(request, response);
                break;
            case "buscar":
                // Lógica para buscar un computador
                System.out.println("ComputadorController: Recibida petición para buscar computador.");
                // Aquí iría la interacción con el Modelo
                break;
            case "listarPersonalizadaForm":
                // Mostrar formulario para listar computadores de forma personalizada
                System.out.println("ComputadorController: Preparando formulario para listar computadores de forma personalizada.");
                request.getRequestDispatcher("/Views/forms/computadores/listar_personalizada.jsp").forward(request, response);
                break;
            case "listarPersonalizada":
                // Lógica para listar computadores de forma personalizada
                System.out.println("ComputadorController: Recibida petición para listar computadores de forma personalizada.");
                // Aquí iría la interacción con el Modelo
                break;
            case "listar":
            default:
                // Lógica para listar todos los computadores
                System.out.println("ComputadorController: Recibida petición para listar todos los computadores.");
                // Aquí iría la interacción con el Modelo
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}