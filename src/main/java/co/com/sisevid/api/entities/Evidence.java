package co.com.sisevid.api.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "EVIDENCIA")
@Data
@NoArgsConstructor
public class Evidence {
    @Id
    @GenericGenerator(name = "SEQ_VALOR", strategy = "increment")
    @GeneratedValue(generator = "SEQ_VALOR")
    @Column(name = "ID_EVIDENCIA")
    private long id;

    @Column(name = "TITULO")
    private String title;

    @Column(name = "DESCRIPCIÓN")
    private String description;

    @Column(name = "TIPO")
    private String type;

    @Column(name = "TIPO_ARCHIVO")
    private String typeFile;

    @Column(name = "FECHA_CREACION_EVIDENCIA")
    private String evidenceCreationDate;

    @Column(name = "FECHA_REGISTRO_EVIDENCIA")
    private String evidenceRegisterDate;

    @Column(name = "AUTORES")
    private String authors;

    @Column(name = "OBSERVACION")
    private String observation;

    @Column(name = "USUARIO_CREACION")
    private String userCreate;

    @Column(name = "FECHA_CREACION")
    private String creationDate;
}
