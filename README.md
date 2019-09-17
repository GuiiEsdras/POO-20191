# Programação Orientada à Objetos

<p align="center">
  <img src="http://arquivo.devmedia.com.br/marketing/img/programe-orientado-a-objetos.png" width="500" />
</p>

<h5 align="center"> Programando Orientado à Objetos!! </h5>

<!-- Links do Repositório -->
<p align="center">
    <a href="com Java">Com Java</a>
    ·
    <a href="com Kotlin">Com Kotlin</a>
    ·
    <a href="com Python">Com Python</a>
</p>
<!-- -->

<!-- Table of Contents -->
## Glossário
- [Programação Orientada à Objetos](#programa%c3%a7%c3%a3o-orientada-%c3%a0-objetos)
  - [Glossário](#gloss%c3%a1rio)
  - [Introdução](#introdu%c3%a7%c3%a3o)
  - [Material Utilizado](#material-utilizado)
    - [Sistema Operacional](#sistema-operacional)
    - [Compilador](#compilador)
    - [Interpretador](#interpretador)
    - [IDE's & Editor(es) de Texto](#ides--editores-de-texto)
    - [Ferramentas de UML](#ferramentas-de-uml)
  - [Programando em Java](#programando-em-java)
    - [Pré-Requisitos](#pr%c3%a9-requisitos)
    - [Executando .java pelo CMD](#executando-java-pelo-cmd)
    - [Empacontando arquivos .class em um .jar](#empacontando-arquivos-class-em-um-jar)
    - [Criando e Rodando Projetos com Maven](#criando-e-rodando-projetos-com-maven)
    - [Criando projeto Multi-Modular com Maven e intelliJ](#criando-projeto-multi-modular-com-maven-e-intellij)
    - [Criando Bateria de Testes com intelliJ](#criando-bateria-de-testes-com-intellij)
    - [Exemplo de Hello World](#exemplo-de-hello-world)
  - [Programando em Kotlin](#programando-em-kotlin)
  - [Programando em Python 3](#programando-em-python-3)
  - [Links Úteis](#links-%c3%9ateis)
  - [Autor](#autor)
  - [Licença](#licen%c3%a7a)
<!-- -->

<!-- Intro do Repo -->
## Introdução
Repositório criado com a finalidade de armazenar códigos e projetos referentes à disciplina de Programação Orientada à Objetos do curso de Engenharia de Computação.

*O curso é passado na linguagem Java. Os conteúdos produzidos em outras linguagens são de autoria própria. :)*
<!-- -->

<!-- Material Utilizado -->
## Material Utilizado
Estes são os materiais usados por mim para desenvolver e rodar meus programas em Java.
### Sistema Operacional
- [Windows 10](https://www.microsoft.com/pt-br/windows/)
### Compilador
- [Javac (Em Java Runtime Environment)](#Links-%C3%9Ateis)
### Interpretador
- [JVM (Java Virtual Machine)](#links-%c3%9ateis)
### IDE's & Editor(es) de Texto
- [Visual Studio Code](https://code.visualstudio.com/)
  - Com as extensões: <br/>
    [Maven for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-maven) <br/>
    [Debugger for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-debug) <br/>
    [Language Support for Java(TM)](https://marketplace.visualstudio.com/items?itemName=redhat.java) <br/>
    [Java Test Runner](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-test) <br/>
    [Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) <br/>
    [Java Dependency Viewer](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-dependency)
- [IntelliJ IDEA by JetBrains](https://www.jetbrains.com/idea/)
- [Android Studio](https://developer.android.com/studio)
- [Eclipse](https://www.eclipse.org/downloads/)
- [NetBeans](https://netbeans.org/features/java/index_pt_BR.html)
### Ferramentas de UML
- [LucidChart](https://www.lucidchart.com/)
- [Visual Paradigm](https://online.visual-paradigm.com/pt/)
<!-- -->

<!-- Programando em ... -->
## Programando em Java
O que foi necessário para criar e rodar meus programas em Java

### Pré-Requisitos
Para executar programas em **Java** é necessário ter o Java (JRE) instalado no computador.
Para desenvolver programas em **Java** é necessário ter o compilador JAVAC - incluso em um dos pacotes JDK (SE, EE, ME) - instalado no computador.

- Para verificar se o java e o javac estão instalados no PC, basta executar os comandos no CMD: <br/>
    `> java --version`
    `> javac --version`
> - Se os comandos não forem reconhecidos, **não está** instalado! *(ver [Links Úteis](#Links-%C3%9Ateis) para instalá-los)* <br/>
> - Caso exiba a versão, **está** instalado! <br/>

### Executando .java pelo CMD
Criando e executando um programa simples em Java pelo CMD

1. Para executar arquivos *.java* pelo terminal deve-se ter o Java JDK (Java Development Kit) devidamente instalado no PC. <br/>
   Para instalar, visitar o site oficial e seguir as intruções.  *(ver [Links Úteis](#Links-%C3%9Ateis))*

2. Após ter baixado e configurado o JDK, já será capaz de criar e executar programas Java no Windows.

- Para compilar programas *".java"* e executá-los no terminal/cmd:
  - Abrir pasta onde se localiza o arquivo main (principal) *.java*: <br/>
     `> cd "pasta do programa"`
  - Compilar o programa: <br/>
     `> javac "nome do programa".java`
  - Para executar: <br/>
     `> java "nome do programa"`
  
  - Exemplo: <br/>
     `> cd "C:\Users\Guilherme\Documentos\Meus Programas\Java\Programa Hello World\main" // Para ir até a pasta do arquivo main .java` <br/>
     `> javac HelloWorld.java // Para compilar o programa"` <br/>
     `> java HelloWorld // Para executar este programa`

### Empacontando arquivos .class em um .jar

1. Compilar o arquivo .class onde se encontra o main: <br/>
   `> javac "main".java`
2. Executar o comando: <br/>
   `> jar --create --file "nome desejado para o jar".jar --main-class "nome do class principal" "class principal".class "outras classes".class`
3. Para executar o jar: <br/>
   `> java -jar "nome do jar".jar`

Organizando em pastas:

1. Suponhando que existam 3 pastas: <br/>
    - bin *(Para armazenar os bytecodes .class)*
    - dist *(Para armazenar o(s) .jar)*
    - src *(Onde ficam os arquivos .java)*
2. Para compilar todos os arquivos .java da pasta src e enviar os bytecodes (.class) compilados para a pasta bin, executar o comando: <br/>
   `> javac -cp src -d ./bin src/*.java`
3. Para empacotar todas classes da pasta bin e gerar um .jar na pasta dist: <br/>
   `> jar --verbose --create --file dist/"nome desejado para o jar".jar --main-class HelloWorld -C bin .`
4. Para verificar os arquivos dentro do jar: <br/>
   `> jar -tf dist/"nome desejado para o jar".jar`
5. Para executar o jar: <br/>
   `> java -jar dist/"nome desejado para o jar".jar`

### Criando e Rodando Projetos com Maven

1. Criar a arquitetura de diretórias usando Maven CLI: <br/>
   `> mvn archetype:generate -DgroupId="nome do package" -DartifactId="nome do app"² -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false` <br/>
    - **"nome do package"** - Aqui fica o nome do diretório dos arquivos .java do projeto. (Exemplo: `br.com.br`)
    - **"nome do app"** - Aqui fica o nome da classe principal (main) e também da pasta principal do projeto (onde ficará o arquivo main). (Exemplo: *Conta*)
    - Exemplo de arquitetura de diretórios: <br/>
    `C:\Users\Guilherme\"nome do app"\src\main\java\"nome do package"\"nome do app".java` <- Classes principais <br/>
    `C:\Users\Guilherme\"nome do app"\src\test\java\"nome do package"\ContaTeste.java` <- Classes de Testes (Bateria de Testes)

2. Renomear arquivos App e AppTest para os nomes desejados usando Refactor / Do Refactor *(no intelliJ IDEA IDE)*
   
3. Editar o *pom.xml*:
   
   1. Acrescentar variáveis: <br/>
        ``` xml
        <description>A very important project here</description>

        <packaging>jar</packaging>
        ```

   2. Trocar a versão: <br/>
        de: <br/>
        ``` xml
        <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            <maven.compiler.source>1.7</maven.compiler.source>
            <maven.compiler.target>1.7</maven.compiler.target>
        </properties>
        ```
        para: <br/>
        ``` xml
        <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
            <java.version>11</java.version>
            <maven.compiler.source>${java.version}</maven.compiler.source>
            <maven.compiler.target>${java.version}</maven.compiler.target>
        </properties>
        ```
        
    3. Editar o plugin do jar, incluindo o main, para poder compilar: <br/>
        Para isso, alterar as linhas <br/>
        de: <br/>
        ``` xml
        <plugin>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.0.2</version>
        </plugin>
        ```
        para: <br/>
        ``` xml
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.0.2</version>
            <configuration>
                <archive>
                    <manifest>
                        <addClasspath>true</addClasspath>
                        <mainClass>br.com.bb.MainClass</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
        ```
        Onde "**br.com.bb.MainClass**" é o caminho (separado por .) da pasta onde se localiza o arquivo principal (main) do programa.

    4. Adicionar os plugins Sources:
        ``` xml
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-javadoc-plugin</artifactId>
            <version>3.0.1</version>
            <executions>
                <execution>
                    <id>attach-my-javadocs</id>
                    <phase>verify</phase>
                    <goals>
                        <goal>jar</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>

        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-source-plugin</artifactId>
            <version>3.0.1</version>
            <executions>
                <execution>
                    <id>attach-my-sources</id>
                    <phase>verify</phase>
                    <goals>
                        <goal>jar-no-fork</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
        ```

4. Para compilar o programa:
   - Usando plugin/extensão do Maven no intelliJ: <br/> Maven -> Compile
   - ou usando o terminal: <br/> `> mvn compile`
5. Para gerar o *.jar*:
   - Usando plugin/extensão do Maven no intelliJ: <br/> Maven -> Package
   - ou usando o terminal: <br/> `> mvn package`
6. Forma mais fácil e rápida para compilar e gerar o jar de uma só vez usando o terminal:
   - `> mvn compile package`
7. Para rodar o programa, executar o jar gerado na pasta *target*:
   - `> java -jar target/"app"-1.0-SNAPSHOT.jar` <br/>
    Onde **"app"** é o nome do arquivo/classe principal do programa.

### Criando projeto Multi-Modular com Maven e intelliJ

1. Criar um projeto normalmente usando o Maven 
   [*(ver)*](#criando-e-rodando-projetos-com-maven)
2. Apagar a pasta *src*
3. Ir até "Project Structure" no intelliJ
4. Navegar até a guia "Modules"
5. Remover as pastas apagadas na lista de pastas no lado direito da janela
6. Clicar no símbolo "+", em seguida "New Module":
   1. Next;
   2. Clicar nos "..." no lado superior direito;
   3. Selecionar o *parent* (pasta raiz do projeto);
   4. Digitar nome do Package e do Módulo, separando as palavras por "-".
   
7. Editar o *pom.xml* pai:
   1. Certificar-se de deixar este *pom.xml* com a seguinte estrutura: <br>
    ``` xml
    <?xml version="1.0" encoding="UTF-8"?>

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
        <modelVersion>4.0.0</modelVersion>

        <groupId>xx.xx.xx</groupId> <!-- Pacote principal do projeto -->
        <artifactId>"Nome do Projeto"</artifactId> <!-- Nome da past raiz do projeto -->
        <version>1.0-VERSÃO</version> <!-- Nome desejado para os .jar gerados -->
        <description>Descrição do Projeto - Guilherme Esdras</description> <!-- Descrição do projeto -->
        <packaging>pom</packaging> <!-- Necessário para o pom pai (parent) -->

        <!-- Módulos (Essa parte é criada automaticamente durante o processo) -->
        <modules>
            <!-- Todos os módulos criados do projeto -->
            <module>"modulo-tal"</module>
        </modules>

        <!-- Versão Local do java -->
        <properties>
            <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
            <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
            <java.version>11</java.version>
            <maven.compiler.source>${java.version}</maven.compiler.source>
            <maven.compiler.target>${java.version}</maven.compiler.target>
        </properties>

        <!-- Plugins, Reports e Dependencias -->
        <build>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-javadoc-plugin</artifactId>
                    <version>3.0.1</version>
                    <executions>
                        <execution>
                            <id>attach-my-javadocs</id>
                            <phase>verify</phase>
                            <goals>
                                <goal>jar</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-source-plugin</artifactId>
                    <version>3.0.1</version>
                    <executions>
                        <execution>
                            <id>attach-my-sources</id>
                            <phase>verify</phase>
                            <goals>
                                <goal>jar-no-fork</goal>
                            </goals>
                        </execution>
                    </executions>
                </plugin>

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-report-plugin</artifactId>
                    <version>3.0.0-M3</version>
                </plugin>

                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-site-plugin</artifactId>
                    <version>3.7.1</version>
                </plugin>            
            </plugins>
        </build>

        <reporting>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-report-plugin</artifactId>
                    <version>3.0.0-M3</version>
                </plugin>
            </plugins>
        </reporting>

        <dependencies>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
            </dependency>
        </dependencies>
    </project>
        
    </project>
    ```
8. Editar os *pom.xml* filhos:
   1. Se por acaso um módulo importar outro, adicionar o módulo nas dependências do pom que o importa:
    ``` xml
    <dependencies>
        <dependency>
            <groupId>br.edu.ifpb</groupId> <!-- Pacote principal -->
            <artifactId>modulo-tal</artifactId> <!-- Módulo dependente/importado -->
            <version>1.0-GUILHERME</version>
        </dependency>
    </dependencies>
    ```
    2. Para o módulo que contém o main, adicionar o plugin gerador de *fat jar* (jar contendo vários módulos dependentes):
    ``` xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>2.4.3</version>
                <executions>
                    <execution>
                        <id>create-fat-jar</id>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <!-- add Main-Class to manifest file -->
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <!-- Substituir pelo caminho e nome da classe Main -->
                                    <mainClass>br.edu.ifpb.cli.MainCLI</mainClass>
                                </transformer>
                            </transformers>
                            <!-- Nome desejado para o .jar final principal -->
                            <finalName>CLI</finalName>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
    ```
9. Para compilar e gerar os pacotes, seguir o mesmo processo de um projeto comum.
10. Para executar o projeto, gerar o .jar do main seguindo o passo 8.2 e executá-lo usando o comando java -jar.

### Criando Bateria de Testes com intelliJ

1. Criar os métodos vazios apenas definindo os parâmetros
2. Criar a bateria de testes no **"AppTest"** *(renomear)* (localizado na pasta test) de determinado método:
   - Code -> Generate... -> Test... <br/>
     ou <br/>
   - Botão direito -> Generate... -> Test...
3. Ir rodando testes primeiro, alterando e modificando os métodos depois.

### Exemplo de Hello World
``` Java
public class HelloWorld {

    public static void main(String[] args) {
        String mensagem1 = new HelloWorld().retornaMsg1();
        String mensagem2 = new HelloWorld().retornaMsg2();
        System.out.println(mensagem1 + mensagem2 + "=)");
    }

    public String retornaMsg1() {
        return "Hello, ";
    }

    public String retornaMsg2() {
        return "Gui! ";
    }

}
```

Saída: <br/>
`> Hello, Gui! =)`
<!-- -->

## Programando em Kotlin
[Ver repositório principal de Kotlin!](https://github.com/GuilhermeEsdras/Kronstadt)

## Programando em Python 3
[Ver repositório principal de Python 3!](https://github.com/GuilhermeEsdras/Mamba-3)

<!-- Links-->
## Links Úteis
- [Java™ SE (Standard Edition) Development Kit (JDK™) - Java JDK](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [Java Download](https://www.java.com/pt_BR/download/)
- [Visual Paradigm - Criação de Diagramas UML online](online.visual-paradigm.com/)
- [Repositório Principal de Java](https://github.com/GuilhermeEsdras/Coffe-Shop)
- [Repositório Principal de Kotlin](https://github.com/GuilhermeEsdras/Kronstadt)
- [Repositório Principal de Python 3](https://github.com/GuilhermeEsdras/Mamba-3)
<!-- -->

<!-- Autor/Contato -->
## Autor
* **Guilherme Esdras (guilherme.esdras@outlook.com)** - [GitHub Page](https://github.com/GuilhermeEsdras)
<!-- -->


<!-- Licença -->
## Licença
*Distributed under the MIT License. See LICENSE for more information.*