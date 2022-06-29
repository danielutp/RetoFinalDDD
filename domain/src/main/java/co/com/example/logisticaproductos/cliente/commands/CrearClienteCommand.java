package co.com.example.logisticaproductos.cliente.commands;

import co.com.example.logisticaproductos.cliente.values.*;
import co.com.sofka.domain.generic.Command;

public class CrearClienteCommand extends Command {

    private final ClienteId clienteId;
    private final DatosUsuario datosUsuario;
    private final Rol rol;
    private final TipoSuscripcion tipoSuscripcion;

    public CrearClienteCommand(ClienteId clienteId, DatosUsuario datosUsuario, Rol rol, TipoSuscripcion tipoSuscripcion) {
        this.clienteId = clienteId;
        this.datosUsuario = datosUsuario;
        this.rol = rol;
        this.tipoSuscripcion = tipoSuscripcion;
    }

    public TipoSuscripcion getTipoSuscripcion() {
        return tipoSuscripcion;
    }

    public Rol getRol() {
        return rol;
    }

    public DatosUsuario getDatosUsuario() {
        return datosUsuario;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
