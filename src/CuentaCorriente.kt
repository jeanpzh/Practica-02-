class CuentaCorriente(
    saldoInicial: Float,
    tasaAnual: Float
) : Cuenta(saldoInicial, tasaAnual) {

    private var sobregiro: Float = 0f

    override fun retirar(monto: Float): Boolean {
        if (monto <= saldo && monto > 0f) {
            saldo -= monto
        }
        else {
            val deficit = monto - saldo
            saldo = 0f
            sobregiro += deficit
        }
        numeroRetiros++
        return true
    }

    override fun consignar(monto: Float) {
        require(monto > 0f) { "El monto a consignar debe ser positivo." }
        var restante = monto

        if (sobregiro > 0f) {
            val cubre = minOf(sobregiro, restante)
            sobregiro -= cubre
            restante -= cubre
        }

        if (restante > 0f) {
            saldo += restante
        }
        numeroConsignaciones++
    }

    override fun extractoMensual() {
        super.extractoMensual()
    }

    override fun imprimir() {
        println("\n=== Cuenta Corriente ===")
        println("Saldo: $${"%.2f".format(saldo)}")
        println("Comisión mensual: $${"%.2f".format(comisionMensual)}")
        println("Número de transacciones: ${numeroConsignaciones + numeroRetiros}")
        println("Sobregiro: $${"%.2f".format(sobregiro)}")
    }
}
