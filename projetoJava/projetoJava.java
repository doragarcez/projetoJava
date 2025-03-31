import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class projetoJava {

    public static void abrirConsole() {
        System.out.println("x -------------------------------------- x");
        System.out.println("|  [1] Inserir nome no arquivo           |");
        System.out.println("|  [2] Exibir todos os nomes do arquivo  |");
        System.out.println("|  [3] Apagar todo arquivo               |");
        System.out.println("|  [4] Sair do console                   |");
        System.out.println("x -------------------------------------- x");
        System.out.print(">");
    }

    public static void inserirNome(Scanner scanner) {
        try {
            File arquivo = new File("C:\\Users\\Dora\\Desktop\\java\\teste.txt");
            FileWriter nome = new FileWriter(arquivo, true);
            System.out.print("Digite um nome: ");
            scanner.nextLine();
            String entrada = scanner.nextLine();

            nome.write(entrada + "\n");
            nome.flush();
            nome.close();

        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public static void exibirNomes() {
        try {
            File arquivo = new File("C:\\Users\\Dora\\Desktop\\java\\teste.txt");
            Scanner exibir = new Scanner(arquivo);

            System.out.println("\nConteúdo do arquivo:");
            while (exibir.hasNextLine()) {
                System.out.println(exibir.nextLine());
            }

            exibir.close();
            System.out.println();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static void apagarConteudo() {
        try {
            FileWriter borracha = new FileWriter("C:\\Users\\Dora\\Desktop\\java\\teste.txt");
            borracha.write("");
            borracha.close();
            System.out.println("Conteúdo apagado com sucesso!\n");
        } catch (IOException e) {
            System.out.println("Erro ao apagar o conteúdo: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        boolean rodando = true;

        while (rodando){
            abrirConsole();
            int entrada = scanner.nextInt();

            switch (entrada){
                case 1:
                    inserirNome(scanner);
                    break;
                case 2:
                    exibirNomes();
                    break;
                case 3:
                    apagarConteudo();
                    break;
                case 4:
                    System.out.println("Fechando o console...");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
