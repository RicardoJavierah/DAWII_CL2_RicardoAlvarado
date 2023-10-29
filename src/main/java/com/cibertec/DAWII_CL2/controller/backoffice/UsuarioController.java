package com.cibertec.DAWII_CL2.controller.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsuarioController {
    @PostMapping("/guardar")
    @ResponseBody
    public ResultadoResponse guardarGuardar(
            @RequestBody UsuarioRequest usuarioRequest
    ){
        return usuarioService.guardarProducto(usuarioRequestRequest);
    }
}
