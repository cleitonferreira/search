package br.com.desafio.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "bike")
@Data @EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bike implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String distance;
	@Enumerated(EnumType.STRING)
	private Modality modality = Modality.NONE;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "accessory_bike", joinColumns = @JoinColumn(name = "id_bike")
		, inverseJoinColumns = @JoinColumn(name = "id_accessory"))
	private List<Accessory> accessories;
	
}
