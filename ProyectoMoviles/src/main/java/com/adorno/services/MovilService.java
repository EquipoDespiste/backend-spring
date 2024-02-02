package com.adorno.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.adorno.criterio.Criterio;
import com.adorno.criterio.CriterioBoolean;
import com.adorno.criterio.CriterioIntervaloDecimal;
import com.adorno.criterio.CriterioIntervaloEntero;
import com.adorno.criterio.CriterioMarca;
import com.adorno.criterio.CriterioPantalla;
import com.adorno.filtros.Filtro;
import com.adorno.filtros.FiltroMarca;
import com.adorno.filtros.FiltroNFC;
import com.adorno.filtros.FiltroPantallaTech;
import com.adorno.filtros.FiltroPrecio;
import com.adorno.filtros.FiltroRam;
import com.adorno.modelo.Movil;
import com.adorno.modelo.MovilRequest;
import com.adorno.modelo.dto.MovilDetalladoDTO;
import com.adorno.modelo.dto.MovilResumenDTO;
import com.adorno.modelo.mapper.MovilDetalladoDTOMapper;
import com.adorno.modelo.mapper.MovilResumenDTOMapper;
import com.adorno.repositorio.IMarcaRepositorio;
import com.adorno.repositorio.IMovilRepositorio;

@Service

public class MovilService implements Services<Movil> {

	private final IMovilRepositorio movilRepo;
	private final IMarcaRepositorio marcaRepo;
	private final MovilResumenDTOMapper movilResumenDTOMapper;
	private final MovilDetalladoDTOMapper movilDetalladoDTOMapper;

	public MovilService(IMovilRepositorio movilRepo, IMarcaRepositorio marcaRepo,
			MovilResumenDTOMapper movilResumenDTOMapper, MovilDetalladoDTOMapper movilDetalladoDTOMapper) {
		super();
		this.movilRepo = movilRepo;
		this.marcaRepo = marcaRepo;
		this.movilResumenDTOMapper = movilResumenDTOMapper;
		this.movilDetalladoDTOMapper = movilDetalladoDTOMapper;
	}

	@Override
	public boolean add(Movil movil) {
		Marca marca = marcaRepo.findByNombreIgnoreCase(movil.getNombreMarca());
//		System.err.println(marca.toString());
		movil.setMarca(marca);
		return movilRepo.save(movil) != null;
	}

	@Override
	public boolean delete(long id) {
		boolean retorno = movilRepo.findById(id).isPresent();
		if (retorno) {
			movilRepo.findById(id).ifPresent((movil) -> {
				movilRepo.delete(movil);
			});
		}

		return retorno;
	}

	@Override
	public Optional<Movil> getById(long id) {
		return movilRepo.findById(id);
	}

	@Override
	public List<Movil> findAll() {
		return movilRepo.findAll();
	}

	@Override
	// devuelvo true porque funciona y porque no hay otro metodo
	public boolean addAll(List<Movil> moviles) {
		moviles.stream().forEach((movil) -> {
			Marca marca = marcaRepo.findByNombreIgnoreCase(movil.getNombreMarca());
//			System.err.println(marca.toString());
			movil.setMarca(marca);
			movilRepo.save(movil);
		});
		return true;
	}

	public Boolean update(Movil update) {
		Optional<Movil> movil = this.movilRepo.findById(update.getId());
		if(movil.isPresent()) {
			//Habria que validar los cambios ? ?? 
			this.movilRepo.save(update);
			return true;
		}
		return false;
	}
	
	public List<Movil> findByMarca(String marca) {
		List<Marca> all = marcaRepo.findAll();
		Marca byNombreIgnoreCase = marcaRepo.findByNombreIgnoreCase(marca);
		List<Movil> allByMarca = movilRepo.findAllByMarca(byNombreIgnoreCase);
		
		return allByMarca;

	}

	public List<Movil> findByNfc(boolean nfc) {
		return movilRepo.findByNfc(nfc);
	}

