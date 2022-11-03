import java.util.Scanner;

public class Principal extends AbstractPessoa {
    static String decisao;

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Você gostaria de CONSULTAR ou INSERIR?");
        decisao = read.next();

        switch (decisao) {
            case "c":
                SearchData search = new SearchData();
                search.buscar();
                break;

            case "i":
                SearchData insert = new SearchData();

                System.out.println("Digite um celular:");
                celular = read.next();

                System.out.println("Digite um nome:");
                nome = read.next();

                System.out.println("Digite um curso:");
                curso = read.next();

                insert.alterar(celular, nome, curso);

            default:
                System.out.println("Digite C ou I para fazer funcionar!");
                break;
        }

        read.close();

    }
}