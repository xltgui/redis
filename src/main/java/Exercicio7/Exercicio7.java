package Exercicio7;

public class Exercicio7 {
    public static void main(String[] args) {

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa1 = new Pessoa(1L, "guilherme", "478178142123");
        Pessoa pessoa2 = new Pessoa(2L, "wellington", "478178142321");
        Pessoa pessoa3 = new Pessoa(3L, "wellington3", "47817814232121");

        pessoaDAO.create("contatos:", pessoa1);
        pessoaDAO.create("contatos:", pessoa2);
        pessoaDAO.create("contatos:", pessoa3);


        Pessoa contatoConsultado = pessoaDAO.read("contatos:", pessoa3.id());
        System.out.println("Consultado: " + contatoConsultado);
    }
}
