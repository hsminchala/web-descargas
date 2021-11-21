import com.sebastian.web.model.UsuarioModel
import org.jboss.jandex.TypeTarget
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository:JpaRepository<UsuarioModel, Long> {
    //interface WorkoutRepository:JpaRepository<Workout, Long> {}
}