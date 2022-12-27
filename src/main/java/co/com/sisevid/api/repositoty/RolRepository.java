package co.com.sisevid.api.repositoty;

import co.com.sisevid.api.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
    Rol findByDescription(String Descrition);
}
