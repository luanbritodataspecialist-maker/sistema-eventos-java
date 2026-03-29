package view;

import controller.EventoController;
import model.Evento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenuView {

    private EventoController controller = new EventoController();
    private Scanner sc = new Scanner(System.in);

    public void iniciar() {
        controller.carregar();

        int op;
        do {
            System.out.println("\n1 - Cadastrar evento");
            System.out.println("2 - Listar eventos");
            System.out.println("3 - Salvar");
            System.out.println("0 - Sair");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> controller.salvar();
            }

        } while (op != 0);
    }

    private void cadastrar() {
        System.out.println("Nome:");
        String nome = sc.nextLine();

        System.out.println("Endereço:");
        String endereco = sc.nextLine();

        System.out.println("Categoria:");
        String categoria = sc.nextLine();

        System.out.println("Data (yyyy-MM-dd HH:mm):");
        String data = sc.nextLine();

        System.out.println("Descrição:");
        String descricao = sc.nextLine();

        LocalDateTime horario = LocalDateTime.parse(
                data,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
        );

        controller.cadastrar(new Evento(nome, endereco, categoria, horario, descricao));
    }

    private void listar() {
        for (Evento e : controller.listarOrdenados()) {
            System.out.println("------------");
            System.out.println(e.getNome());
            System.out.println(controller.status(e));
        }
    }
}