	public MovilResumenDTO getByIdResumen(long id) {
		return movilResumenDTOMapper.mapToDTO(getById(id).get());
	}

	public List<MovilResumenDTO> findAllResumen() {
		return findAll().stream().map((movil) -> {
			return movilResumenDTOMapper.mapToDTO(movil);
		}).collect(Collectors.toList());
	}

	public List<MovilResumenDTO> getByMarcaResumen(MovilRequest request) {
		// Marca marca = this.marcaRepo.findByNombreIgnoreCase(request.getMarca());

		List<Movil> moviles = this.movilRepo.findAll();

		moviles.forEach(m -> System.out.println(m.toString()));

		List<Filtro<Movil>> filtros = loadFilters(request);

		for (Filtro<Movil> filtro : filtros) {
			moviles = moviles.stream().filter(m -> {
				return filtro.filter(m);
			}).collect(Collectors.toList());
		}
		return mapListaFiltrados(moviles);
	}

	private List<Filtro<Movil>> loadFilters(MovilRequest request) {
		List<Filtro<Movil>> filtros = new ArrayList<>();

		Criterio<String> criterioMarca = new CriterioMarca(request.getMarca());
		Criterio<Float> criterioPrecio = new CriterioIntervaloDecimal(request.getPrecioMin(), request.getPrecioMax());
		Criterio<Integer> criterioRam = new CriterioIntervaloEntero(request.getRamMin(), request.getRamMax());
		Criterio<Boolean> criterioNFC = new CriterioBoolean(request.getNfc());
		Criterio<String> criterioPantalla = new CriterioPantalla(request.getTecnologiaPantalla());

		filtros.add(new FiltroMarca(criterioMarca));
		filtros.add(new FiltroPrecio(criterioPrecio));
		filtros.add(new FiltroRam(criterioRam));
		filtros.add(new FiltroNFC(criterioNFC));
		filtros.add(new FiltroPantallaTech(criterioPantalla));

		return filtros;
	}

	public List<MovilResumenDTO> comparar(long id1, long id2) {

		List<MovilResumenDTO> moviles = new ArrayList<>();

		moviles.add(movilResumenDTOMapper.mapToDTO(movilRepo.findById(id1).get()));
		moviles.add(movilResumenDTOMapper.mapToDTO(movilRepo.findById(id2).get()));

		return moviles;
	}

	public List<MovilResumenDTO> getTopMoviles() {
		List<Movil> moviles = this.movilRepo.findAll().stream().sorted((movil1, movil2) -> {
			return Integer.valueOf(movil1.getContador_visita()).compareTo(movil2.getContador_visita()) * -1;
		}).limit(5).collect(Collectors.toList());
		moviles.forEach(m -> System.out.println(m.getModelo() + "- " + m.getContador_visita()));

		return mapListaFiltrados(moviles);
	}

	public List<MovilResumenDTO> mapListaFiltrados(List<Movil> filtrados) {
		List<MovilResumenDTO> filtradosResumen = new ArrayList<>();
		filtrados.forEach((movil) -> {
			filtradosResumen.add(movilResumenDTOMapper.mapToDTO(movil));
		});

		return filtradosResumen;
	}

	public MovilDetalladoDTO detallarMovil(MovilResumenDTO dto) {
		Movil movil = new Movil();

		movil = movilRepo.findAll().stream().filter(m -> {
			return m.getNombreMarca().equals(dto.getMarca()) && m.getModelo().equals(dto.getModelo())
					&& m.getAlmacenamiento_gb() == dto.getAlmacenamiento_gb() && m.getRam() == dto.getRam()
					&& m.getPrecio_actual() == dto.getPrecio()
					&& m.getNucleosProcesador() == dto.getNucleosProcesador();
		}).findFirst().get();

		return movilDetalladoDTOMapper.mapToDTO(movil);
	}
}
