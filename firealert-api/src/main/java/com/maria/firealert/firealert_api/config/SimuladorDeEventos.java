package com.maria.firealert.firealert_api.config;

import com.maria.firealert.firealert_api.model.*;
import com.maria.firealert.firealert_api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Random;

@Component
public class SimuladorDeEventos {

    @Autowired
    private SensorService sensorService;

    @Autowired
    private PontoDeFocoService focoService;

    @Autowired
    private AlertaService alertaService;

    @Autowired
    private AgenteAmbientalService agenteAmbientalService;

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @Autowired
    private NotificacaoService notificacaoService;

    private final Random random = new Random();
    private int execucoes = 0;
    private final int LIMITE_EXECUCOES = 3;

    @PostConstruct
    public void gerarSensoresIniciais() {
        for (int i = 1; i <= 3; i++) {
            Sensor sensor = new Sensor();
            sensor.setTipo("fumaça");
            sensor.setLatitude("-23.55" + i);
            sensor.setLongitude("-46.63" + i);
            sensor.setAtivo(true);
            sensorService.salvar(sensor);
        }
        System.out.println("✅ Sensores iniciais criados.");
    }

    @PostConstruct
    public void gerarAgentesIniciais() {
        if (agenteAmbientalService.listarTodos().isEmpty()) {

            String[] nomes = { "João", "Ana", "Carlos", "Beatriz", "Marcos", "Larissa" };
            String[] sobrenomes = { "Silva", "Oliveira", "Souza", "Pereira", "Almeida", "Fernandes" };
            String[] areas = { "Parque Nacional", "Zona Rural", "Reserva Florestal", "Serra do Mar", "Cerrado", "Mata Atlântica" };

            for (int i = 1; i <= 3; i++) {
                String nomeCompleto = nomes[random.nextInt(nomes.length)] + " " +
                        sobrenomes[random.nextInt(sobrenomes.length)];

                AgenteAmbiental agente = new AgenteAmbiental();
                agente.setNome(nomeCompleto);
                agente.setEmail(nomeCompleto.toLowerCase().replace(" ", ".") + "@gov.br");
                agente.setMatricula(String.format("AG%03d", i));
                agente.setAreaAtuacao(areas[random.nextInt(areas.length)]);

                agenteAmbientalService.salvar(agente);
            }

            System.out.println("👮‍♂️ Agentes com dados aleatórios criados.");
        } else {
            System.out.println("ℹ️ Agentes já estavam cadastrados.");
        }
    }

    @Scheduled(fixedRate = 60000) // a cada 60 segundos
    public void gerarPontoDeFocoSimulado() {
        if (execucoes >= LIMITE_EXECUCOES) {
            System.out.println("⏹️ Limite de execuções atingido. Simulação finalizada.");
            return;
        }
        execucoes++;

        var sensores = sensorService.listarTodos();
        if (sensores.isEmpty()) return;

        Sensor sensorAleatorio = sensores.get(random.nextInt(sensores.size()));
        double intensidade = 3 + (random.nextDouble() * 5); // entre 3.0 e 8.0

        PontoDeFoco foco = new PontoDeFoco();
        foco.setSensor(sensorAleatorio);
        foco.setLatitude(sensorAleatorio.getLatitude());
        foco.setLongitude(sensorAleatorio.getLongitude());
        foco.setIntensidade(intensidade);
        foco.setDataHora(LocalDateTime.now());
        foco = focoService.salvar(foco);

        System.out.println("🔥 Ponto de foco criado: Intensidade " + String.format("%.2f", intensidade));

        if (intensidade < 5.0) {
            System.out.println("✅ Foco leve. Nenhuma ação necessária.");
            registrarNotificacao("leve", "Foco leve ignorado", foco);

        } else if (intensidade >= 5.0 && intensidade <= 7.0) {
            System.out.println("🚁 Foco moderado. Enviar drone.");
            registrarNotificacao("moderada", "Drone enviado para foco moderado", foco);

        } else {
            Alerta alerta = new Alerta();
            alerta.setMensagem("⚠️ Foco crítico detectado! Ação urgente necessária.");
            alerta.setDataEmissao(LocalDateTime.now());
            alerta.setStatus("ativo");
            alerta.setPontoDeFoco(foco);
            alerta = alertaService.salvar(alerta);

            var agentes = agenteAmbientalService.listarTodos();

            if (!agentes.isEmpty()) {
                Ocorrencia ocorrencia = new Ocorrencia();
                ocorrencia.setDataAtendimento(LocalDateTime.now());
                ocorrencia.setObservacoes("Intervenção automática por foco crítico.");
                ocorrencia.setAlerta(alerta);
                ocorrencia.setAgente(agentes.get(random.nextInt(agentes.size())));
                ocorrenciaService.salvar(ocorrencia);

                System.out.println("🚨 Ocorrência registrada com agente.");
                registrarNotificacao("critica", "Agente designado para foco crítico", foco);
            } else {
                System.out.println("⚠️ Alerta gerado, mas nenhum agente disponível.");
                registrarNotificacao("critica", "Foco crítico sem agente disponível", foco);
            }
        }
    }

    private void registrarNotificacao(String tipo, String mensagem, PontoDeFoco foco) {
        Notificacao notificacao = new Notificacao();
        notificacao.setTipo(tipo);
        notificacao.setMensagem(mensagem);
        notificacao.setDataHora(LocalDateTime.now());
        notificacao.setPontoDeFoco(foco);
        notificacaoService.salvar(notificacao);
    }
}


