package org.iclub.service;

import java.util.List;

import org.iclub.model.Sponsor;

public interface SponsorService {

  public Sponsor save(Sponsor sponsor);
  public void delete(Long id);
  List<Sponsor> findAll();

}
