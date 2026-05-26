import entities.Passenger;
import entities.Route;
import entities.Reservation;
import repositories.PassengerRepository;
import repositories.RouteRepository;
import repositories.ReservationRepository;
import services.PassengerService;
import services.RouteService;
import services.ReservationService;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static PassengerRepository passengerRepository = new PassengerRepository();
    static RouteRepository routeRepository = new RouteRepository();
    static ReservationRepository reservationRepository = new ReservationRepository();

    static PassengerService passengerService = new PassengerService(passengerRepository);
    static RouteService routeService = new RouteService(routeRepository);
    static ReservationService reservationService =
            new ReservationService(reservationRepository, passengerRepository, routeRepository);

    public static void main(String[] args) {

        int option;
        do {
            System.out.println("\n=====FLUXIOBUS=====");
            System.out.println("1. REGISTRAR PASAJERO");
            System.out.println("2. REGISTRAR RUTA");
            System.out.println("3. LISTAR PASAJEROS");
            System.out.println("4. LISTAR RUTAS");
            System.out.println("5. BUSCAR PASAJERO");
            System.out.println("6. ELIMINAR PASAJERO");
            System.out.println("7. CREAR RESERVA");
            System.out.println("8. CANCELAR RESERVA");
            System.out.println("9. SALIR");
            System.out.print("OPCION: ");
            option = sc.nextInt();
            sc.nextLine();

            try {
                switch (option) {
                    case 1:
                        registerPassenger(readPassenger());
                        break;
                    case 2:
                        registerRoute(readRoute());
                        break;
                    case 3:
                        listPassengers();
                        break;
                    case 4:
                        listRoutes();
                        break;
                    case 5:
                        findPassenger(readId());
                        break;
                    case 6:
                        deletePassenger(readId());
                        break;
                    case 7:
                        registerReservation(readReservation());
                        break;
                    case 8:
                        cancelReservation(readReservationCode());
                        break;
                    case 9:
                        exitSystem();
                        break;
                    default:
                        System.out.println("OPCION NO VALIDA");
                }
            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        } while (option != 9);
    }

    public static void registerReservation(Reservation reservation) throws Exception {
        reservationService.createReservation(reservation);
        System.out.println("RESERVA REGISTRADA EXITOSAMENTE");
    }

    public static void cancelReservation(String code) throws Exception {
        reservationService.cancelReservation(code);
        System.out.println("RESERVA CANCELADA EXITOSAMENTE");
    }

    public static Reservation readReservation() {

        System.out.print("CODIGO DE RESERVA: ");
        String code = sc.nextLine();

        System.out.print("CEDULA DEL PASAJERO: ");
        long passengerId = sc.nextLong();

        System.out.print("CODIGO DE LA RUTA: ");
        String routeCode = sc.next();
        sc.nextLine();

        System.out.print("CANTIDAD DE PUESTOS: ");
        int chairs = sc.nextInt();
        sc.nextLine();

        System.out.print("FECHA DE LA RESERVA: ");
        String date = sc.nextLine();

        Passenger p = new Passenger(passengerId, 0, "", "", "", "", "", "");
        Route r = new Route(routeCode, "", "", "", "", "", 0, 0, 0, "");

        return new Reservation(code, p, r, chairs, date, 0, "CONFIRMADA");
    }

    public static String readReservationCode() {
        System.out.print("CODIGO DE RESERVA: ");
        return sc.nextLine();
    }

    public static void registerPassenger(Passenger passenger) throws Exception {
        passengerService.registerPassenger(passenger);
        System.out.println("PASAJERO REGISTRADO EXITOSAMENTE");
    }

    public static void registerRoute(Route route) throws Exception {
        routeService.registerRoute(route);
        System.out.println("RUTA REGISTRADA EXITOSAMENTE");
    }

    public static void listPassengers() {
        System.out.println("\n--- PASAJEROS ---");
        passengerRepository.getAll().forEach(System.out::println);
    }

    public static void listRoutes() {
        System.out.println("\n--- RUTAS ---");
        routeRepository.getAll().forEach(System.out::println);
    }

    public static void findPassenger(long id) throws Exception {
        System.out.println(passengerService.findPassenger(id));
    }

    public static void deletePassenger(long id) throws Exception {
        passengerService.deletePassenger(id);
        System.out.println("EL PASAJERO HA SIDO ELIMINADO DE FORMA EXITOSA");
    }

    public static void exitSystem() {
        System.out.println("SALIENDO DEL SISTEMA.......");
    }

    public static Passenger readPassenger() {

        System.out.print("CEDULA: ");
        long id = sc.nextLong();
        sc.nextLine();

        System.out.print("NOMBRES: ");
        String names = sc.nextLine();

        System.out.print("APELLIDOS: ");
        String lastNames = sc.nextLine();

        System.out.print("EDAD: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("EMAIL: ");
        String email = sc.nextLine();

        System.out.print("TELEFONO: ");
        String phone = sc.nextLine();

        System.out.print("PASAPORTE: ");
        String passport = sc.nextLine();

        System.out.print("NACIONALIDAD: ");
        String nationality = sc.nextLine();

        return new Passenger(id, age, names, lastNames, email, phone, passport, nationality);
    }

    public static Route readRoute() {

        System.out.print("CODIGO DE LA RUTA: ");
        String code = sc.nextLine();

        System.out.print("ORIGEN: ");
        String origin = sc.nextLine();

        System.out.print("DESTINO: ");
        String destination = sc.nextLine();

        System.out.print("FECHA DE SALIDA: ");
        String dateExit = sc.nextLine();

        System.out.print("HORA DE SALIDA: ");
        String timeExit = sc.nextLine();

        System.out.print("TIEMPO ESTIMADO: ");
        String estimatedTime = sc.nextLine();

        System.out.print("CAPACIDAD: ");
        int capacity = sc.nextInt();

        System.out.print("PUESTOS DISPONIBLES: ");
        int chairs = sc.nextInt();

        System.out.print("PRECIO BASE: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("ESTADO: ");
        String status = sc.nextLine();

        return new Route(code, origin, destination, dateExit, timeExit, estimatedTime, capacity, chairs, price, status);
    }

    public static long readId() {
        System.out.print("CEDULA DE PASAJERO: ");
        return sc.nextLong();
    }
}