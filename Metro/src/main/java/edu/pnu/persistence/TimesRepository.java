package edu.pnu.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.pnu.domain.Times;

public interface TimesRepository extends JpaRepository<Times, Long> {


}
