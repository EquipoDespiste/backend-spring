package com.adorno.modelo.sql;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dimension {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private float alto;
	private float ancho;
	private float grosor;
	
	public Dimension(float alto, float ancho, float grosor) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.grosor = grosor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dimension other = (Dimension) obj;
		return Float.floatToIntBits(alto) == Float.floatToIntBits(other.alto)
				&& Float.floatToIntBits(ancho) == Float.floatToIntBits(other.ancho)
				&& Float.floatToIntBits(grosor) == Float.floatToIntBits(other.grosor);
	}

	@Override
	public int hashCode() {
		return Objects.hash(alto, ancho, grosor);
	}

	
	
	
	

}
