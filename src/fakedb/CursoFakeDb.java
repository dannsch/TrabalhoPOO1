package fakedb;

import java.util.ArrayList;

import dominio.Curso;

public class CursoFakeDb extends BaseFakeDb<Curso> {

    @Override
    public ArrayList<Curso> PreencherDados() {
        this.tabela = new ArrayList<>();
        this.tabela.add(new Curso(1, "C. Computação - BACHARELADO",
                "Curso dos Programadores", 800));

        this.tabela.add(new Curso(2, "Medicina",
                "Curso dos Médicos", 1000));

        this.tabela.add(new Curso(3, "Moda",
                "Curso dos que se vestem bem", 10));

        return this.tabela;

    }

    public CursoFakeDb() {
        super();
    }
}