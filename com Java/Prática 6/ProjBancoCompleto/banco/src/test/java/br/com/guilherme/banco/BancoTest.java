package br.com.guilherme.banco;

import br.com.guilherme.contacorrente.ContaCorrente;

// JUnit
import org.junit.Test;
import org.junit.Assert;

// Hamcrest
import java.util.Date;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class BancoTest {
    static final ContaCorrente contaCorrenteUm = new ContaCorrente("Conta Um", "123", 1500);
    static final ContaCorrente contaCorrenteDois = new ContaCorrente("Conta Dois", "123", 800);
    static final ContaCorrente contaCorrenteTrês = new ContaCorrente("Conta Tres", "123", 300);

    private Banco banco = new Banco();

    @Test
    public void testDeveAdicionarContaCorrente() {
        // Dado que... (foram adicionadas 2 contas)
        banco.adicionaConta( contaCorrenteUm );
        banco.adicionaConta( contaCorrenteDois );

        // então... (certifique-se de que a lista de contas do banco contém as duas contas adicionadas)
        assertThat( banco.getListaDeContasCorrente(), containsInAnyOrder( contaCorrenteUm, contaCorrenteDois) );
        assertThat( banco.quantidadeDeContas(), equalTo( 2 ));
    }

    @Test
    public void testDeveRemoverContaCorrente() {
        // Dado que... (existam 3 contas)
        banco.adicionaConta( contaCorrenteUm );
        banco.adicionaConta( contaCorrenteDois );
        banco.adicionaConta( contaCorrenteTrês );

        // quando... (remover uma conta)
        banco.removeConta( contaCorrenteDois.getNúmero() );

        // então... (certifique-se de que a lista de contas do banco não contém mais a conta removida)
        assertThat( banco.getListaDeContasCorrente(), not( containsInAnyOrder( contaCorrenteDois ) ) );
    }
}