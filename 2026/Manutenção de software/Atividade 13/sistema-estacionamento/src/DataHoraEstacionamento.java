package br.edu.refactoring.estacionamento;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class DataHoraEstacionamento {

    private final LocalDateTime dataHora;

    public DataHoraEstacionamento(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String formatarDataHora() {
        return dataHora.getDayOfMonth() + "/"
                + dataHora.getMonthValue() + "/"
                + dataHora.getYear() + " "
                + dataHora.getHour() + ":"
                + String.format("%02d", dataHora.getMinute());
    }

    public boolean isHorarioEspecial() {
        return dataHora.getDayOfWeek() == DayOfWeek.SATURDAY
                || dataHora.getDayOfWeek() == DayOfWeek.SUNDAY
                || dataHora.getHour() < 7
                || dataHora.getHour() >= 22;
    }
}
