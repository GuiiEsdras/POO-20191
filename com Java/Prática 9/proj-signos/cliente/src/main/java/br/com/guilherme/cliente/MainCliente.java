package br.com.guilherme.cliente;

public class MainCliente {
    public static void main(String[] args) {

        String host = (args.length < 1) ? "localhost" : args[0];
        String umSigno = args[1];
        Cliente cliente = new Cliente();
        cliente.executarCliente(host, umSigno);

    }
}
