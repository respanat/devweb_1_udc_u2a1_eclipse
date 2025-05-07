package TestUnits.TestComputador;

import Models.Entities.Computador;
import Models.Services.ComputadorService;

public class TestComputador {
    private static int contadorComputadores = 1;
    private static final ComputadorService computadorService = new ComputadorService();
    private static final int usuarioIdParaPruebas = 1; // Asumiendo un usuario logueado con ID 1

    public static void main(String[] args) {
        testAgregarComputador();
        testObtenerComputadorPorId();
        testListarTodosComputadores();
    }

    public static void testAgregarComputador() {
        Computador nuevoComputador = new Computador();
        nuevoComputador.setMarca("Marca" + contadorComputadores);
        nuevoComputador.setCategoria("Portátil");
        nuevoComputador.setMarcaCpu("Intel");
        nuevoComputador.setVelocidadCpu("2.5 GHz");
        nuevoComputador.setTecnologiaRam("DDR4");
        nuevoComputador.setCapacidadRam("8GB");
        nuevoComputador.setTecnologiaDisco("SSD");
        nuevoComputador.setCapacidadDisco("256GB");
        nuevoComputador.setNumPuertosUSB(3);
        nuevoComputador.setNumPuertosHDMI(1);
        nuevoComputador.setMarcaMonitor("Genérico");
        nuevoComputador.setPulgadas(15.6);
        nuevoComputador.setPrecio(799.99);
        nuevoComputador.setUsuarioId(usuarioIdParaPruebas);
        computadorService.agregarComputador(nuevoComputador);
        System.out.println("TestComputador: Prueba de agregar computador " + nuevoComputador.getMarca() + " completada.");
        contadorComputadores++;
    }

    public static void testObtenerComputadorPorId() {
        Computador computador = computadorService.obtenerComputadorPorId(1); // Asumiendo que el primer computador insertado tiene ID 1
        if (computador != null) {
            System.out.println("TestComputador: Computador obtenido por ID: " + computador.getMarca());
        } else {
            System.out.println("TestComputador: No se encontró computador con ID 1.");
        }
    }

    public static void testListarTodosComputadores() {
        java.util.List<Computador> computadores = computadorService.listarTodosComputadores(usuarioIdParaPruebas);
        if (computadores != null && !computadores.isEmpty()) {
            System.out.println("TestComputador: Listado de todos los computadores del usuario " + usuarioIdParaPruebas + ":");
            for (Computador computador : computadores) {
                System.out.println("- " + computador.getMarca());
            }
        } else {
            System.out.println("TestComputador: No se encontraron computadores para el usuario " + usuarioIdParaPruebas + " en la base de datos.");
        }
    }
}