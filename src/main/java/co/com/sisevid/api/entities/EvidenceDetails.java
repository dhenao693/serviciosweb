package co.com.sisevid.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "evidencia_detalle")
@Data
@NoArgsConstructor
public class EvidenceDetails {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name ="ID_EVIDENCIA_DETALLE")
    private long id;

    @Column(name ="ID_EVIDENCIA")
    private String evidenceId;

    @Column(name ="USUARIO_MODIFICACION")
    private String userUpdate;

    @Column(name ="FECHA_MODIFICACION")
    private String dateUpdate;

    @Column(name ="ESTADO")
    private String status;

    @Column(name ="ACTIVO")
    private String active;
}
