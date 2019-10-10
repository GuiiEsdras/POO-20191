package br.com.guilherme.contacorrente;

import br.com.guilherme.exceptions.*;

// Apache Utils | Funções úteis
import org.apache.commons.lang3.*;

// Java Utils
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class ContaCorrente {
    private Locale local = new Locale("pt", "BR");

    private int número;
    private Date dataDeCadastro;

    private String titular;
    private String senha;
    private double saldo;

    private static int INCREMENTADOR = 0;

    {
        this.setNúmero( ++INCREMENTADOR );
        this.setDataDeCadastro( new Date() );
    }

    public ContaCorrente() {
        this.setTitular( "Sem Nome");
        this.setSenha( "123456" );
        this.setSaldo( 10 );
    }

    public ContaCorrente(String titular, String senha, double saldo) {
        this.setTitular( titular );
        this.setSenha( senha );
        this.setSaldo( saldo );
    }

    public int getNúmero() {
        return número;
    }

    private void setNúmero(int número) {
        this.número = número;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (StringUtils.isNotBlank(titular)) {
            this.titular = titular;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            throw new QuantiaNegativaException();
        }
    }

    public void depositar(double quantia) {
        if (quantia > 0) {
            this.setSaldo(this.getSaldo() + quantia);
        } else if (quantia == 0) {
            throw new IgualAZeroException();
        } else {
            throw new QuantiaNegativaException();
        }
    }

    public double sacar(double quantia) {
        if ( (quantia > 0) && (this.getSaldo() > (quantia + this.calculaCPMF(quantia))) ) {
            this.setSaldo( this.descontaCPMF(quantia) );
            return quantia;
        } else if (quantia == 0) {
            throw new IgualAZeroException();
        } else if (quantia < 0) {
            throw new QuantiaNegativaException();
        } else {
            throw new SaldoInsuficienteException();
        }
    }

    private double calculaCPMF(double quantia) {
        return (quantia * 0.01);
    }

    private double descontaCPMF(double quantia) {
        return (this.getSaldo() - (quantia + this.calculaCPMF(quantia)));
    }

    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);

        return String.format("|Dados da Conta %d|\n", this.getNúmero()) +
                             "Titular: " + this.getTitular() + "\n" +
                             "Saldo: " + formatoMoeda.format(this.getSaldo()) + "\n" +
                             String.format("%1$s %2$td de %2$tB de %2$tY às %2$tr",
                                    "Membro Desde: ", this.getDataDeCadastro() );
    }
}
