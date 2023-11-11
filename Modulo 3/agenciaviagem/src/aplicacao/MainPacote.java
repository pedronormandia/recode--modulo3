package aplicacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import dao.PacoteDAO;
import model.Pacote;

public class MainPacote {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PacoteDAO pdao = new PacoteDAO();

		int opcao = 0, id = 0, tempoEstadia = 0;
		String destino = "", dataStr = "";
		Date data = new Date();
		float valor = 0;

		do {

			System.out.println("\n============================== Pacote =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:

				System.out.println("Digite o destino:");
				destino = sc.nextLine();
				System.out.println("Digite a data(dd/MM/AAAA):");
				dataStr = sc.nextLine();

				try {
					data = sdf.parse(dataStr);
				} catch (Exception e) {
					// TODO: handle exception
				}

				System.out.println("Digite o tempo de estadia:");
				tempoEstadia = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o valor:");
				valor = sc.nextFloat();

				Pacote pacote = new Pacote(tempoEstadia, valor, data, destino);

				pdao.save(pacote);
				break;
			case 2:

				for (Pacote p : pdao.getPacotes()) {
					p.show();
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o destino:");
				destino = sc.nextLine();
				System.out.println("Digite a data(dd/MM/AAAA):");
				dataStr = sc.nextLine();

				try {
					data = sdf.parse(dataStr);
				} catch (Exception e) {
					// TODO: handle exception
				}

				System.out.println("Digite o tempo de estadia:");
				tempoEstadia = sc.nextInt();
				sc.nextLine();
				System.out.println("Digite o valor:");
				valor = sc.nextFloat();

				Pacote pacote1 = new Pacote(id, tempoEstadia, valor, data, destino);

				pdao.update(pacote1);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = sc.nextInt();
				sc.nextLine();

				pdao.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = sc.nextInt();
				sc.nextLine();

				Pacote pacote2 = pdao.readById(id);

				pacote2.show();
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		sc.close();

	}
}
