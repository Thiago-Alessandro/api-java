package net.weg.api.repository;

import net.weg.api.model.Seguro;
import net.weg.api.model.SeguroId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeguroRepository extends JpaRepository<Seguro, SeguroId> {
}
