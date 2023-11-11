package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import model.Cliente;

public class MainCliente {

	public static void main(String[] args) {
		ClienteDAO cdao = new ClienteDAO();
		Scanner sc = new Scanner(System.in);
		int opcao = 0, id = 0;
		String nome = "", cpf = "", telefone = "";

		do {

			System.out.println("\n============================== Cliente =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:

				System.out.println("Digite o nome:");
				nome = sc.nextLine();
				System.out.println("Digite a cpf:");
				cpf = sc.nextLine();
				System.out.println("Digite o telefone:");
				telefone = sc.nextLine();

				Cliente cliente = new Cliente(telefone, nome, cpf);

				cdao.save(cliente);
				break;
			case 2:

				for (Cliente c : cdao.getClientes()) {
					c.show();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o nome:");
				nome = sc.nextLine();
				System.out.println("Digite a cpf:");
				cpf = sc.nextLine();
				System.out.println("Digite o telefone:");
				telefone = sc.nextLine();

				Cliente cliente1 = new Cliente(telefone, nome, cpf, id);

				cdao.update(cliente1);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = sc.nextInt();
				sc.nextLine();

				cdao.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = sc.nextInt();
				sc.nextLine();

				Cliente cliente2 = cdao.readById(id);

				cliente2.show();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		sc.close();

	}

}
