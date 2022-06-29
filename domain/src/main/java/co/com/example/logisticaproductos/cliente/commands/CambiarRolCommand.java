package co.com.example.logisticaproductos.cliente.commands;
import co.com.example.logisticaproductos.cliente.values.ClienteId;
import co.com.example.logisticaproductos.cliente.values.CuentaId;
import co.com.example.logisticaproductos.cliente.values.Rol;
import co.com.sofka.domain.generic.Command;

public class CambiarRolCommand extends Command {
    private final ClienteId clienteId;
    private final CuentaId cuentaId;
    private final Rol rolCuenta;

    public CambiarRolCommand(ClienteId clienteId, CuentaId cuentaId, Rol rolCuenta) {
        this.clienteId = clienteId;
        this.cuentaId = cuentaId;
        this.rolCuenta = rolCuenta;
    }

    public CuentaId getCuentaId() {
        return cuentaId;
    }

    public Rol getRolCuenta() {
        return rolCuenta;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}
