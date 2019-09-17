package br.ifpb.edu.universidade;

import br.ifpb.edu.entities.Funcionário;

import java.util.ArrayList;
import java.util.List;

public class Universidade {
    private String nome;
    private List<Funcionário> listaDeFuncionários;

    {
        this.setListaDeFuncionários(new ArrayList<>());
    }

    public Universidade() {
        this.setNome( "Sem Nome" );
    }

    public Universidade(String nome) {
        this.setNome( nome );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        }
    }

    public List<Funcionário> getListaDeFuncionários() {
        return listaDeFuncionários;
    }

    public void setListaDeFuncionários(List<Funcionário> listaDeFuncionários) {
        this.listaDeFuncionários = listaDeFuncionários;
    }

    public boolean existeFuncionário(int matrícula) {
        for (Funcionário funcionário : this.getListaDeFuncionários()) {
            if (funcionário.getMatrícula() == matrícula) {
                return true;
            }
        }

        return false;
    }

    public boolean cadastraFuncionário(Funcionário funcionário) {
        return this.getListaDeFuncionários().add(funcionário);
    }

    public boolean removeFuncionário(int matrícula) {
        for (Funcionário funcionário : this.getListaDeFuncionários()) {
            if (funcionário.getMatrícula() == matrícula) {
                return this.getListaDeFuncionários().remove(funcionário);
            }
        }
        return false;
    }

    public int quantidadeDeFuncionários() {
        return this.getListaDeFuncionários().size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append("|\t Universidade " + this.getNome() + "\t |\n");
        str.append("|\t Lista de Funcionários \t|\n");
        for (Funcionário funcionário : this.getListaDeFuncionários()) {
            str.append(funcionário);
            str.append("\n-----\n");
        }

        return str.toString();
    }
}
