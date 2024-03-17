import java.util.HashMap;
public class GestaoDeDados {
    private HashMap<String, Cliente> clientesByCpf; // Mapa para armazenar os clientes indexados pelo CPF
    private int numClientes; // Número atual de clientes

    public GestaoDeDados() {
        clientesByCpf = new HashMap<>();
        numClientes = 0;
    }

    public void adicionarCliente(String nome, String cpf, String telefone, String email) {
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

    public void buscarCliente(String cpf) {
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

    public void listarClientes() {
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
}
