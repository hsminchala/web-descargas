import com.sebastian.web.model.UsuarioModel
import com.sebastian.web.service.UsuarioService
import org.apache.catalina.startup.ExpandWar.delete
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class UsuarioController {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping
    fun list(): List<UsuarioModel>{
        return usuarioService.list()
    }

    @PutMapping
    fun update (@RequestBody usuarioModel:UsuarioModel):UsuarioModel{
        return UsuarioService.update(usuarioModel)
    }

    @PatchMapping
    fun patch(@RequestBody usuario: UsuarioModel):UsuarioModel{
        return UsuarioService.updateWeight(usuario)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean{
        return UsuarioService.delete(id)
    }
}