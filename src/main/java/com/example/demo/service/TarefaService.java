package com.example.demo.service;

import com.example.demo.model.Tarefa;
import com.example.demo.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public  TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> listarTarefas(){
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public Tarefa salvarTarefa(Tarefa tarefa){
        return  tarefaRepository.save(tarefa);
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }

    public Optional<Tarefa> alterarTarefa(Long id, Tarefa tarefa){

        Optional<Tarefa> tarefaEncontrada = tarefaRepository.findById(id);

        Tarefa tarefaAtualizada = tarefaEncontrada.get();
        tarefaAtualizada.setNome(tarefa.getNome());
        tarefaAtualizada.setDescricao(tarefa.getDescricao());
        tarefaAtualizada.setStatus(tarefa.getStatus());

        tarefaRepository.save(tarefaAtualizada);

        return tarefaRepository.findById(id);

    }

    public Optional<Tarefa> alterarStatus(Long id){

        Optional<Tarefa> tarefaEncontrada = tarefaRepository.findById(id);

        Tarefa tarefa = tarefaEncontrada.get();

        if (tarefa.getStatus() == true){
            tarefa.setStatus(false);
        }else {
            tarefa.setStatus(true);
        }

        tarefaRepository.save(tarefa);

        return tarefaRepository.findById(id);

    }
}
