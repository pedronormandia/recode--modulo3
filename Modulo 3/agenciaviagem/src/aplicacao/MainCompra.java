package aplicacao;

import java.util.Scanner;

import dao.ClienteDAO;
import dao.CompraDAO;
import dao.PacoteDAO;
import model.Cliente;
import model.Compra;
import model.Pacote;

public class MainCompra {

	public static void main(String[] args) {
		CompraDAO codao = new CompraDAO();
		ClienteDAO cdao = new ClienteDAO();
		PacoteDAO pdao = new PacoteDAO();

		Cliente cliente = new Cliente();
		Pacote pacote = new Pacote();

		Scanner sc = new Scanner(System.in);
		int opcao = 0, id = 0, id_cliente = 0, id_pacote = 0;
		String forma_pagamento = "";

		do {

			System.out.println("\n============================== Compra =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:

				System.out.println("Digite o id do cliente:");
				id_cliente = sc.nextInt();
				System.out.println("Digite o id do pacote:");
				id_pacote = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite a forma de pagamento:");
				forma_pagamento = sc.nextLine();

				cliente = cdao.readById(id_cliente);
				pacote = pdao.readById(id_pacote);

				Compra compra = new Compra(cliente, pacote, forma_pagamento);

				codao.save(compra);
				break;
			case 2:

				for (Compra c : codao.getCompras()) {
					c.show();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o id do cliente:");
				id_cliente = sc.nextInt();
				System.out.println("Digite o id do pacote:");
				id_pacote = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite a forma de pagamento:");
				forma_pagamento = sc.nextLine();

				cliente = cdao.readById(id_cliente);
				pacote = pdao.readById(id_pacote);

				Compra compra1 = new Compra(id, cliente, pacote, forma_pagamento);

				codao.update(compra1);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = sc.nextInt();
				sc.nextLine();

				codao.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = sc.nextInt();
				sc.nextLine();

				Compra compra2 = codao.readById(id);

				compra2.show();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		sc.close();

	}
}
