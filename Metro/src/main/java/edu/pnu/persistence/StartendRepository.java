package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Startend;

public interface StartendRepository extends JpaRepository<Startend, String> {

}
