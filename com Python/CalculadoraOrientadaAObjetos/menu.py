from calculadora import Calculadora


class Menu:
    def __init__(self):
        self.__calc = Calculadora()

    def exibir_menu(self):
        print('Bem Vindo a Calculadora Orientada a Objetos!')

        while True:
            op = int(input('Escolha uma das opções abaixo: \n'
                           '    1 - Soma\n'
                           '    2 - Subtração\n'
                           '    3 - Multiplicação\n'
                           '    4 - Divisão\n'
                           '    0 - Sair\n'
                           '        Opção: '))

            if op == 0:
                break

            elif op > 4 or op < 0:
                print('Digite uma opção válida!')

            else:
                self.__calc.ler_numeros()

                if op == 1:
                    print("Resultado: ", self.__calc.adicao())

                elif op == 2:
                    print("Resultado: ", self.__calc.subtracao())

                elif op == 3:
                    print("Resultado: ", self.__calc.multiplicacao())

                elif op == 4:
                    print("Resultado: ", self.__calc.divisao())