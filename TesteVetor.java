import java.util.Scanner;

public class TesteVetor {
  public static void main(String[] args) {
    // vamos testar a eficácia dos métodos de ordenação
    Scanner scanner = new Scanner(System.in);
    int tamanho = 0;
    boolean segue = true;
    do {
      System.out.println("\n\nSelecione um tamanho: \n");
      System.out.println("[1] - 100m\n");
      System.out.println("[2] - 200m\n");
      System.out.println("[3] - 400m\n");
      System.out.println("[4] - 800m\n");
      System.out.println("[5] - 1,6M\n");
      System.out.println("cancelar - 0\n");
      
      System.out.println("Opcao: ");
      tamanho = scanner.nextInt();

      switch (tamanho) {
        case 1:
          tamanho = 100000;
          break;
        case 2:
          tamanho = 200000;
          break;
        case 3:
          tamanho = 400000;
          break;
        case 4:
          tamanho = 800000;
          break;
        case 5:
          tamanho = 1600000;
          break;
        default:
          tamanho = 0;
          System.out.println("Fim das operacoes");
          segue = false;
          break;
      }
      ;
      
      if (!segue)
        break;
      
      System.out.println("\nTAMANHO DO VETOR: " + tamanho);
      NossoVetor vetor = new NossoVetor(tamanho);

      System.out.println("Selecione um sort:\n");
      System.out.println("[1] Selection Sort\n");
      System.out.println("[2] Insertion Sort\n");
      System.out.println("[3] Bubble Sort\n");
      System.out.println("[4] Cancelar\n");

      System.out.println("Opção: ");
      int sort = scanner.nextInt();
      

      long somaTrocas = 0;
      long somaTempo = 0;
      long somaLinear = 0;
      long somaBinaria = 0;
      long tempoInicial = System.currentTimeMillis();
      double numIteracoes = 30.0;
      if (tamanho == 1600000) {
        System.out.println("vetor de 1.6M !!");
        numIteracoes = 10.0;
      }

      switch (sort) {
        case 1:
          System.out.println("SELECTION SORT");
          for (int i = 0; i < numIteracoes; i++) {
            System.out.println("\n" + (i + 1) + ")");
            long buscaLi = vetor.buscaLinear(500000);
            somaLinear += buscaLi;
            System.out.println("Busca Linear: " + buscaLi);
            vetor.esvaziaVetor();
            vetor.preencheVetor();
            long tempoInicialOrdenacao = System.currentTimeMillis();
            long iteracoes = vetor.selectionsort();
            long buscaBi = vetor.buscaBinaria(500000);
            System.out.println("Busca Binaria: " + buscaBi);
            somaBinaria += buscaBi;
            System.out.println("\nQuantidade de trocas: " + iteracoes);
            long tempoFinalOrdenacao = System.currentTimeMillis();
            System.out.println("Tempo de ordenacao: " + (tempoFinalOrdenacao - tempoInicialOrdenacao) + "ms");
            somaTrocas += iteracoes;
            somaTempo += tempoFinalOrdenacao - tempoInicialOrdenacao;
          }
          break;
        case 2:
          System.out.println("INSERTION SORT");
          for (int i = 0; i < numIteracoes; i++) {
            System.out.println("\n" + (i + 1) + ")");
            long buscaLi = vetor.buscaLinear(500000);
            somaLinear += buscaLi;
            System.out.println("Busca Linear: " + buscaLi);
            vetor.esvaziaVetor();
            vetor.preencheVetor();
            long tempoInicialOrdenacao = System.currentTimeMillis();
            long iteracoes = vetor.insertionSort();
            long buscaBi = vetor.buscaBinaria(500000);
            System.out.println("Busca Binaria: " + buscaBi);
            somaBinaria += buscaBi;
            System.out.println("\nQuantidade de trocas: " + iteracoes);
            long tempoFinalOrdenacao = System.currentTimeMillis();
            System.out.println("Tempo de ordenacao: " + (tempoFinalOrdenacao - tempoInicialOrdenacao) + "ms");
            somaTrocas += iteracoes;
            somaTempo += tempoFinalOrdenacao - tempoInicialOrdenacao;
          }
          break;
        case 3:
          System.out.println("BUBBLE SORT");
          for (int i = 0; i < numIteracoes; i++) {
            System.out.println("\n" + (i + 1) + ")");
            long buscaLi = vetor.buscaLinear(500000);
            somaLinear += buscaLi;
            System.out.println("Busca Linear: " + buscaLi);
            vetor.esvaziaVetor();
            vetor.preencheVetor();
            long tempoInicialOrdenacao = System.currentTimeMillis();
            long iteracoes = vetor.bubbleSort();
            long buscaBi = vetor.buscaBinaria(500000);
            System.out.println("Busca Binaria: " + buscaBi);
            somaBinaria += buscaBi;
            System.out.println("\nQuantidade de trocas: " + iteracoes);
            long tempoFinalOrdenacao = System.currentTimeMillis();
            System.out.println("Tempo de ordenacao: " + (tempoFinalOrdenacao - tempoInicialOrdenacao) + "ms");
            somaTrocas += iteracoes;
            somaTempo += tempoFinalOrdenacao - tempoInicialOrdenacao;
          }
          break;
        default:
          System.out.println("Fim das operacoes");
          segue = false;
          break;
      }

      if (!segue) break;

      long tempoFinal = System.currentTimeMillis();
      double tempoTotalSegundos = (tempoFinal - tempoInicial)/1000.0;
      System.out.printf("\nMedia de trocas: " + (somaTrocas / (long) numIteracoes ) );
      double mediaSegundos = (somaTempo/numIteracoes)/1000.0;
      System.out.printf("\nTempo total: %.1f segundos\n", tempoTotalSegundos);
      System.out.printf("Media para completar: %.1f segundos\n", mediaSegundos);
      System.out.printf("Media Busca Linear: %.1f\n", (somaLinear / numIteracoes));
      System.out.printf("Media Busca Binaria: %.1f\n", (somaBinaria / numIteracoes));


      
    } while (tamanho != 0);
    scanner.close();
  }
}
