package org.iclub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.iclub.model.Sponsor;
import org.iclub.repository.SponsorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SponsorServiceImpl implements SponsorService {

	private final SponsorRepository sponsorRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(SponsorServiceImpl.class);

	@Autowired
	public SponsorServiceImpl(SponsorRepository sponsorRepository) {
		this.sponsorRepository = sponsorRepository;
	}

	@Override
	public Sponsor save(Sponsor sponsor) {
		return sponsorRepository.save(sponsor);
	}

	@Override
	public void delete(Long id) {
		LOGGER.debug("Delete " + id);
		sponsorRepository.delete(id);
	}
	
	@Override
	public List<Sponsor> findAll() {
		LOGGER.debug("Find All");
		return sponsorRepository.findAll();
	}
}
