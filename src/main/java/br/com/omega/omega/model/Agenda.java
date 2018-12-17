package br.com.omega.omega.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Agenda implements Serializable {

    private static final long serialVersionUID=1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    @Column(name="data_atendimento")
    private Date data;
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    @ManyToOne//anotação de muitos para 1
    private Pessoa paciente;
    @ManyToOne
    private Profissional psicologo;

    public Profissional getPsicologo() {
        return psicologo;
    }

    public void setPsicologo(Profissional psicologo) {
        this.psicologo = psicologo;
    }

    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Pessoa getPaciente() {
        return paciente;
    }

    public void setPaciente(Pessoa paciente) {
        this.paciente = paciente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
