package br.com.guilherme.banco;

import br.com.guilherme.contacorrente.ContaCorrente;
import br.com.guilherme.exceptions.*;

import org.apache.commons.lang3.*;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String bankName;
    private List<ContaCorrente> listaDeContasCorrente;

    {
        this.setListaDeContasCorrente(new ArrayList<>());
    }

    public Banco() {
        this.setBankName("--- Banco Sem Nome ---");
    }

    public Banco(String bankName) {
        this.setBankName(bankName);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        if (StringUtils.isNotBlank(bankName)) {
            this.bankName = bankName;
        } else {
            throw new NomeInválidoException();
        }
    }

    public boolean adicionaConta(ContaCorrente cc) {
        if (!existeConta(cc.getNúmero())) {
            return listaDeContasCorrente.add(cc);
        } else {
            throw new ContaJáCadastradaException();
        }
    }

    public boolean removeConta(int número) {
        for (ContaCorrente cc : listaDeContasCorrente) {
            if (cc.getNúmero() == número) {
                return listaDeContasCorrente.remove(cc);
            }
        }
        return false;
    }

    public boolean existeConta(int número) {
        for (ContaCorrente tmp : listaDeContasCorrente) {
            if (tmp.getNúmero() == número) {
                return true;
            }
        }
        return false;
    }

    public int quantidadeDeContas() {
        return listaDeContasCorrente.size();
    }

    public List<ContaCorrente> getListaDeContasCorrente() {
        return listaDeContasCorrente;
    }

    private void setListaDeContasCorrente(List<ContaCorrente> listaDeContasCorrente) {
        this.listaDeContasCorrente = listaDeContasCorrente;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("|Banco ").append(bankName).append("|").append("\n");

        for (ContaCorrente cc : listaDeContasCorrente) {
            str.append(cc.toString()).append("\n");
        }

        return str.toString();
    }
}
