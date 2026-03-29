package controller;

import model.Evento;
import util.FileUtil;

import java.time.LocalDateTime;
import java.util.*;

public class EventoController {

    private List<Evento> eventos = new ArrayList<>();

    public void cadastrar(Evento evento) {
        eventos.add(evento);
    }

    public List<Evento> listarOrdenados() {
        eventos.sort(Comparator.comparing(Evento::getHorario));
        return eventos;
    }

    public String status(Evento e) {
        LocalDateTime agora = LocalDateTime.now();

        if (e.getHorario().isBefore(agora)) return "PASSADO";
        if (e.getHorario().isEqual(agora)) return "AGORA";
        return "FUTURO";
    }

    public void salvar() {
        FileUtil.salvar(eventos);
    }

    public void carregar() {
        eventos = FileUtil.carregar();
    }
}
