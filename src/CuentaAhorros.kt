class CuentaAhorros(
    saldoInicial: Float,
    tasaAnual: Float
) : Cuenta(saldoInicial, tasaAnual) {

    var activa: Boolean = saldoInicial >= 10_000f
        private set // Pone como privado el atributo para el setter, pero publico para el get

    override fun consignar(monto: Float) {
        if (!activa) {
            println("Cuenta de ahorros inactiva: no se puede consignar.")
            return
        }
        super.consignar(monto)
    }

    override fun retirar(monto: Float): Boolean {
        if (!activa) {
            println("Cuenta de ahorros inactiva: no se puede retirar.")
            return false
        }
        return super.retirar(monto)
    }

    override fun extractoMensual() {
        val retirosExcedentes = (numeroRetiros - 4).coerceAtLeast(0)
        if (retirosExcedentes > 0) {
            comisionMensual += 1000f * retirosExcedentes
        }
        super.extractoMensual()
        activa = (saldo >= 10_000f)
    }

    override fun imprimir() {
        println("=== Cuenta de Ahorros ===")
        println("Saldo: $saldo")
        println("Comisión mensual (último corte): $comisionMensual")
        println("Transacciones (consignaciones + retiros): ${numeroConsignaciones + numeroRetiros}")
        println("¿Activa?: $activa")
    }
}
