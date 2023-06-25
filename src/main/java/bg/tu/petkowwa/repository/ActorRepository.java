package bg.tu.petkowwa.repository;

import bg.tu.petkowwa.model.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {

  Optional<ActorEntity> findActorEntityByName(String name);
}
