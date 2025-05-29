import java.util.Scanner;

public class TesteVetor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean continua = true;

		while (continua) {
			int tamanho = selecionarTamanho(scanner);
			if (tamanho == 0) {
				System.out.println("Fim das operações");
				break;
			}

			NossoVetor vetor = new NossoVetor(tamanho);
			int sort = selecionarSort(scanner);
			if (sort == 0) {
				System.out.println("Fim das operações");
				break;
			}

			int numIteracoes = tamanho == 1600000 ? 10 : 30;

			executarTestes(vetor, sort, numIteracoes);
		}

		scanner.close();
	}

	private static int selecionarTamanho(Scanner scanner) {
		System.out.println("\n\nSelecione um tamanho:");
		System.out.println("[1] - 100m");
		System.out.println("[2] - 200m");
		System.out.println("[3] - 400m");
		System.out.println("[4] - 800m");
		System.out.println("[5] - 1,6M");
		System.out.println("[0] - Cancelar");
		System.out.print("Opção: ");

		int opcao = scanner.nextInt();
		switch (opcao) {
			case 1:
				return 100000;
			case 2:
				return 200000;
			case 3:
				return 400000;
			case 4:
				return 800000;
			case 5:
				return 1600000;
			default:
				return 0;
		}
	}

	private static int selecionarSort(Scanner scanner) {
		System.out.println("\nSelecione um sort:");
		System.out.println("[1] Selection Sort");
		System.out.println("[2] Insertion Sort");
		System.out.println("[3] Bubble Sort");
		System.out.println("[0] Cancelar");
		System.out.print("Opção: ");
		return scanner.nextInt();
	}

	private static void executarTestes(NossoVetor vetor, int sort, int numIteracoes) {
		System.out.println("\nTAMANHO DO VETOR: " + vetor.getTamanho());
		String nomeSort;

		switch (sort) {
			case 1:
				nomeSort = "SELECTION SORT";
				break;
			case 2:
				nomeSort = "INSERTION SORT";
				break;
			case 3:
				nomeSort = "BUBBLE SORT";
				break;
			default:
				System.out.println("Sort inválido.");
				return;
		}

		System.out.println(nomeSort);

		long somaTrocas = 0;
		long somaTempo = 0;
		long somaLinear = 0;
		long somaBinaria = 0;
		long tempoInicialTotal = System.currentTimeMillis();

		for (int i = 0; i < numIteracoes; i++) {
			System.out.println("\nIteração " + (i + 1) + ")");
			long buscaLi = vetor.buscaLinear(500000);
			somaLinear += buscaLi;
			System.out.println("Busca Linear: " + buscaLi);

			vetor.esvaziaVetor();
			vetor.preencheVetor();

			long tempoIni = System.currentTimeMillis();
			long trocas = 0;
			switch (sort) {
				case 1:
					trocas = vetor.selectionsort();
					break;
				case 2:
					trocas = vetor.insertionSort();
					break;
				case 3:
					trocas = vetor.bubbleSort();
					break;
			}
			long buscaBi = vetor.buscaBinaria(500000);
			somaBinaria += buscaBi;
			System.out.println("Busca Binária: " + buscaBi);

			long tempoFim = System.currentTimeMillis();
			long duracao = tempoFim - tempoIni;

			System.out.println("Quantidade de trocas: " + trocas);
			System.out.println("Tempo de ordenação: " + duracao + "ms");

			somaTrocas += trocas;
			somaTempo += duracao;
		}

		long tempoFinalTotal = System.currentTimeMillis();
		double tempoTotalSegundos = (tempoFinalTotal - tempoInicialTotal) / 1000.0;
		double mediaTrocas = (double) somaTrocas / numIteracoes;
		double mediaTempo = (double) somaTempo / numIteracoes / 1000.0;
		double mediaLinear = (double) somaLinear / numIteracoes;
		double mediaBinaria = (double) somaBinaria / numIteracoes;

		System.out.printf("\nMédia de trocas: %.0f\n", mediaTrocas);
		System.out.printf("Tempo total: %.1f segundos\n", tempoTotalSegundos);
		System.out.printf("Média para completar: %.1f segundos\n", mediaTempo);
		System.out.printf("Média Busca Linear: %.1f\n", mediaLinear);
		System.out.printf("Média Busca Binária: %.1f\n", mediaBinaria);
	}
}
