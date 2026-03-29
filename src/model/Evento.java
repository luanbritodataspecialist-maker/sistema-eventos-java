package model;

import java.time.LocalDateTime;

public class Evento {
    private String nome;
    private String endereco;
    private String categoria;
    private LocalDateTime horario;
    private String descricao;

    public Evento(String nome, String endereco, String categoria, LocalDateTime horario, String descricao) {
        this.nome = nome;
        this.endereco = endereco;
        this.categoria = categoria;
        this.horario = horario;
        this.descricao = descricao;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public String getNome() {
        return nome;
    }

    public String toFile() {
        return nome + ";" + endereco + ";" + categoria + ";" + horario + ";" + descricao;
    }

    public static Evento fromFile(String linha) {
        String[] p = linha.split(";");
        return new Evento(p[0], p[1], p[2], LocalDateTime.parse(p[3]), p[4]);
    }
}
