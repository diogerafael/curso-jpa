package br.com.alura.loja.modelo;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="departamento")
public class Departamento {
    
    @EmbeddedId
    private DepartamentoPK departamentoPK;

    public Departamento() {
    }

    public Departamento(final DepartamentoPK departamentoPK) {
        this.departamentoPK = departamentoPK;
    }
}
