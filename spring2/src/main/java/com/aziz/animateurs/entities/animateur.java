package com.aziz.animateurs.entities;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
public class animateur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idAnimateur;

@NotNull
@Size (min = 4,max = 35)
private String nomAnimateur;





@Temporal(TemporalType.DATE)
@DateTimeFormat(pattern = "yyyy-MM-dd")
@PastOrPresent
private Date dateConfirmation;

@ManyToOne
private tv tv;
public animateur() {
super();
}
public animateur(String nomAnimateur, Date dateConfirmation) {
super();
this.nomAnimateur = nomAnimateur;

this.dateConfirmation = dateConfirmation;
}


public Long getIdAnimateur() {
	return idAnimateur;
}
public void setIdAnimateur(Long idAnimateur) {
	this.idAnimateur = idAnimateur;
}
public String getNomAnimateur() {
	return nomAnimateur;
}
public void setNomAnimateur(String nomAnimateur) {
	this.nomAnimateur = nomAnimateur;
}
public Date getDateConfirmation() {
	return dateConfirmation;
}
public void setDateConfirmation(Date dateConfirmation) {
	this.dateConfirmation = dateConfirmation;
}


public tv getTv() {
	return tv;
}
public void setTv(tv tv) {
	this.tv = tv;
}
@Override
public String toString() {
	return "animateur [idAnimateur=" + idAnimateur + ", nomAnimateur=" + nomAnimateur + ", dateConfirmation="
			+ dateConfirmation + ", tv=" + tv + "]";
}

}
