package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;


    public String getNome() {return this.nome;}
    public Double getMultaDiaria() {return this.multaDiaria;}
    public Integer getQtdLivros(){return this.qtdLivros;}
    public Boolean getAtiva(){return this.ativa;}

    public void setNome(String nome){this.nome = nome;}

    public Biblioteca(String nome, Double multaDiaria) {
        setNome(nome);
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }



    public void registrarLivro(Integer quantidade){
        if (ativa == true) {
            if (quantidade != null && quantidade > 0) {
                qtdLivros += quantidade;
                System.out.println("Livros adicionados com sucesso.");

            } else {
                System.out.println("Quantiade inválida.");
            }
        } else {
            System.out.println("A biblioteca está desativada. Impossível registrar livros.");
        }
    }



    public Integer emprestar(Integer quantidade) {
        if (getAtiva() == true) {
            if (quantidade != null && quantidade > 0 && quantidade <= qtdLivros){

                qtdLivros -= quantidade;
                System.out.println("Livros foram empestados com sucesso.");
                return quantidade;

            } else {
                System.out.println("Quantidade inválida.");
                return null;
            }
        } else {
            System.out.println("A biblioteca está desativada. Impossível emprestar livros.");
            return null;
        }
    }



    public Integer devolver(Integer quantidade) {
        if (getAtiva() == true) {
            if (quantidade != null && quantidade > 0) {
                qtdLivros += quantidade;
                System.out.println("Livros devolvidos com sucesso.");
                return quantidade;
            } else {
                System.out.println("Quantidade de livros inválidas.");
                return null;
            }
        } else {
            System.out.println("A biblioteca está desativada. Impossível devolver livros.");
            return null;
        }
    }



    public Integer desativar() {
        if (getAtiva() == true) {
            Integer quantidadeAnterior = qtdLivros;
            ativa = false;
            qtdLivros = 0;
            System.out.println("A Biblioteca foi desativada com sucesso. Livros contidos antes de desativar: " + quantidadeAnterior);
            return quantidadeAnterior;


        } else {
            System.out.println("A biblioteca já está desativada.");
            return null;
        }
    }



    public void transferir(Biblioteca destino, Integer quantidade) {
        if (getAtiva() == true && destino.getAtiva() == true) {
            if (quantidade != null && quantidade <= qtdLivros) {

                qtdLivros -= quantidade;
                destino.qtdLivros += quantidade;

                System.out.println("Os livros foram transferidos com sucesso.");
                System.out.println("Seus livros atuais: " + qtdLivros);
                System.out.println("Livros do destinatário: " + destino.qtdLivros);

            }
        }
    }



    public Boolean reajustarMulta(Double percentual) {
        if (percentual != null && percentual > 0) {

            multaDiaria += (percentual * multaDiaria);

            System.out.println("O Reajuste foi realizado com sucesso. Foi aumentado " + (percentual * 100) + "%. Multa diária atual: " + getMultaDiaria() + "%");
            return true;
        } else {
            System.out.println("O valor percentual é inválido.");
            return false;
        }
    }
}
