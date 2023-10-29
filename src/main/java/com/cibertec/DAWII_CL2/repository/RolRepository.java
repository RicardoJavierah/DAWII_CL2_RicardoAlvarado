package com.cibertec.DAWII_CL2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cibertec.DAWII_CL2.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nombrerol);
}
