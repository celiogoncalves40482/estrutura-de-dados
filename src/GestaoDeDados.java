import java.util.HashMap;
import java.util.Scanner;

public class GestaoDeDados {
    private HashMap<String, Cliente> clientesByCpf; // Mapa para armazenar os clientes indexados pelo CPF
    private int numClientes; // Número atual de clientes

    public GestaoDeDados() {
        clientesByCpf = new HashMap<>();
        numClientes = 0;
    }

    private void adicionarCliente(String nome, String cpf, String telefone, String email) {
        // Verifica se o CPF já existe no HashMap
        if (clientesByCpf.containsKey(cpf)) {
            System.out.println("CPF já cadastrado. Não é possível adicionar cliente.");
            return;
        }

        // Se o CPF não existe, adiciona o cliente ao HashMap
        Cliente cliente = new Cliente(nome, cpf, telefone, email);
        clientesByCpf.put(cpf, cliente);
        numClientes++;
        System.out.println("Cliente adicionado com sucesso!");
    }

    private void buscarCliente(String cpf) {
        Cliente cliente = clientesByCpf.get(cpf); // Busca direta pelo CPF no HashMap
        if (cliente != null) {
            System.out.println();
            System.out.println("Cliente encontrado:");
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
        } else {
            System.out.println("Cliente não encontrado.");
        }
        System.out.println(); // Quebra de linha após a ação
    }

    private void listarClientes() {
        if (numClientes == 0) {
            System.out.println("Não há clientes cadastrados.");
            System.out.println(); // Quebra de linha após a mensagem
            return;
        }

        System.out.println("Listagem de Clientes:");
        for (Cliente cliente : clientesByCpf.values()) {
            System.out.println();
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Telefone: " + cliente.getTelefone());
            System.out.println("Email: " + cliente.getEmail());
            System.out.println(); // Quebra de linha após cada cliente
        }
    }

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

class Cliente {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Cliente(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
