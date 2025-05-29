import java.util.Scanner;

public class Impressao {
	public static void main(String[] args) {
		Pilha pilha = new Pilha();
		Fila fila = new Fila();
		Scanner scanner = new Scanner(System.in);
		boolean condicao = true;

		while (condicao) {
			System.out.println("\nEscolha uma opção:");
			System.out.println("0) Inserir na fila");
			System.out.println("1) Remover na fila");
			System.out.println("2) Consultar fila");
			System.out.println("3) Ocupação da fila");

			System.out.println("--------------------------------------------------");
			System.out.println("4) Inserir na pilha");
			System.out.println("5) Remover na pilha");
			System.out.println("6) Consultar na pilha");
			System.out.println("7) Ocupação da pilha");
			System.out.println("8) Sair");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// Ignorar exceção
			}

			int op = scanner.nextInt();
			scanner.nextLine(); // Consumir a quebra de linha pendente

			switch (op) {
				case 0: {
					try {
						Documento documento = new Documento();
						System.out.println("Insira o nome do arquivo:");
						documento.setNomeArquivo(scanner.nextLine());
						System.out.println("Insira o nome do usuário:");
						documento.setNomeUsuario(scanner.nextLine());
						fila.adicionar(documento);
						System.out.println("Documento adicionado na fila.");
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}
					break;
				}
				case 1: {
					try {
						Documento documento = fila.remover();
						System.out.println("Documento removido da fila: " + documento);
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}
					break;
				}
				case 2: {
					System.out.println("Insira o nome do arquivo para consulta:");
					String nomeArquivo = scanner.nextLine();
					int posicao = fila.getPosicao(nomeArquivo);
					if (posicao >= 0) {
						System.out.println("Documento encontrado na posição: " + posicao);
					} else {
						System.out.println("Documento não encontrado na fila.");
					}
					break;
				}
				case 3: {
					System.out.println("Ocupação da fila: " + fila.getOcupacao());
					break;
				}
				case 4: {
					try {
						Documento documento = new Documento();
						System.out.println("Insira o nome do arquivo:");
						documento.setNomeArquivo(scanner.nextLine());
						System.out.println("Insira o nome do usuário:");
						documento.setNomeUsuario(scanner.nextLine());
						pilha.adicionar(documento);
						System.out.println("Documento adicionado na pilha.");
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}
					break;
				}
				case 5: {
					try {
						Documento documento = pilha.remover();
						System.out.println("Documento removido da pilha:\n " + documento);
					} catch (Exception e) {
						System.out.println("Erro: " + e.getMessage());
					}
					break;
				}
				case 6: {
					System.out.println("Insira o nome do arquivo para consulta:");
					String nomeArquivo = scanner.nextLine();
					int posicao = pilha.getPosicao(nomeArquivo);
					if (posicao >= 0) {
						System.out.println("Documento encontrado na posição: " + posicao);
					} else {
						System.out.println("Documento não encontrado na pilha.");
					}
					break;
				}
				case 7: {
					System.out.println("Ocupação da pilha: " + pilha.getOcupacao());
					break;
				}
				case 8: {
					condicao = false;
					System.out.println("Adeus!");
					break;
				}
				default: {
					System.out.println("Opção inválida, tente novamente.");
				}
			}
		}
		scanner.close();
	}
}
