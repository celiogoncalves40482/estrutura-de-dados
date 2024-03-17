import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GestaoDeDados gestaoDeDados = new GestaoDeDados();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Buscar Cliente");
            System.out.println("3. Listar Clientes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha após a leitura do número

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    gestaoDeDados.adicionarCliente(nome, cpf, telefone, email);
                    break;
                case 2:
                    System.out.print("CPF do cliente a buscar: ");
                    String cpfBuscar = scanner.nextLine();
                    gestaoDeDados.buscarCliente(cpfBuscar);
                    break;
                case 3:
                    gestaoDeDados.listarClientes();
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println(); // Quebra de linha após a ação
        }
    }
}
