package Exercicio9;

public class Exercicio9 {
    public static void main(String[] args) {

        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa1 = new Pessoa(90L, "guilherme4", "478178142123");
        Pessoa pessoa2 = new Pessoa(5L, "wellington5", "478178142321");
        Pessoa pessoa3 = new Pessoa(6L, "wellington6", "47817814232121");

        pessoaDAO.create("contato90", pessoa1);
        //pessoaDAO.create("contatos:", pessoa2);
        //pessoaDAO.create("contatos:", pessoa3);


        /*Pessoa contatoConsultado = pessoaDAO.read("contatos:", pessoa3.id());
        System.out.println("Consultado: " + contatoConsultado);

        System.out.println("Deletando contato:" + contatoConsultado);
        pessoaDAO.delete("contatos:" + contatoConsultado.id().toString());*/
    }
}
