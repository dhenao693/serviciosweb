package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByDescription(String Descrition);
}
