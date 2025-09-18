class CuentaAhorros(
    saldoInicial: Float,
    tasaAnual: Float
) : Cuenta(saldoInicial, tasaAnual) {

    var activa: Boolean = saldoInicial >= 10_000f
        private set // Establece como privado el atributo para el setter, pero público para el get

    override fun consignar(monto: Float) {
        if (!activa) {
            println("Cuenta de ahorros inactiva: no se puede consignar.")
            return
        }
        super.consignar(monto)
    }

    override fun retirar(monto: Float): Boolean {
        return if (activa) {
            super.retirar(monto)
        } else {
            println("Cuenta de ahorros inactiva: no se puede consignar.")
            false
        }
    }

    override fun extractoMensual() {
        //CoerceAtLeast garantiza que el valor no sea menor a un mínimo asignado
        val retirosExcedentes = (numeroRetiros - 4).coerceAtLeast(0)
        if (retirosExcedentes > 0) {
            comisionMensual += 1000f * retirosExcedentes
        }
        super.extractoMensual()
        activa = (saldo >= 10_000f)
    }

    override fun imprimir() {
        println("\n=== Cuenta de Ahorros ===")
        println("Saldo: $${"%.2f".format(saldo)}")
        println("Comisión mensual: $${"%.2f".format(comisionMensual)}")
        println("Número de transacciones: ${numeroConsignaciones + numeroRetiros}")
        println("Estado: ${if (activa) "ACTIVA" else "INACTIVA"}")
    }
}
