package br.com.guilherme.servidor;

import br.com.guilherme.interfaces.ObjetoRemotoSignos_IF;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MainServidor {
    public static void main(String[] args) {

        try {
            ServidorDeSignos servidorDeSignos = new ServidorDeSignos();
            ObjetoRemotoSignos_IF stub = (ObjetoRemotoSignos_IF) UnicastRemoteObject.exportObject(servidorDeSignos, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Frase do Signo", stub);

            System.err.println("Servidor pronto!");
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.toString());
            e.printStackTrace();
        }

    }
}
