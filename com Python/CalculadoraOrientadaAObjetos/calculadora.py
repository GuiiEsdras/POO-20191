class Calculadora:

    # Construtor da classe:
    def __init__(self):

        # __ indica que o atributo é fortemente privado, ou seja, só pode ser acessado dentro da classe
        self.__num1 = None
        self.__num2 = None

    def ler_numeros(self):
        self.__num1 = float(input('Digite um número: '))
        self.__num2 = float(input('Digite outro número: '))

    def adicao(self):
        soma = self.__num1 + self.__num2
        return soma

    def subtracao(self):
        sub = self.__num1 - self.__num2
        return sub

    def multiplicacao(self):
        mult = self.__num1 * self.__num2
        return mult

    def divisao(self):
        div = self.__num1 / self.__num2
        return div