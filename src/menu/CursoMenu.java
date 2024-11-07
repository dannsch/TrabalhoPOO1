package menu;

import java.util.ArrayList;
import dominio.Curso;
import servico.CursoServico;

public class CursoMenu extends BaseMenu {

    private CursoServico srv;

    public CursoMenu() {
        super();
        this.srv = new CursoServico();
    }

    @Override
    public void ExibirMenu() {
        int opcao = 0;
        while (opcao != 9) {
            Util.ClearConsole();
            System.out.println("Menu de Opções");
            System.out.println("1 - Listar");
            System.out.println("2 - Localizar");
            System.out.println("3 - Adicionar");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Remover");
            System.out.println("9 - Sair");
            System.out.print("Digite sua opção: ");
            opcao = this.scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    this.Listar();
                    break;
                case 2:
                    this.Localizar();
                    break;
                case 3:
                    this.Adicionar();
                    break;
                case 4:
                    this.Atualizar();
                    break;
                case 5:
                    this.Remover();
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    @Override
    public void Listar() {
        Util.ClearConsole();
        System.out.println("Listando...");

        ArrayList<Curso> lista = this.srv.LerTodos();
        for (Curso curso : lista) {
            this.ImprimirEmLinha(curso);
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    @Override
    public void Localizar() {
        Util.ClearConsole();
        System.out.println("Localizando...");

        System.out.print("Informe o código do Curso: ");
        int codigo = this.scanner.nextInt();
        scanner.nextLine();

        Curso curso = this.srv.Ler(codigo);
        if (curso != null) {
            this.ImprimirEmLinha(curso);
        } else {
            System.out.println("Problema - Curso não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    @Override
    public void Adicionar() {
        Util.ClearConsole();
        System.out.println("Adicionando...");

        System.out.print("Informe o Nome do Curso: ");
        String nome = this.scanner.nextLine();

        System.out.print("Informe a Descrição do Curso: ");
        String descricao = this.scanner.nextLine();

        System.out.print("Informe a Carga Horária do Curso: ");
        int cargahr = this.scanner.nextInt();

        this.scanner.nextLine();

        Curso curso = new Curso();
        curso.setCodigo(0);
        curso.setNome(nome);
        curso.setDescricao(descricao);
        curso.setCargahr(cargahr);

        Curso cursoNovo = this.srv.Criar(curso);
        if (cursoNovo != null) {
            System.out.println("Curso adicionado com sucesso");
        } else {
            System.out.println("Problema - Curso não foi adicionado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    @Override
    public void Atualizar() {
        Util.ClearConsole();
        System.out.println("Atualizando...");

        System.out.print("Informe o código do Curso: ");
        int codigo = this.scanner.nextInt();
        scanner.nextLine();

        Curso curso = this.srv.Ler(codigo);
        if (curso != null) {
            System.out.print("Informe a nova Descrição para este Curso: ");
            String descricao = this.scanner.nextLine();
            curso.setDescricao(descricao);
            if (this.srv.Atualizar(curso) != null) {
                System.out.println("Curso atualizado com sucesso");
            } else {
                System.out.println("Problema - Curso não foi atualizado");
            }
        } else {
            System.out.println("Problema - Curso não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    @Override
    public void Remover() {
        Util.ClearConsole();
        System.out.println("Removendo...");

        System.out.print("Informe o código do Curso: ");
        int codigo = this.scanner.nextInt();
        scanner.nextLine();

        Curso curso = this.srv.Ler(codigo);
        if (curso != null) {
            if (this.srv.Deletar(codigo) != null) {
                System.out.println("Curso removido com sucesso");
            } else {
                System.out.println("Problema - Curso não foi removido");
            }
        } else {
            System.out.println("Problema - Curso não foi encontrado");
        }

        System.out.println("Clique <ENTER> para continuar...");
        this.scanner.nextLine();
    }

    private void ImprimirEmLinha(Curso curso) {
        String msg = "Curso - ";
        msg += "Código: " + curso.getCodigo() + " | ";
        msg += "Nome: " + curso.getNome() + " | ";
        msg += "Descrição: " + curso.getDescricao() + " | ";
        msg += "Carga Horária: " + curso.getCargahr();
        System.out.println(msg);
    }
}