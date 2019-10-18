package br.com.guilherme.conta.contacorrente;

// Apache Utils | Funções úteis
import br.com.guilherme.conta.exceptions.CPFInvalidoException;
import br.com.guilherme.conta.exceptions.IgualAZeroException;
import br.com.guilherme.conta.exceptions.QuantiaNegativaException;
import br.com.guilherme.conta.exceptions.SaldoInsuficienteException;
import org.apache.commons.lang3.*;

// Java Utils
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class ContaCorrente
{
    private Locale local = new Locale("pt", "BR");

    private int número;
    private Date dataDeCadastro;

    private static final String TITULAR_SEM_NOME = "---Sem Nome---";
    private static final String TITULAR_SEM_CPF = "---Sem CPF---";
    private static final String SENHA_DEFAULT = "123456";
    private static final double SALDO_INICIAL_DEFAULT = 10;

    private String titular;
    private String CPF;
    private String senha;
    private double saldo;

    private static int INCREMENTADOR = 0;

    {
        this.setNúmero( ++INCREMENTADOR );
        this.setDataDeCadastro( new Date() );
    }

    public ContaCorrente() {
        this.setTitular( TITULAR_SEM_NOME );
        this.setCPF( TITULAR_SEM_CPF );
        this.setSenha( SENHA_DEFAULT );
        this.setSaldo( SALDO_INICIAL_DEFAULT );
    }

    public ContaCorrente(String titular, String CPF, String senha, double saldo) {
        this.setTitular( titular );
        this.setCPF( CPF );
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if (!CPF.equals(TITULAR_SEM_CPF)) {
            String CPFTemp = Objects.requireNonNullElse(StringUtils.defaultIfBlank(CPF, TITULAR_SEM_CPF), TITULAR_SEM_CPF);
            if (CPFValido(CPFTemp)) {
                this.CPF =  CPFTemp.substring(0, 3) + "." +
                            CPFTemp.substring(3, 6) + "." +
                            CPFTemp.substring(6, 9) + "-" +
                            CPFTemp.substring(9, 11);
            } else {
                throw new CPFInvalidoException();
            }
        } else {
            this.CPF = CPF;
        }
    }

    public boolean CPFValido(String CPF) {
        return (CPF.length() == 11) && (CPF.replaceAll(String.valueOf(CPF.charAt(0)), "").length() > 0);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContaCorrente that = (ContaCorrente) o;

        return CPF.equals(that.CPF);
    }

    @Override
    public int hashCode() {
        return CPF.hashCode();
    }

    @Override
    public String toString() {
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(local);

        return String.format("|Dados da Conta %d|\n", this.getNúmero()) +
                             "Titular: " + this.getTitular() + "\n" +
                             "CPF: " + this.getCPF() + "\n" +
                             "Saldo: " + formatoMoeda.format(this.getSaldo()) + "\n" +
                             String.format("%1$s %2$td de %2$tB de %2$tY às %2$tr",
                                    "Membro Desde: ", this.getDataDeCadastro() );
    }
}
